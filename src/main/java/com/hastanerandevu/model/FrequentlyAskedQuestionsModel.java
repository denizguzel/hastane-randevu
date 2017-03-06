package com.hastanerandevu.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class FrequentlyAskedQuestionsModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "QUESTION")
  private String question;

  @Column (name = "ANSWER")
  private String answer;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @Column (name = "IS_APPROPRIATE")
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
