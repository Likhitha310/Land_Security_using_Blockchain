package com.mit.project.model;


import javax.persistence.*;

@Entity
@Table(name = "transactionRequest")
public class TransactionRequest {

    @Id
    @GeneratedValue
    private long id;
    private long landId;
    private String areaOfLand;
    private String ownerName;
    private String buyerId;
    private String buyername;
    private String buyerusername;
    private String marketPrice;
    private String finalPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLandId() {
        return landId;
    }

    public void setLandId(long landId) {
        this.landId = landId;
    }

    public String getAreaOfLand() {
        return areaOfLand;
    }

    public void setAreaOfLand(String areaOfLand) {
        this.areaOfLand = areaOfLand;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
    }

    public String getBuyerusername() {
        return buyerusername;
    }

    public void setBuyerusername(String buyerusername) {
        this.buyerusername = buyerusername;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }
}
