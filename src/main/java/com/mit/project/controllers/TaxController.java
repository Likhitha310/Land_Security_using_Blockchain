package com.mit.project.controllers;

import com.mit.project.model.Tax;
import com.mit.project.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class TaxController {

    @Autowired
    private TaxService taxService;

    @GetMapping("/Taxes")
    public List<Tax> getAllTaxes(){
        return taxService.getAllTaxes();
    }

    @GetMapping("/Taxes/{id}")
    public Tax getTax(@PathVariable long id){
        return taxService.getTax(id);
    }

    @PostMapping("/Taxes")
    public ResponseEntity<?> addTax(@RequestBody Tax tax) {
        taxService.addTax(tax);
        return new ResponseEntity<>("Tax Added Successfully", HttpStatus.OK);
    }

    @PutMapping("/Taxes/{id}")
    public ResponseEntity<?> updateTax(@RequestBody Tax tax,@PathVariable long id) {
        taxService.updateTax(id,tax);
        return new ResponseEntity<>("Tax Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/Taxes/{id}")
    public ResponseEntity<?> deleteTax(@PathVariable long id){
        taxService.deleteTax(id);
        return new ResponseEntity<>("Tax Deleted Successfully", HttpStatus.OK);
    }

    //Filter Data
    @GetMapping("/TaxesFilteredData")
    public List<Tax> getTaxFilteredData(@RequestParam("userId") String userId, @RequestParam("landId") String landId){
        return taxService.getFilteredData(userId, landId);
    }
}