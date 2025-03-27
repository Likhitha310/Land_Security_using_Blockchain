package com.mit.project.controllers;
/*
* This is for smart-contract Testing purpose.
*
* */
import java.math.BigInteger;

import com.mit.project.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.web3j.tuples.generated.Tuple10;
import org.web3j.tuples.generated.Tuple3;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping("/test/owner")
    public String getAddress() {
        return contractService.getOwnerAddress();
    }

    @GetMapping("/test/getLand")
    public Tuple10<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, Boolean, Boolean, Boolean> getLandData(@RequestParam("ownerAddress") String ownerAddress, @RequestParam("id") long id) throws Exception {
        return contractService.getLand(ownerAddress,id);
    }

    @GetMapping("/test/getOwner")
    public BigInteger getOwner(@RequestParam("ownerAddress") String ownerAddress,@RequestParam("id") long id) throws Exception {
        return contractService.getOwner(ownerAddress,id);
    }

    @PostMapping("/test/addLand")
    public void addLand(@RequestParam("ownerAddress") String ownerAddress,@RequestParam("id") long id,@RequestParam("surveyNumber") long surveyNumber,@RequestParam("registrationNumber") long registrationNumber,@RequestParam("registrationYear") long registrationYear,@RequestParam("mutationNumber") long mutationNumber,@RequestParam("ownerId") long ownerId,@RequestParam("district") String district,@RequestParam("areaOfLand") String areaOfLand,@RequestParam("taxPending") Boolean taxPending,@RequestParam("loanPending") Boolean loanPending,@RequestParam("pendingLitigation") Boolean pendingLitigation) throws Exception {
        contractService.addLand(ownerAddress,id,surveyNumber,registrationNumber,registrationYear,mutationNumber,ownerId,district,areaOfLand,taxPending,loanPending,pendingLitigation);
    }

    @PostMapping("/test/setLoanValue")
    public void setLoanValue(@RequestParam("ownerAddress") String ownerAddress,@RequestParam("id") long id,@RequestParam("loanPending") Boolean loanPending) throws Exception {
        contractService.setLoanValue(ownerAddress,id,loanPending);
    }

    @PostMapping("/test/setTaxValue")
    public void setTaxValue(@RequestParam("ownerAddress") String ownerAddress,@RequestParam("id") long id,@RequestParam("tax") Boolean tax) throws Exception {
        contractService.setTaxValue(ownerAddress,id,tax);
    }

    @PostMapping("/test/Transact")
    public void transact(@RequestParam("ownerAddress") String ownerAddress,@RequestParam("id") long id,@RequestParam("fromId") long fromId,@RequestParam("toId") long toId,@RequestParam("date") String date) throws Exception {
        contractService.transact(ownerAddress,id,fromId,toId,date);
    }

    //Transaction History
    @GetMapping("/test/getTransactionLength")
    public BigInteger getTransactionLength(@RequestParam("id") long id) throws Exception {
        return contractService.getTransactionLength(id);
    }

    @GetMapping("/test/getTransactionHistorybyId")
    public Tuple3<BigInteger, BigInteger, String> getTransactionHistorybyId(@RequestParam("id") long id, @RequestParam("i") long i) throws Exception {
        return contractService.getTransactionHistorybyId(id,i);
    }

    //Users
    @PostMapping("/test/setTahsildar")
    public void setTahsildar(@RequestParam("ownerAddress") String ownerAddress,@RequestParam("id") long id) throws Exception {
        contractService.addTahsildar(ownerAddress,id);
    }

    @PostMapping("/test/setRegistrar")
    public void setRegistrar(@RequestParam("ownerAddress") String ownerAddress,@RequestParam("id") long id) throws Exception {
        contractService.addRegistrar(ownerAddress,id);
    }

    @PostMapping("/test/setUser")
    public void setUser(@RequestParam("ownerAddress") String ownerAddress,@RequestParam("id") long id) throws Exception {
        contractService.addUser(ownerAddress,id);
    }

    @PostMapping("/test/setSuperUser")
    public void setSuperUser(@RequestParam("ownerAddress") String ownerAddress,@RequestParam("id") long id) throws Exception {
        contractService.addSuperUser(ownerAddress,id);
    }
}
