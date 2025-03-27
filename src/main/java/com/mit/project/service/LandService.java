package com.mit.project.service;

import com.mit.project.model.LandData;
import com.mit.project.repository.LandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.web3j.tuples.generated.Tuple3;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class LandService {

	@Autowired
	private LandRepository landRepository;

	@Autowired
	private ContractService service;

	@Autowired
	private UserDetailsService userService;

	@Autowired
	private NotificationsService notifications;

	@Autowired
	private TransactionRequestService transactionRequestService;

	public List<LandData> getAllLands(){
		return landRepository.findAll();
	}
	
	public LandData getLand(long id) {
		return landRepository.findById(id).get();
	}
	
	public void addLand(LandData landData,String ownerAddress){
		LandData l=landRepository.save(landData);
		landRepository.flush();
		try {
			service.addLand(ownerAddress,l.getId(),Long.valueOf(l.getSurveyNo()),Long.valueOf(l.getRegistrationNo()),Long.valueOf(l.getRegistrationYear()),Long.valueOf(l.getMutationNumber()),l.getUserId(),l.getDistrict(),l.getAreaOfLand(),l.isTaxPaid(),l.isLoanPending(),l.isDetailsOfPendingLitigation());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		notifications.addNotification(String.valueOf(l.getUserId()),"Tahsildar","Private","Land Allocated","new Land Allocated to you", String.valueOf(timestamp));
	}

	public void updateLand(long id, LandData landData) {
		landRepository.save(landData);
	}

	public void deleteLand(long id) {
		landRepository.deleteById(id);
	}

	public List<Long> getAllIds(String district,String taluka){
		return landRepository.findAllIdsByDistricAndTaluka(district, taluka);
	}

	public boolean isLock(long id){
		return landRepository.findById(id).get().isLockedData();
	}

	public void setLock(long id,boolean val){
		landRepository.findById(id).get().setLockedData(val);
	}

	public LandData getFile(long id){
		return landRepository.findById(id).get();
	}

	public ArrayList<Tuple3<BigInteger, BigInteger, String>> getHistory(long id) throws Exception {
		int n= service.getTransactionLength(id).intValue();
		ArrayList<Tuple3<BigInteger, BigInteger, String>> arrayList=new ArrayList<Tuple3<BigInteger, BigInteger, String>>();
		for(int i=0; i<n;i++){
			arrayList.add(service.getTransactionHistorybyId(id,i));
		}
		return arrayList;
	}

	public boolean isValidData(long id,String surveyNo, String registrationNo, String registrationYear, String name){
		LandData l=landRepository.findById(id).get();
		if(l.getSurveyNo()==surveyNo && l.getRegistrationNo()==registrationNo && l.getRegistrationYear()==registrationYear && l.getOwnerName()==name){
			return true;
		}
		return false;
	}

	public List<Long> findAllLands(long id){
		return landRepository.findAllLands(id);
	}
	public Stream<LandData> getAllFiles(){
		return landRepository.findAll().stream();
	}

	public int transferLand(String ownerAddress, long id, long toId, long transactionId, MultipartFile file) throws Exception {
		if(isLock(id)){	//check land is not locked
			return -1;
		}
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//update land data
		LandData l=landRepository.findById(id).get();
		long owner = l.getUserId();
		l.setLockedData(false);
		l.setUserId(toId);
		l.setOwnerName(userService.getName(toId));
		l.setOwnerAadhar(userService.getUserDetails(toId).getAadharNo());
		l.setData(file.getBytes());
		//Update land
		updateLand(id,l);
		//Blockchain Transaction
		service.transact(ownerAddress,id,owner,toId, String.valueOf(timestamp));
		//delete request
		transactionRequestService.deleteTransactionRequest(transactionId);
		//Notification
		notifications.addNotification(String.valueOf(owner),"Tahsildar","Private","Land Transaction Completed","Land Transaction Request Completed Sucessfully.", String.valueOf(timestamp));
		notifications.addNotification(String.valueOf(toId),"Tahsildar","Private","Land Allocation Completed","New Land Allocated Sucessfully.", String.valueOf(timestamp));
		return 1;
	}
}
