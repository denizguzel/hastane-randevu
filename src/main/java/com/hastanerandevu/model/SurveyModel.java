package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "T_SURVEY")
public class SurveyModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (generator = "survey_pk")
  @SequenceGenerator (name = "survey_pk", sequenceName = "SEQ_SURVEY_PK", allocationSize = 1)
  private long pk;

  @Column (name = "SURVEY_DESCRIPTION")
  private String surveyDescription;

  @Column (name = "CREATION_TIME",insertable = false, updatable = false)
  private Date creationTime;

  @Column (name = "MODIFIED_TIME",insertable = false, updatable = false)
  private Date modifiedTime;

  @Column (name = "EXPIRATION_TIME")
  private Date expirationTime;

  @Column (name = "IS_ACTIVE",insertable = false)
  private char isActive;

  @OneToMany (mappedBy = "survey")
  private List<QuestionModel> questionModels;

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

  public List<QuestionModel> getQuestionModels () {
    return questionModels;
  }

  public void setQuestionModels (List<QuestionModel> questionModels) {
    this.questionModels = questionModels;
  }
}
