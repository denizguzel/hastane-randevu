package com.hastanerandevu.model;

import java.util.Date;

public class PatientTreatmentRelModel {
  private long pk;
  private PatientModel patientModel;
  private TreatmentModel treatmentModel;
  private char isStillPass;
  private Date creationTime;
  private Date modifiedTime;
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

  public TreatmentModel getTreatmentModel () {
    return treatmentModel;
  }

  public void setTreatmentModel (TreatmentModel treatmentModel) {
    this.treatmentModel = treatmentModel;
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
