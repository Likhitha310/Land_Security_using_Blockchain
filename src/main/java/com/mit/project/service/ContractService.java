package com.mit.project.service;

import com.mit.project.model.blockchain.LandContract;
import com.mit.project.properties.ContractProperties;
import org.springframework.beans.factory.annotation.Value;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple10;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;

public class ContractService {

    @Value("${land.contract.owner-address}")
    private String ownerAddressAdmin;

    private final String contractAddress;
    private final Web3j web3j;
    private final ContractProperties config;

    public ContractService(String contractAddress, Web3j web3j, ContractProperties config) {
        this.contractAddress = contractAddress;
        this.web3j = web3j;
        this.config = config;
    }

    public String getOwnerAddress(){
        return ownerAddressAdmin;
    }

    public void addLand(String ownerAddress,long id, long _surveyNumber, long _registrationNumber, long _registrationYear, long _mutationNumber, long _ownerId, String _district, String _areaOfLand, Boolean _taxPending, Boolean _loanPending, Boolean _pendingLitigation) throws Exception {
        LandContract contract = loadContract(ownerAddress);
        TransactionReceipt tr=contract.addLand(BigInteger.valueOf(id),BigInteger.valueOf(_surveyNumber),BigInteger.valueOf(_registrationNumber),BigInteger.valueOf(_registrationYear),BigInteger.valueOf(_mutationNumber),BigInteger.valueOf(_ownerId),_district,_areaOfLand,_taxPending,_loanPending,_pendingLitigation).send();
        System.out.println(tr);
    }

    @SuppressWarnings("unchecked")
    public Tuple10<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, Boolean, Boolean, Boolean> getLand(String ownerAddress, long id) throws Exception {
        LandContract contract = loadContract(ownerAddress);
        Tuple10<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, Boolean, Boolean, Boolean> data=contract.getland(BigInteger.valueOf(id)).send();
        System.out.println(data);
        return data;
    }

    @SuppressWarnings("unchecked")
    public BigInteger getOwner(String ownerAddress, long id) throws Exception {
        LandContract contract = loadContract(ownerAddress);
        BigInteger data=contract.getOwner(BigInteger.valueOf(id)).send();
        System.out.println(data);
        return data;
    }

    public void setLoanValue(String ownerAddress,long id,boolean loanPending) throws Exception {
        LandContract contract = loadContract(ownerAddress);
        TransactionReceipt tr=contract.setLoanValue(BigInteger.valueOf(id),loanPending).send();
        System.out.println(tr);
    }

    public void setTaxValue(String ownerAddress,long id,boolean taxPending) throws Exception {
        LandContract contract = loadContract(ownerAddress);
        TransactionReceipt tr=contract.setTaxValue(BigInteger.valueOf(id),taxPending).send();
        System.out.println(tr);
    }

    //complete Transaction
    public void transact(String ownerAddress,long id,long fromId,long toId,String date) throws Exception {
        LandContract contract = loadContract(ownerAddress);
        TransactionReceipt tr=contract.completeTransaction(BigInteger.valueOf(id),BigInteger.valueOf(fromId),BigInteger.valueOf(toId),date).send();
        System.out.println(tr);
    }

    //Transaction History
    public BigInteger getTransactionLength(long id) throws Exception {
        LandContract contract = loadContract(ownerAddressAdmin);
        return contract.getlength(BigInteger.valueOf(id)).send();
    }

    public Tuple3<BigInteger, BigInteger, String> getTransactionHistorybyId(long id, long i) throws Exception {
        LandContract contract = loadContract(ownerAddressAdmin);
        return contract.getTransactionHistorybyId(BigInteger.valueOf(id),BigInteger.valueOf(i)).send();
    }

    //Users
    public void addTahsildar(String ownerAddress, long id) throws Exception {
        LandContract contract = loadContract(ownerAddressAdmin);
        contract.addTahsildar(ownerAddress,BigInteger.valueOf(id)).send();
    }

    public void addRegistrar(String ownerAddress,long id) throws Exception {
        LandContract contract = loadContract(ownerAddressAdmin);
        contract.addRegistrar(ownerAddress,BigInteger.valueOf(id)).send();
    }

    public void addUser(String ownerAddress,long id) throws Exception {
        LandContract contract = loadContract(ownerAddressAdmin);
        contract.addUser(ownerAddress,BigInteger.valueOf(id)).send();
    }

    public void addSuperUser(String ownerAddress,long id) throws Exception {
        LandContract contract = loadContract(ownerAddressAdmin);
        contract.addSuperUser(ownerAddress,BigInteger.valueOf(id)).send();
    }
    private LandContract loadContract(String accountAddress) {
        return LandContract.load(contractAddress, web3j, txManager(accountAddress),config.gas());
    }

    private TransactionManager txManager(String accountAddress) {
        return new ClientTransactionManager(web3j, accountAddress);
    }
}
