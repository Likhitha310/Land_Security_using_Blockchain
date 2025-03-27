package com.mit.project;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
public class test {
    public static void main(String[] args) {
        try {
            Web3j web3 = Web3j.build(new HttpService("http://localhost:8545"));
            String clientVersion = web3.web3ClientVersion().send().getWeb3ClientVersion();
            System.out.println("Connected to Ethereum client: " + clientVersion);
        } catch (Exception e) {
            System.out.println("Error connecting to Ethereum: " + e.getMessage());
        }
    }
}
