package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "option")
public class OptionModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "OPTION_TEXT")
  private String optionText;

  @Column (name = "COUNT")
  private int count;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_QUESTION")
  private QuestionModel question;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
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

  public QuestionModel getQuestion() {
    return question;
  }

  public void setQuestion(QuestionModel question) {
    this.question = question;
  }
}
