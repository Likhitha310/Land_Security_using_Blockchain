package com.mit.project.service;

import com.mit.project.model.OwnedLand;
import com.mit.project.repository.OwnedLandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnedLandsService {
    @Autowired
    private OwnedLandsRepository ownedLandsRepository;

    public List<OwnedLand> getAll(){
        return ownedLandsRepository.findAll();
    }

    public List<OwnedLand> getOwnedLand(String ownerId){
        return ownedLandsRepository.findByOwnerId(ownerId);
    }

    public void addData(OwnedLand ownedLand){
        ownedLandsRepository.save(ownedLand);
    }

    public void deleteData(OwnedLand ownedLand){
        ownedLandsRepository.delete(ownedLand);
    }

    public void deleteById(String ownerId){
        ownedLandsRepository.deleteByOwnerId(ownerId);
    }
}
