package com.mit.project.model;

import javax.persistence.*;

@Entity
@Table(name = "landData")
public class LandData {
	
	@Id
	@GeneratedValue
	private long id;
	private String surveyNo;
	private String registrationNo;
	private String registrationYear;
	private String propertyType;
	private String address;
	private String city;
	private String taluka;
	private String district;
	private String pincode;
	private String ownerName;
	private String ownerAadhar;
	private long userId;
	private String mutationNumber;
	private String areaOfLand;
	private String typeOfLand;
	private String typeOfIrrigation;
	private String typeOfCrop;
	private boolean detailsOfPendingLitigation;
	private boolean taxPaid;
	private boolean loanPending;
	private boolean lockedData;
	@Lob
	private byte[] data;

	//Constructors
	public LandData() {}

	public LandData(long id, String surveyNo, String registrationNo, String registrationYear, String propertyType, String address, String city, String taluka, String district, String pincode, String ownerName, String ownerAadhar, long userId, String mutationNumber, String areaOfLand, String typeOfLand, String typeOfIrrigation, String typeOfCrop, boolean detailsOfPendingLitigation, boolean taxPaid, boolean loanPending, boolean lockedData, byte[] data) {
		this.id = id;
		this.surveyNo = surveyNo;
		this.registrationNo = registrationNo;
		this.registrationYear = registrationYear;
		this.propertyType = propertyType;
		this.address = address;
		this.city = city;
		this.taluka = taluka;
		this.district = district;
		this.pincode = pincode;
		this.ownerName = ownerName;
		this.ownerAadhar = ownerAadhar;
		this.userId = userId;
		this.mutationNumber = mutationNumber;
		this.areaOfLand = areaOfLand;
		this.typeOfLand = typeOfLand;
		this.typeOfIrrigation = typeOfIrrigation;
		this.typeOfCrop = typeOfCrop;
		this.detailsOfPendingLitigation = detailsOfPendingLitigation;
		this.taxPaid = taxPaid;
		this.loanPending = loanPending;
		this.lockedData = lockedData;
		this.data = data;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSurveyNo() {
		return surveyNo;
	}

	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(String registrationYear) {
		this.registrationYear = registrationYear;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTaluka() {
		return taluka;
	}

	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerAadhar() {
		return ownerAadhar;
	}

	public void setOwnerAadhar(String ownerAadhar) {
		this.ownerAadhar = ownerAadhar;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getMutationNumber() {
		return mutationNumber;
	}

	public void setMutationNumber(String mutationNumber) {
		this.mutationNumber = mutationNumber;
	}

	public String getAreaOfLand() {
		return areaOfLand;
	}

	public void setAreaOfLand(String areaOfLand) {
		this.areaOfLand = areaOfLand;
	}

	public String getTypeOfLand() {
		return typeOfLand;
	}

	public void setTypeOfLand(String typeOfLand) {
		this.typeOfLand = typeOfLand;
	}

	public String getTypeOfIrrigation() {
		return typeOfIrrigation;
	}

	public void setTypeOfIrrigation(String typeOfIrrigation) {
		this.typeOfIrrigation = typeOfIrrigation;
	}

	public String getTypeOfCrop() {
		return typeOfCrop;
	}

	public void setTypeOfCrop(String typeOfCrop) {
		this.typeOfCrop = typeOfCrop;
	}

	public boolean isDetailsOfPendingLitigation() {
		return detailsOfPendingLitigation;
	}

	public void setDetailsOfPendingLitigation(boolean detailsOfPendingLitigation) {
		this.detailsOfPendingLitigation = detailsOfPendingLitigation;
	}

	public boolean isTaxPaid() {
		return taxPaid;
	}

	public void setTaxPaid(boolean taxPaid) {
		this.taxPaid = taxPaid;
	}

	public boolean isLoanPending() {
		return loanPending;
	}

	public void setLoanPending(boolean loanPending) {
		this.loanPending = loanPending;
	}

	public boolean isLockedData() {
		return lockedData;
	}

	public void setLockedData(boolean lockedData) {
		this.lockedData = lockedData;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}
