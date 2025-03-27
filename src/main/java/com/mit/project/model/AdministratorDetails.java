package com.mit.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administratorDetails")
public class AdministratorDetails {

    @Id
    @GeneratedValue
    private long id;
    private String role;
    private String username;
    private String password;

    private String name;
    private String district;
    private String taluka;
    private String systemAddress;

    //Constructors
    public AdministratorDetails(){}

    public AdministratorDetails(long id, String role, String username, String password, String name,String district, String taluka, String systemAddress) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.name = name;
        this.district = district;
        this.taluka = taluka;
        this.systemAddress = systemAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTaluka() {
        return taluka;
    }

    public void setTaluka(String taluka) {
        this.taluka = taluka;
    }

    public String getSystemAddress() {
        return systemAddress;
    }

    public void setSystemAddress(String systemAddress) {
        this.systemAddress = systemAddress;
    }
}
