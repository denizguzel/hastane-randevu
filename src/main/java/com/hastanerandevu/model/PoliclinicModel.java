package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "policlinic")
public class PoliclinicModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "POLICLINIC_NAME")
  private String policlinicName;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @OneToMany (mappedBy = "policlinic")
  private List<HospitalPoliclinicRelModel> hospitalPoliclinicRelModels;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getPoliclinicName () {
    return policlinicName;
  }

  public void setPoliclinicName (String policlinicName) {
    this.policlinicName = policlinicName;
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

  public List<HospitalPoliclinicRelModel> getHospitalPoliclinicRelModels() {
    return hospitalPoliclinicRelModels;
  }

  public void setHospitalPoliclinicRelModels(List<HospitalPoliclinicRelModel> hospitalPoliclinicRelModels) {
    this.hospitalPoliclinicRelModels = hospitalPoliclinicRelModels;
  }
}
