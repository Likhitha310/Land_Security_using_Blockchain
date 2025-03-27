package com.mit.project.service;

import com.mit.project.model.Tax;
import com.mit.project.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TaxService {

    @Autowired
    private TaxRepository taxRepository;

    @Autowired
    private NotificationsService notifications;

    public List<Tax> getAllTaxes(){
        return taxRepository.findAll();
    }

    public Tax getTax(long id){
        return taxRepository.findById(id).get();
    }

    public void addTax(Tax tax){
        taxRepository.save(tax);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        notifications.addNotification(String.valueOf(tax.getUserId()),"Tahsildar","Private","Tax Pending","Tax is pending for land id "+tax.getLandId(), String.valueOf(timestamp));
    }

    public void updateTax(long id, Tax tax) {
        taxRepository.save(tax);
    }

    public void deleteTax(long id) {
        taxRepository.deleteById(id);
    }

    public List<Tax> getFilteredData(String userId, String landId){
        if(userId!=""){
            if(landId!=""){
                return taxRepository.findByUserIdAndLandId(userId, landId);
            }
            return taxRepository.findByUserId(userId);
        }
        else if(landId!="") {
            return taxRepository.findByLandId(landId);
        }
        return taxRepository.findAll();
    }
}
