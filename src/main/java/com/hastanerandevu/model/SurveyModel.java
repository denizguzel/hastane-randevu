package com.hastanerandevu.model;

import java.util.Date;

public class SurveyModel {
  private long pk;
  private String surveyDescription;
  private Date creationTime;
  private Date modifiedTime;
  private Date expirationTime;
  private char isActive;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getSurveyDescription () {
    return surveyDescription;
  }

  public void setSurveyDescription (String surveyDescription) {
    this.surveyDescription = surveyDescription;
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

  public Date getExpirationTime () {
    return expirationTime;
  }

  public void setExpirationTime (Date expirationTime) {
    this.expirationTime = expirationTime;
  }

  public char getIsActive () {
    return isActive;
  }

  public void setIsActive (char isActive) {
    this.isActive = isActive;
  }
}
