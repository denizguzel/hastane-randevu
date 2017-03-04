package com.hastanerandevu.model;

import java.util.Date;

public class DiseaseModel {
  private long pk;
  private String diseaseName;
  private DiseaseTypeModel diseaseTypeModel;
  private Date creationTime;
  private Date modifiedTime;
  private char isActive;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getDiseaseName () {
    return diseaseName;
  }

  public void setDiseaseName (String diseaseName) {
    this.diseaseName = diseaseName;
  }

  public DiseaseTypeModel getDiseaseTypeModel () {
    return diseaseTypeModel;
  }

  public void setDiseaseTypeModel (DiseaseTypeModel diseaseTypeModel) {
    this.diseaseTypeModel = diseaseTypeModel;
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
