package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_ASSAY")
public class AssayModel {

  @Id
  @Column(name = "PK")
  @GeneratedValue(generator = "assay_pk")
  @SequenceGenerator(name = "assay_pk", sequenceName = "SEQ_ASSAY_PK", allocationSize = 1)
  private long pk;

  @Column(name = "ASSAY_NAME")
  private String assayName;

  @Column(name = "CREATION_TIME", insertable = false, updatable = false)
  private Date creationTime;

  @Column(name = "MODIFIED_TIME", insertable = false, updatable = false)
  private Date modifiedTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @OneToMany(mappedBy = "assay")
  private List<PatientAssayRelModel> patientAssayRelModels;

  public long getPk() {
    return pk;
  }

  public void setPk(long pk) {
    this.pk = pk;
  }

  public String getAssayName() {
    return assayName;
  }

  public void setAssayName(String assayName) {
    this.assayName = assayName;
  }

  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  public Date getModifiedTime() {
    return modifiedTime;
  }

  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  public char getIsActive() {
    return isActive;
  }

  public void setIsActive(char isActive) {
    this.isActive = isActive;
  }

  public List<PatientAssayRelModel> getPatientAssayRelModels() {
    return patientAssayRelModels;
  }

  public void setPatientAssayRelModels(List<PatientAssayRelModel> patientAssayRelModels) {
    this.patientAssayRelModels = patientAssayRelModels;
  }
}
