package com.mit.project.controllers;

import com.mit.project.model.Tax;
import com.mit.project.model.TransactionRequest;
import com.mit.project.service.TransactionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TransactionRequestController {

    @Autowired
    private TransactionRequestService transactionRequestService;

    @GetMapping("/TransactionRequest")
    public List<TransactionRequest> getAllTransactionRequest(){
        return transactionRequestService.getALlRequest();
    }

    @GetMapping("/TransactionRequest/{id}")
    public TransactionRequest getTransactionRequest(@PathVariable long id){
        return transactionRequestService.getTransactionRequest(id);
    }

    @PostMapping("/TransactionRequest")
    public ResponseEntity<?> addTax(@RequestBody TransactionRequest transactionRequest) {
        int res=transactionRequestService.addTransactionRequest(transactionRequest);
        if(res==2)
            return new ResponseEntity<>("Transaction Request Added Successfully", HttpStatus.OK);
        else if(res==1)
            return new ResponseEntity<>("Cannot Transfer Lock Land.\nPlease clear loan/tax first.\nTransaction Request Failed.", HttpStatus.OK);
        else
            return new ResponseEntity<>("Error while saving data", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/TransactionRequest/{id}")
    public ResponseEntity<?> updateTransactionRequest(@RequestBody TransactionRequest transactionRequest,@PathVariable long id) {
        transactionRequestService.updateTransactionRequest(id,transactionRequest);
        return new ResponseEntity<>("Transaction Request Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/TransactionRequest/{id}")
    public ResponseEntity<?> deleteTax(@PathVariable long id){
        transactionRequestService.deleteTransactionRequest(id);
        return new ResponseEntity<>("Transaction Request Deleted Successfully", HttpStatus.OK);
    }
}
