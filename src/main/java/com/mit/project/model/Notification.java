package com.mit.project.model;

import javax.persistence.*;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue
    private long id;
    private String toId;
    private String fromId;
    private String category;
    private String heading;
    private String details;
    private String documentName;
    private String documentType;
    private String timestamp;
    @Lob
    private byte[] data;

    //Constructor
    public Notification(){}

    public Notification(long id, String toId, String fromId, String category, String heading, String details, String documentName, String documentType, String timestamp, byte[] data) {
        this.id = id;
        this.toId = toId;
        this.fromId = fromId;
        this.category = category;
        this.heading = heading;
        this.details = details;
        this.documentName = documentName;
        this.documentType = documentType;
        this.timestamp = timestamp;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
