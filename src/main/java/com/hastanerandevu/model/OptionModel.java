package com.hastanerandevu.model;

import java.util.Date;

// TODO mapping gerekli
public class OptionModel {
  private long pk;
  private String optionText;
  private int count;
  private QuestionModel questionModel;
  private Date creationTime;
  private Date modifiedTime;
  private char isActive;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getOptionText () {
    return optionText;
  }

  public void setOptionText (String optionText) {
    this.optionText = optionText;
  }

  public int getCount () {
    return count;
  }

  public void setCount (int count) {
    this.count = count;
  }

  public QuestionModel getQuestionModel () {
    return questionModel;
  }

  public void setQuestionModel (QuestionModel questionModel) {
    this.questionModel = questionModel;
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
