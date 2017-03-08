package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "disease")
public class DiseaseModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "DISEASE_NAME")
  private String diseaseName;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @OneToMany (mappedBy = "disease")
  private List<PatientDiseaseRelModel> patientDiseaseRelModels;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getDiseaseName () {
    return diseaseName;
  }

  public void setDiseaseName (String diseaseName) {
    this.diseaseName = diseaseName;
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

  public List<PatientDiseaseRelModel> getPatientDiseaseRelModels() {
    return patientDiseaseRelModels;
  }

  public void setPatientDiseaseRelModels(List<PatientDiseaseRelModel> patientDiseaseRelModels) {
    this.patientDiseaseRelModels = patientDiseaseRelModels;
  }
}
