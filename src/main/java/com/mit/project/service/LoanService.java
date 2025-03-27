package com.mit.project.service;

import com.mit.project.model.Loan;
import com.mit.project.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private NotificationsService notifications;

    public List<Loan> getAllLoans(){
        return loanRepository.findAll();
    }

    public Loan getLoan(long id){
        return loanRepository.findById(id).get();
    }

    public void addLoan(Loan loan){
        loanRepository.save(loan);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        notifications.addNotification(String.valueOf(loan.getUserId()),"Tahsildar","Private","Loan Details Added","Loan is pending for land id "+loan.getLandId(), String.valueOf(timestamp));
    }

    public void updateLand(long id, Loan loan) {
        loanRepository.save(loan);
    }

    public void deleteLand(long id) {
        loanRepository.deleteById(id);
    }

    public List<Loan> getFilteredData(String userId,String landId){
        if(userId!=""){
            if(landId!=""){
                return loanRepository.findByUserIdAndLandId(userId, landId);
            }
            return loanRepository.findByUserId(userId);
        }
        else if(landId!="") {
            return loanRepository.findByLandId(landId);
        }
        return loanRepository.findAll();
    }
}
