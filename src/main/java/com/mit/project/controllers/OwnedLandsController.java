package com.mit.project.controllers;

import com.mit.project.model.OwnedLand;
import com.mit.project.service.OwnedLandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class OwnedLandsController {
    @Autowired
    private OwnedLandsService ownedLandsService;

    @GetMapping("/OwnedLands")
    public List<OwnedLand> getAll(){
        return ownedLandsService.getAll();
    }



    @PostMapping("/OwnedLands")
    public ResponseEntity<?> addOwnedLands(@RequestBody OwnedLand ownedLand) {
        ownedLandsService.addData(ownedLand);
        return new ResponseEntity<>("Owned Lands Data Added Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/OwnedLands")
    public ResponseEntity<?> deleteOwnedLands(@RequestBody OwnedLand ownedLand){
        ownedLandsService.deleteData(ownedLand);
        return new ResponseEntity<>("Owned Lands Deleted Successfully", HttpStatus.OK);
    }
}
