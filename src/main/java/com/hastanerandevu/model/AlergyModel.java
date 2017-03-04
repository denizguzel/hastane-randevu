package com.hastanerandevu.model;

import java.util.Date;

public class AlergyModel {
  private long pk;
  private String alergyName;
  private AlergyTypeModel alergyTypeModel;
  private Date creationTime;
  private Date modifiedTime;
  private char isActive;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getAlergyName () {
    return alergyName;
  }

  public void setAlergyName (String alergyName) {
    this.alergyName = alergyName;
  }

  public AlergyTypeModel getAlergyTypeModel () {
    return alergyTypeModel;
  }

  public void setAlergyTypeModel (AlergyTypeModel alergyTypeModel) {
    this.alergyTypeModel = alergyTypeModel;
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
}
