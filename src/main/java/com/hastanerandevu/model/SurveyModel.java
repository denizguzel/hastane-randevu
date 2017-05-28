package com.hastanerandevu.model;

import com.hastanerandevu.listeners.Creatable;
import com.hastanerandevu.listeners.CreationTimeListener;
import com.hastanerandevu.listeners.ModifiedTimeListener;
import com.hastanerandevu.listeners.Updatable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners({
  CreationTimeListener.class,
  ModifiedTimeListener.class
})
@Table(name = "T_SURVEY")
public class SurveyModel implements Creatable, Updatable {

  @Id
  @Column(name = "PK")
  @GeneratedValue(generator = "survey_pk")
  @SequenceGenerator(name = "survey_pk", sequenceName = "SEQ_SURVEY_PK", allocationSize = 1)
  private long pk;

  @Column(name = "SURVEY_QUESTION")
  private String surveyQuestion;

  @Column(name = "CREATION_TIME")
  private Date creationTime;

  @Column(name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column(name = "EXPIRATION_TIME")
  private Date expirationTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @OneToMany(mappedBy = "survey")
  private List<OptionModel> optionModels;

  public long getPk() {
    return pk;
  }

  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  public Date getModifiedTime() {
    return modifiedTime;
  }

  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  public Date getExpirationTime() {
    return expirationTime;
  }

  public void setExpirationTime(Date expirationTime) {
    this.expirationTime = expirationTime;
  }

  public char getIsActive() {
    return isActive;
  }

  public void setIsActive(char isActive) {
    this.isActive = isActive;
  }

  public String getSurveyQuestion() {
    return surveyQuestion;
  }

  public void setSurveyQuestion(String surveyQuestion) {
    this.surveyQuestion = surveyQuestion;
  }

  public List<OptionModel> getOptionModels() {
    return optionModels;
  }

  public void setOptionModels(List<OptionModel> optionModels) {
    this.optionModels = optionModels;
  }
}
