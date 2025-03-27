package com.mit.project.controllers;

import com.mit.project.model.AdministratorDetails;
import com.mit.project.service.AdministratorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class AdministratorDetailsController {

    @Autowired
    private AdministratorDetailsService administratorDetailsService;


    @GetMapping("/TahsildarDetails")
    public List<AdministratorDetails> getAllDetails() {
        return administratorDetailsService.getAllDetails();
    }

    @GetMapping("/TahsildarDetails/{id}")
    public AdministratorDetails getTahsildarDetails(@PathVariable long id) {
        return administratorDetailsService.getAdministratorDetails(id);
    }

    @PostMapping("/TahsildarDetails")
    public ResponseEntity<?> addTahsildarDetails(@RequestBody AdministratorDetails tahsildarDetails) {
        administratorDetailsService.addAdministratorDetails(tahsildarDetails);
        return new ResponseEntity<>("Tahsildar Details Added Successfully", HttpStatus.OK);
    }

    @PutMapping("/TahsildarDetails/{id}")
    public ResponseEntity<?> updateTahsildarDetails(@RequestBody AdministratorDetails tahsildarDetails, @PathVariable long id) {
        administratorDetailsService.addAdministratorDetails(tahsildarDetails);
        return new ResponseEntity<>("Tahsildar Details  Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/TahsildarDetails/{id}")
    public ResponseEntity<?> deleteTahsildarDetails(@PathVariable long id) {
        administratorDetailsService.deleteAdministratorDetails(id);
        return new ResponseEntity<>("Tahsildar Details Deleted Successfully", HttpStatus.OK);
    }

    //SystemAddress
    @GetMapping("/SystemAddress/{id}")
    public String getSystemAddress(@PathVariable long id){
        return administratorDetailsService.getSystemAddress(id);
    }

    //Role Filter
    @GetMapping("/UsersByRole")
    public List<AdministratorDetails> findByUsernameAndRole(@RequestParam("username") String username, @RequestParam("role") String role) {
        if (username != null && username != "") {
            if (role != null && role != "") {
                return administratorDetailsService.findByUsernameAndRole(username, role);
            } else {
                return administratorDetailsService.findByUsername(username);
            }
        } else {
            return administratorDetailsService.findByRole(role);
        }
    }

    //authentication
    @GetMapping("/login")
    public AdministratorDetails logInAuthentication(@RequestParam("username") String username, @RequestParam("password") String password) {
        return administratorDetailsService.login(username, password);
    }
}
