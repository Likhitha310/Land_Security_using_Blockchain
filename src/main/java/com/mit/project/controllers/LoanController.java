package com.mit.project.controllers;

import com.mit.project.model.Loan;
import com.mit.project.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/Loans")
    public List<Loan> getAllLoans(){
        return loanService.getAllLoans();
    }

    @GetMapping("/Loans/{id}")
    public Loan getLoan(@PathVariable long id){
        return loanService.getLoan(id);
    }

    @PostMapping("/Loans")
    public ResponseEntity<?> addLoans(@RequestBody Loan loan) {
        loanService.addLoan(loan);
        return new ResponseEntity<>("Loan Added Successfully", HttpStatus.OK);
    }

    @PutMapping("/Loans/{id}")
    public ResponseEntity<?> updateLoan(@RequestBody Loan loan,@PathVariable long id) {
        loanService.updateLand(id,loan);
        return new ResponseEntity<>("Loan Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/Loans/{id}")
    public ResponseEntity<?> deleteLoan(@PathVariable long id){
        loanService.deleteLand(id);
        return new ResponseEntity<>("Loan Deleted Successfully", HttpStatus.OK);
    }

    //Filter Data
    @GetMapping("/LoansFilteredData")
    public List<Loan> getLoanFilteredData(@RequestParam("userId") String userId,@RequestParam("landId") String landId){
        return loanService.getFilteredData(userId, landId);
    }
}
