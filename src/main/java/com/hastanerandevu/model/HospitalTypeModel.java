package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class HospitalTypeModel {
  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "TYPE_NAME")
  private String typeName;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @OneToMany (mappedBy = "hospitalType")
  private List<HospitalModel> hospitalModels;


  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getTypeName () {
    return typeName;
  }

  public void setTypeName (String typeName) {
    this.typeName = typeName;
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

  public List<HospitalModel> getHospitalModels () {
    return hospitalModels;
  }

  public void setHospitalModels (List<HospitalModel> hospitalModels) {
    this.hospitalModels = hospitalModels;
  }
}
