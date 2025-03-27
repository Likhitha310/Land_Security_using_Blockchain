package com.mit.project.config;

import okhttp3.OkHttpClient;
import com.mit.project.model.blockchain.LandContract;
import com.mit.project.properties.ContractProperties;
import com.mit.project.service.ContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;

@Configuration
public class ContractConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(ContractConfiguration.class);

    @Value("${land.contract.owner-address}")
    private String ownerAddress;

    @Value("${web3j.client-address}")
    private String clientAddress;

    @Autowired
    private ContractProperties config;

    @Bean
    public Web3j web3j() {
        return Web3j.build(new HttpService(clientAddress, new OkHttpClient.Builder().build()));
    }

    @Bean
    public ContractService contract(Web3j web3j, @Value("${land.contract.address:}") String contractAddress)
            throws Exception {
        if (StringUtils.isEmpty(contractAddress)) {
            System.out.println("started");
            LandContract contract = deployContract(web3j);
            return initLotteryService(contract.getContractAddress(), web3j);
        }

        return initLotteryService(contractAddress, web3j);
    }

    private ContractService initLotteryService(String contractAddress, Web3j web3j) {
        return new ContractService(contractAddress, web3j, config);
    }

    private LandContract deployContract(Web3j web3j) throws Exception {
        System.out.println("About to deploy new contract...");
        LandContract contract = LandContract.deploy(web3j, txManager(web3j), config.gas()).send();
        System.out.println("Deployed new contract with address '{"+contract.getContractAddress()+"}'");
        System.out.println(contract.getContractAddress());
        return contract;
    }

    private TransactionManager txManager(Web3j web3j) {
        return new ClientTransactionManager(web3j, ownerAddress);
    }

}
