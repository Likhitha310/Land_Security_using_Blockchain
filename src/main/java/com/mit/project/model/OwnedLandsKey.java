package com.mit.project.model;

import java.io.Serializable;

public class OwnedLandsKey implements Serializable {

    private String ownerId;
    private String landId;

    public OwnedLandsKey(){}

    public OwnedLandsKey(String ownerId, String landId) {
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

    public int hashCode() {
        return (int)this.ownerId.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof OwnedLandsKey)) return false;
        OwnedLandsKey pk = (OwnedLandsKey) obj;
        return pk.ownerId.equals(this.ownerId) && pk.landId.equals(this.landId);
    }
}
