package com.mit.project.controllers;

import com.mit.project.model.LandData;
import com.mit.project.service.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.web3j.tuples.generated.Tuple3;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class LandController {

	@Autowired
	private LandService landService;
	
	@GetMapping("/Lands")
	public List<LandData> getAllRecords() {
		return landService.getAllLands();
	}
	
	@GetMapping("/Lands/{id}")
	public LandData getLand(@PathVariable long id){
		return landService.getLand(id);
	}

	@PostMapping(value = "/Lands", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<?> addLands(@RequestParam("file") MultipartFile file, @RequestParam("surveyNo") String surveyNo,@RequestParam("registrationNo") String registrationNo,@RequestParam("registrationYear") String registrationYear,
									  @RequestParam("propertyType") String propertyType,@RequestParam("address") String address,
									  @RequestParam("city") String city, @RequestParam("district") String district,
									  @RequestParam("taluka") String taluka, @RequestParam("pincode") String pincode,
									  @RequestParam("ownerName") String ownerName,@RequestParam("ownerAadhar")  String ownerAadhar,
									  @RequestParam("user") long userId, @RequestParam("mutationNumber") String mutationNumber,
									  @RequestParam("areaOfLand") String areaOfLand, @RequestParam("typeOfLand") String typeOfLand,
									  @RequestParam("typeOfIrrigation") String typeOfIrrigation, @RequestParam("detailsOfPendingLitigation") boolean detailsOfPendingLitigation,
									  @RequestParam("taxPaid") boolean taxPaid, @RequestParam("loanPending") boolean loanPending,
									  @RequestParam("typeOfCrop") String typeOfCrop,@RequestParam("ownerAddress") String ownerAddress) throws IOException {
		LandData landData =new LandData();
		landData.setSurveyNo(surveyNo);
		landData.setRegistrationNo(registrationNo);
		landData.setRegistrationYear(registrationYear);
		landData.setPropertyType(propertyType);
		landData.setAddress(address);
		landData.setCity(city);
		landData.setDistrict(district);
		landData.setTaluka(taluka);
		landData.setPincode(pincode);
		landData.setOwnerName(ownerName);
		landData.setOwnerAadhar(ownerAadhar);
		landData.setUserId(userId);
		landData.setMutationNumber(mutationNumber);
		landData.setAreaOfLand(areaOfLand);
		landData.setTypeOfLand(typeOfLand);
		landData.setTypeOfIrrigation(typeOfIrrigation);
		landData.setDetailsOfPendingLitigation(detailsOfPendingLitigation);
		landData.setTaxPaid(taxPaid);
		landData.setLoanPending(loanPending);
		landData.setTypeOfCrop(typeOfCrop);
		landData.setData(file.getBytes());
		System.out.println(landData);
		landService.addLand(landData,ownerAddress);
		return new ResponseEntity<>("Land Saved Successfully", HttpStatus.OK);
	}

	@PostMapping("/UpdateLands/{id}")
	public ResponseEntity<?> addLands(@PathVariable long id, @RequestBody LandData landData) {
		landService.updateLand(id, landData);
		return new ResponseEntity<>("Land Updated Successfully", HttpStatus.OK);
	}

	@PutMapping("/Lands/{id}")
	public ResponseEntity<?> updateLand(@PathVariable long id, @RequestBody LandData landData) {
		landService.updateLand(id, landData);
		return new ResponseEntity<>("Land Updated Successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/Lands/{id}")
	public ResponseEntity<?> deleteLand(@PathVariable long id){
		 landService.deleteLand(id);
		return new ResponseEntity<>("Land Deleted Successfully", HttpStatus.OK);
	}

	@GetMapping("/LandDocument")
	public byte[] getAllIds(long id) {
		return landService.getLand(id).getData();
	}

	@GetMapping("/LandIdsUnder")
	public List<Long> getAllIds(@RequestParam("district") String district,@RequestParam("taluka") String taluka) {
		return landService.getAllIds(district, taluka);
	}

	@GetMapping("/validLand")
	public boolean isValidLand(@RequestParam("id") long id,@RequestParam("surveyNo") String surveyNo,@RequestParam("registrationNo") String registrationNo,@RequestParam("registrationYear") String registrationYear,@RequestParam("name") String name){
		return landService.isValidData(id,surveyNo,registrationNo,registrationYear,name);
	}

	@GetMapping("/OwnedLands/{id}")
	public List<Long> getByOwnerId(@PathVariable("id") Long ownerId){
		return landService.findAllLands(ownerId);
	}

	@GetMapping("/LandHistory/{id}")
	public ArrayList<Tuple3<BigInteger, BigInteger, String>> getHistory(@PathVariable long id) throws Exception {
		return landService.getHistory(id);
	}

	@PostMapping("/LandTransfer")
	public ResponseEntity<String> transferLand(@RequestParam("ownerAddress") String ownerAddress, @RequestParam("landId") long id, @RequestParam("toId") long toId, @RequestParam("transactionId") long transactionId, @RequestParam("file") MultipartFile file) throws Exception {
		int val=landService.transferLand(ownerAddress,id,toId,transactionId,file);
		if(id==0)
			return new ResponseEntity<>("Land is Locked!\n Please clear loan/tax first", HttpStatus.OK);
		else if(id==1)
			return new ResponseEntity<>("Land Transfered Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Land Transfered Failed", HttpStatus.OK);
	}
}
