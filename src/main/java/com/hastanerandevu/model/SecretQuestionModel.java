package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "T_SECRET_QUESTION")
public class SecretQuestionModel {

  @Id
  @GeneratedValue (generator = "secret_question_pk")
  @SequenceGenerator (name = "secret_question_pk", sequenceName = "SEQ_SECRET_QUESTION_PK", allocationSize = 1)
  @Column (name = "PK")
  private long pk;

  @Column (name = "QUESTION")
  private String question;

  @Column (name = "CREATION_TIME", insertable = false, updatable = false)
  private Date creationTime;

  @Column (name = "MODIFIED_TIME", insertable = false, updatable = false)
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @OneToMany (mappedBy = "secretQuestion")
  private List<DoctorModel> doctorModels;

  @OneToMany (mappedBy = "secretQuestion")
  private List<PatientModel> patientModels;

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

  public List<DoctorModel> getDoctorModels () {
    return doctorModels;
  }

  public void setDoctorModels (List<DoctorModel> doctorModels) {
    this.doctorModels = doctorModels;
  }

  public List<PatientModel> getPatientModels () {
    return patientModels;
  }

  public void setPatientModels (List<PatientModel> patientModels) {
    this.patientModels = patientModels;
  }
}
