package com.hastanerandevu.model;

import java.util.Date;

public class QuestionModel {
  private long pk;
  private String questionText;
  private SurveyModel surveyModel;
  private Date creationTime;
  private Date modifiedTime;
  private char isActive;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getQuestionText () {
    return questionText;
  }

  public void setQuestionText (String questionText) {
    this.questionText = questionText;
  }

  public SurveyModel getSurveyModel () {
    return surveyModel;
  }

  public void setSurveyModel (SurveyModel surveyModel) {
    this.surveyModel = surveyModel;
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
