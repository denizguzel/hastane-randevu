package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "question")
public class QuestionModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "QUESTION_TEXT")
  private String questionText;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @Column (name = "ORDER_NO")
  private int orderNo;

  @OneToMany (mappedBy = "question")
  private List<OptionModel> optionModels;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_SURVEY")
  private SurveyModel survey;

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

  public List<OptionModel> getOptionModels () {
    return optionModels;
  }

  public void setOptionModels (List<OptionModel> optionModels) {
    this.optionModels = optionModels;
  }

  public SurveyModel getSurvey () {
    return survey;
  }

  public void setSurvey (SurveyModel survey) {
    this.survey = survey;
  }

  public int getOrderNo () {
    return orderNo;
  }

  public void setOrderNo (int orderNo) {
    this.orderNo = orderNo;
  }
}
