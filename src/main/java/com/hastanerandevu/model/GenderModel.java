package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "gender")
public class GenderModel {
  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "GENDER")
  private String gender;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @OneToMany (mappedBy = "gender")
  private List<DoctorModel> doctorModels;

  @OneToMany (mappedBy = "gender")
  private List<PatientModel> patientModels;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getGender () {
    return gender;
  }

  public void setGender (String gender) {
    this.gender = gender;
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
