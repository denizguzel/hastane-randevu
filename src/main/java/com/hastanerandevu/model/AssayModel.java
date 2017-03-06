package com.hastanerandevu.model;

import java.util.Date;

// TODO mapping gerekli
public class AssayModel {
  private long pk;
  private String assayname;
  private AssayTypeModel assayTypeModel;
  private Date creationTime;
  private Date modifiedTime;
  private char isActive;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getAssayname () {
    return assayname;
  }

  public void setAssayname (String assayname) {
    this.assayname = assayname;
  }

  public AssayTypeModel getAssayTypeModel () {
    return assayTypeModel;
  }

  public void setAssayTypeModel (AssayTypeModel assayTypeModel) {
    this.assayTypeModel = assayTypeModel;
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
