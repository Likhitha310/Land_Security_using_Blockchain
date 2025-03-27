package com.mit.project.service;

import com.mit.project.model.CorrectionRequests;
import com.mit.project.repository.CorrectionRequestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class CorrectionRequestsService {

    @Autowired
    private CorrectionRequestsRepository correctionRequestsRepository;

    @Autowired
    private LandService service;

    @Autowired
    private NotificationsService notifications;

    public List<CorrectionRequests> getAllRequests(){
        return correctionRequestsRepository.findAll();
    }

    public CorrectionRequests getCorrectionRequest(long id) {
        return correctionRequestsRepository.findById(id).get();
    }

    public void addCorrectionRequest(MultipartFile file, CorrectionRequests correctionRequests) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        correctionRequests.setDocumentName(fileName);
        correctionRequests.setDocumentType(file.getContentType());
        correctionRequests.setData(file.getBytes());
        correctionRequestsRepository.save(correctionRequests);
        service.setLock(Long.parseLong(correctionRequests.getLandId()),true);
    }

    public void updateCorrectionRequests(long id,CorrectionRequests correctionRequests) {
        correctionRequestsRepository.save(correctionRequests);
    }

    public void deleteCorrectionRequests(long id) {
        correctionRequestsRepository.deleteById(id);
    }

    //update competed mark
    public void completeRequest(long id){
        CorrectionRequests request=correctionRequestsRepository.findById(id).get();
        request.setCompleted(true);
        correctionRequestsRepository.save(request);
        service.setLock(Long.parseLong(request.getLandId()),false);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        notifications.addNotification(request.getOwnerId(),"SYSTEM","Private","Land Correction request","Land Correction request sucessfully completed.", String.valueOf(timestamp));
    }

    //Filter records
    public List<Object[]> getCorrectionRequestByLandId(String landId) {
        return correctionRequestsRepository.findByLandId(landId);
    }

    public List<Object[]> getAllRecords() {
        return correctionRequestsRepository.findAllRecords();
    }

    public List<Object[]> getRecordById(long id){
        return correctionRequestsRepository.findRecordById(id);
    }

    public long getCorrectedCount(){
        //LandIdbydistrictandTaluka
        //all correction id where landIds= landId
        return 1;
    }
}
