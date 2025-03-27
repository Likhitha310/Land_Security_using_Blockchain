package com.mit.project.model;

import javax.persistence.*;

@Entity
@Table(name = "correctionRequests")
public class CorrectionRequests {
    @Id
    @GeneratedValue
    private long id;
    private String ownerId;
    private String landId;
    private String correctionFields;
    private String correctValues;
    private String documentName;
    private String documentType;
    @Column(length=500)
    private String details;
    private String timestamp;
    private boolean completed;
    @Lob
    private byte[] data;

    public CorrectionRequests(){}

    public CorrectionRequests(long id, String ownerId, String landId, String correctionFields, String correctValues, String documentName, String documentType, String details, String timestamp, boolean completed, byte[] data) {
        this.id = id;
        this.ownerId = ownerId;
        this.landId = landId;
        this.correctionFields = correctionFields;
        this.correctValues = correctValues;
        this.documentName = documentName;
        this.documentType = documentType;
        this.details = details;
        this.timestamp = timestamp;
        this.completed = completed;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCorrectionFields() {
        return correctionFields;
    }

    public void setCorrectionFields(String correctionFields) {
        this.correctionFields = correctionFields;
    }

    public String getCorrectValues() {
        return correctValues;
    }

    public void setCorrectValues(String correctValues) {
        this.correctValues = correctValues;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
