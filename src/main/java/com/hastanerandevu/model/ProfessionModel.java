package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "profession")
public class ProfessionModel {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  @Column (name = "PK")
  private long pk;

  @Column (name = "PROFESSION_TYPE")
  private String professionType;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @OneToMany (mappedBy = "profession")
  private List<DoctorModel> doctorModels;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getProfessionType () {
    return professionType;
  }

  public void setProfessionType (String professionType) {
    this.professionType = professionType;
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
}
