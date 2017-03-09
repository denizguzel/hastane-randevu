package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;

// TODO service ve dao gerekli
@Entity
@Table (name = "patient_disease_rel")
public class PatientDiseaseRelModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "IS_STILL_PASS")
  private char isStillPass;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_PATIENT")
  private PatientModel patient;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_DISEASE")
  private DiseaseModel disease;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public char getIsStillPass () {
    return isStillPass;
  }

  public void setIsStillPass (char isStillPass) {
    this.isStillPass = isStillPass;
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

  public PatientModel getPatient () {
    return patient;
  }

  public void setPatient (PatientModel patient) {
    this.patient = patient;
  }

  public DiseaseModel getDisease () {
    return disease;
  }

  public void setDisease (DiseaseModel disease) {
    this.disease = disease;
  }
}
