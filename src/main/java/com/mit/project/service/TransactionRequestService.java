package com.mit.project.service;

import com.mit.project.model.TransactionRequest;
import com.mit.project.model.UserDetails;
import com.mit.project.repository.TransactionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class TransactionRequestService {
    @Autowired
    private TransactionRequestRepository transactionRequestRepository;

    @Autowired
    private LandService landService;

    @Autowired
    private AdministratorDetailsService administratorDetailsService;

    @Autowired
    private NotificationsService notifications;

    public List<TransactionRequest> getALlRequest(){
        return transactionRequestRepository.findAll();
    }

    public TransactionRequest getTransactionRequest(long id){
        return transactionRequestRepository.findById(id).get();
    }

    public int addTransactionRequest(TransactionRequest transactionRequest){
        if(landService.isLock(transactionRequest.getLandId())){
            return 1;
        }
        transactionRequestRepository.save(transactionRequest);
        landService.setLock(transactionRequest.getLandId(),true);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        notifications.addNotification(String.valueOf(transactionRequest.getBuyerId()),"System","Private","Transaction request","Transaction request Added to system for land id"+transactionRequest.getLandId(), String.valueOf(timestamp));
        return 2;
    }

    public void updateTransactionRequest(long id,TransactionRequest transactionRequest) {
        transactionRequestRepository.save(transactionRequest);
    }

    public void deleteTransactionRequest(long id) {
        transactionRequestRepository.deleteById(id);
        landService.setLock(transactionRequestRepository.findById(id).get().getLandId(),false);
    }
}
