package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;

public class HospitalModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "NAME")
  private String hospitalName;

  @Column (name = "ADDRESS")
  private String hospitalAddress;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_DISTRICT")
  private DistrictModel district;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_HOSPITAL_TYPE")
  private HospitalTypeModel hospitalType;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getHospitalName () {
    return hospitalName;
  }

  public void setHospitalName (String hospitalName) {
    this.hospitalName = hospitalName;
  }

  public String getHospitalAddress () {
    return hospitalAddress;
  }

  public void setHospitalAddress (String hospitalAddress) {
    this.hospitalAddress = hospitalAddress;
  }

  public Date getCreationTime () {
    return creationTime;
  }

  public void setCreationTime (Date creationTime) {
    this.creationTime = creationTime;
  }

  public Date getModifiedTime () {
    return modifiedTime;
  }

  public void setModifiedTime (Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  public char getIsActive () {
    return isActive;
  }

  public void setIsActive (char isActive) {
    this.isActive = isActive;
  }

  public DistrictModel getDistrict () {
    return district;
  }

  public void setDistrict (DistrictModel district) {
    this.district = district;
  }

  public HospitalTypeModel getHospitalType () {
    return hospitalType;
  }

  public void setHospitalType (HospitalTypeModel hospitalType) {
    this.hospitalType = hospitalType;
  }
}
