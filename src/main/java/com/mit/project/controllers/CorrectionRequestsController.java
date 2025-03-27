package com.mit.project.controllers;

import com.mit.project.model.CorrectionRequests;
import com.mit.project.service.CorrectionRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class CorrectionRequestsController {

    @Autowired
    private CorrectionRequestsService correctionRequestsService;

    @GetMapping("/CorrectionRequests")
    public List<CorrectionRequests> getAllCorrectionRequests()
    {
        return correctionRequestsService.getAllRequests();
    }

    @GetMapping("/CorrectionRequests/{id}")
    public CorrectionRequests getCorrectionRequests(@PathVariable long id){
        return correctionRequestsService.getCorrectionRequest(id);
    }

    @PostMapping("/CorrectionRequests")
    public ResponseEntity<?> addCorrectionRequests(@RequestParam("file") MultipartFile file,@RequestParam("ownerId") String ownerId,@RequestParam("landId") String landId, @RequestParam("correctionFields") String correctionFields,@RequestParam("correctValues") String correctValues,@RequestParam("details") String details) {
        try {
            CorrectionRequests correctionRequests=new CorrectionRequests();
            correctionRequests.setOwnerId(ownerId);
            correctionRequests.setLandId(landId);
            correctionRequests.setCorrectionFields(correctionFields);
            correctionRequests.setCorrectValues(correctValues);
            correctionRequests.setDetails(details);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            correctionRequests.setTimestamp(String.valueOf(timestamp));
            correctionRequestsService.addCorrectionRequest(file,correctionRequests);
            return new ResponseEntity<>("Correction Requests Added Successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Correction Requests Failed!!", HttpStatus.OK);
        }
    }

    @PutMapping("/CorrectionRequests/{id}")
    public ResponseEntity<?> updateCorrectionRequests(@RequestBody CorrectionRequests correctionRequests,@PathVariable long id) {
        correctionRequestsService.updateCorrectionRequests(id,correctionRequests);
        return new ResponseEntity<>("Correction Requests Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/CorrectionRequests/{id}")
    public ResponseEntity<?> deleteCorrectionRequests(@PathVariable long id){
        correctionRequestsService.deleteCorrectionRequests(id);
        return new ResponseEntity<>("Correction Requests Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/CorrectionRequestComplete")
    public ResponseEntity<?> getByLandId(@RequestParam("landId") long landId){
        correctionRequestsService.completeRequest(landId);
        return new ResponseEntity<>("Correction Requests Completed Successfully", HttpStatus.OK);
    }

    //Filters
    @GetMapping("/CorrectionRequestsByLandId")
    public List<Object[]> getByLandId(@RequestParam("landId") String landId){
        return correctionRequestsService.getCorrectionRequestByLandId(landId);
    }

    @GetMapping("/CorrectionRequestsList")
    public List<Object[]> getAllRecords(){
        return correctionRequestsService.getAllRecords();
    }

    @GetMapping("/CorrectionRequestsListById")
    public List<Object[]> getAllRecords(@RequestParam("id") long id){
        return correctionRequestsService.getRecordById(id);
    }
}
