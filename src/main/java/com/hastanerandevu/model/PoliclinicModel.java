package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "T_POLICLINIC")
public class PoliclinicModel {

  @Id
  @Column(name = "PK")
  @GeneratedValue (generator = "policlinic_pk")
  @SequenceGenerator (name = "policlinic_pk", sequenceName = "SEQ_POLICLINIC_PK", allocationSize = 1)
  private long pk;

  @Column (name = "POLICLINIC_NAME")
  private String policlinicName;

  @Column (name = "CREATION_TIME", insertable = false, updatable = false)
  private Date creationTime;

  @Column (name = "MODIFIED_TIME", insertable = false, updatable = false)
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE", insertable = false)
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

  public List<HospitalPoliclinicRelModel> getHospitalPoliclinicRelModels () {
    return hospitalPoliclinicRelModels;
  }

  public void setHospitalPoliclinicRelModels (List<HospitalPoliclinicRelModel> hospitalPoliclinicRelModels) {
    this.hospitalPoliclinicRelModels = hospitalPoliclinicRelModels;
  }
}
