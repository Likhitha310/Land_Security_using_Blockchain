package com.mit.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tax")
public class Tax {

    @Id
    private long id;
    private String userId;
    private String landId;
    private String amount;
    private String duration;
    private String description;

    public Tax(){}

    public Tax(long id, String userId, String landId, String amount, String duration, String description) {
        this.id = id;
        this.userId = userId;
        this.landId = landId;
        this.amount = amount;
        this.duration = duration;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLandId() {
        return landId;
    }

    public void setLandId(String landId) {
        this.landId = landId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
