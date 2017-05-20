package com.hastanerandevu.model;

import com.hastanerandevu.listeners.Creatable;
import com.hastanerandevu.listeners.CreationTimeListener;
import com.hastanerandevu.listeners.ModifiedTimeListener;
import com.hastanerandevu.listeners.Updatable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners({
  CreationTimeListener.class,
  ModifiedTimeListener.class
})
@Table(name = "T_ALERGY")
public class AlergyModel implements Creatable,Updatable {

  @Id
  @Column(name = "PK")
  @GeneratedValue(generator = "alergy_pk")
  @SequenceGenerator(name = "alergy_pk", sequenceName = "SEQ_ALERGY_PK", allocationSize = 1)
  private long pk;

  @Column(name = "ALERGY_NAME")
  private String alergyName;

  @Column(name = "CREATION_TIME", insertable = false, updatable = false)
  private Date creationTime;

  @Column(name = "MODIFIED_TIME", insertable = false, updatable = false)
  private Date modifiedTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @OneToMany(mappedBy = "alergy")
  private List<PatientAlergyRelModel> patientAlergyRelModels;

  public long getPk() {
    return pk;
  }

  public void setPk(long pk) {
    this.pk = pk;
  }

  public String getAlergyName() {
    return alergyName;
  }

  public void setAlergyName(String alergyName) {
    this.alergyName = alergyName;
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

  public List<PatientAlergyRelModel> getPatientAlergyRelModels() {
    return patientAlergyRelModels;
  }

  public void setPatientAlergyRelModels(List<PatientAlergyRelModel> patientAlergyRelModels) {
    this.patientAlergyRelModels = patientAlergyRelModels;
  }
}
