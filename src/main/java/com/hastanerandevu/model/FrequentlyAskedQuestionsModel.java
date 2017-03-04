package com.hastanerandevu.model;

import java.util.Date;

public class FrequentlyAskedQuestionsModel {
  private long pk;
  private String question;
  private String answer;
  private Date creationTime;
  private Date modifiedTime;
  private char isActive;
  private char isAppropriate;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getQuestion () {
    return question;
  }

  public void setQuestion (String question) {
    this.question = question;
  }

  public String getAnswer () {
    return answer;
  }

  public void setAnswer (String answer) {
    this.answer = answer;
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

  public char getIsAppropriate () {
    return isAppropriate;
  }

  public void setIsAppropriate (char isAppropriate) {
    this.isAppropriate = isAppropriate;
  }
}
