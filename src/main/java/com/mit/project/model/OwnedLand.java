package com.mit.project.model;

import javax.persistence.*;

@Entity @IdClass(OwnedLandsKey.class)
@Table(name = "ownedLands")
public class OwnedLand {

    @Id
    private String ownerId;
    @Id
    private String landId;

    public OwnedLand(){}

    public OwnedLand(String ownerId, String landId) {
        this.ownerId = ownerId;
        this.landId = landId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getLandId() {
        return landId;
    }

    public void setLandId(String landId) {
        this.landId = landId;
    }
}
