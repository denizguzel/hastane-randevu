package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "T_BRANCH")
public class BranchModel {

  @Id
  @Column(name = "PK")
  @GeneratedValue (generator = "branch_pk")
  @SequenceGenerator (name = "branch_pk", sequenceName = "SEQ_BRANCH_PK", allocationSize = 1)
  private long pk;

  @Column (name = "BRANCH_NAME")
  private String branchName;

  @Column (name = "CREATION_TIME", insertable = false, updatable = false)
  private Date creationTime;

  @Column (name = "MODIFIED_TIME", insertable = false, updatable = false)
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @OneToMany (mappedBy = "branch")
  private List<DoctorModel> doctorModels;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getBranchName () {
    return branchName;
  }

  public void setBranchName (String branchName) {
    this.branchName = branchName;
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
