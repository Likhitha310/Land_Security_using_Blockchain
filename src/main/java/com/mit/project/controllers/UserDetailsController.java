package com.mit.project.controllers;

import com.mit.project.model.UserDetails;
import com.mit.project.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController

public class UserDetailsController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/UserDetails")
    public List<UserDetails> getAllUserDetails(){
        return userDetailsService.getAllDetails();
    }

    @GetMapping("/UserDetails/{id}")
    public UserDetails getUserDetails(@PathVariable long id){
        return userDetailsService.getUserDetails(id);
    }

    @PostMapping(value = "/UserDetails", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<?> AddUserDetails(@RequestParam("file") MultipartFile file,@RequestParam("name") String name,@RequestParam("aadharNo") String aadharNo,@RequestParam("dob") String dob,@RequestParam("gender") String gender,@RequestParam("occupation") String occupation,@RequestParam("mobileNo") String mobileNo,@RequestParam("address") String address,@RequestParam("emailId") String emailId,@RequestParam("idProofType") String idProofType,@RequestParam("role") String role,@RequestParam("username") String username,@RequestParam("password") String password){
        UserDetails userDetails=new UserDetails();
        userDetails.setName(name);
        userDetails.setAadharNo(aadharNo);
        userDetails.setDob(dob);
        userDetails.setGender(gender);
        userDetails.setOccupation(occupation);
        userDetails.setMobileNo(mobileNo);
        userDetails.setAddress(address);
        userDetails.setEmailId(emailId);
        userDetails.setIdProofType(idProofType);
        userDetails.setUsername(username);
        userDetails.setRole(role);
        userDetails.setPassword(password);
        try {
            userDetailsService.addUserDetails(file,userDetails);
            return new ResponseEntity<>(" User Details Added Successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error while Adding User Details!!", HttpStatus.OK);
        }
    }

    @PutMapping("/UserDetails/{id}")
    public ResponseEntity<?> updateUserDetails (@RequestBody UserDetails UserDetails, @PathVariable long id) {
        userDetailsService.updateUserDetails(id,UserDetails);
        return new ResponseEntity<>("User Details Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/UserDetails/{id}")
    public ResponseEntity<?> deleteUserDetails(@PathVariable long id){
        userDetailsService.deleteUserDetails(id);
        return new ResponseEntity<>("User Details Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/UserDetails/file/{id}")
    public byte[] getFileById(@PathVariable long id) {
        UserDetails userDetails = userDetailsService.getUserDetails(id);
        return userDetails.getData();
    }

    @GetMapping("/UserName/{id}")
    public String getNameById(@PathVariable long id) {
        return userDetailsService.getName(id);
    }

    @GetMapping("/UserLogin")
    public UserDetails login(@RequestParam("username") String username,@RequestParam("password") String password) {
        UserDetails userDetails = userDetailsService.login(username,password);
        return userDetails;
    }
}
