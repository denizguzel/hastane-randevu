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

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_PATIENT")
  private PatientModel patientModel;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_DISEASE")
  private DiseaseModel diseaseModel;

  @Column (name = "IS_STILL_PASS")
  private char isStillPass;

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

  public PatientModel getPatientModel () {
    return patientModel;
  }

  public void setPatientModel (PatientModel patientModel) {
    this.patientModel = patientModel;
  }

  public DiseaseModel getDiseaseModel () {
    return diseaseModel;
  }

  public void setDiseaseModel (DiseaseModel diseaseModel) {
    this.diseaseModel = diseaseModel;
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
}
