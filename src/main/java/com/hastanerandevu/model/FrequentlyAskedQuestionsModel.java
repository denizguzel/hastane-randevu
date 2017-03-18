package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "T_ASKED_QUESTIONS")
public class FrequentlyAskedQuestionsModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (generator = "asked_question_pk")
  @SequenceGenerator (name = "asked_question_pk", sequenceName = "SEQ_ASKEDQUESTION_PK", allocationSize = 1)
  private long pk;

  @Column (name = "QUESTION")
  private String question;

  @Column (name = "ANSWER")
  private String answer;

  @Column (name = "CREATION_TIME",insertable = false, updatable = false)
  private Date creationTime;

  @Column (name = "MODIFIED_TIME",insertable = false, updatable = false)
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE",insertable = false)
  private char isActive;

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
}
