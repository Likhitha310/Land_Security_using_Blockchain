package com.mit.project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UserDetails")
public class UserDetails {
    @Id
    @GeneratedValue
    private long userId;
    private String role;
    private String username;
    private String password;

    private String name;
    private String aadharNo;
    private String dob;
    private String gender;
    private String occupation;
    private String mobileNo;
    private String address;
    private String emailId;
    private String idProofType;
    private String documentName;
    private String documentType;
    @Lob
    private byte[] data;

    public UserDetails(){}

    public UserDetails(long userId, String role, String username, String password, String name, String aadharNo, String dob, String gender, String occupation, String mobileNo, String address, String emailId, String idProofType, String documentName, String documentType, byte[] data) {
        this.userId = userId;
        this.role = role;
        this.username = username;
        this.password = password;
        this.name = name;
        this.aadharNo = aadharNo;
        this.dob = dob;
        this.gender = gender;
        this.occupation = occupation;
        this.mobileNo = mobileNo;
        this.address = address;
        this.emailId = emailId;
        this.idProofType = idProofType;
        this.documentName = documentName;
        this.documentType = documentType;
        this.data = data;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getIdProofType() {
        return idProofType;
    }

    public void setIdProofType(String idProofType) {
        this.idProofType = idProofType;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
