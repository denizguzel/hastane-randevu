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
@Table(name = "T_DISEASE")
public class DiseaseModel implements Creatable,Updatable {

  @Id
  @Column(name = "PK")
  @GeneratedValue(generator = "disease_pk")
  @SequenceGenerator(name = "disease_pk", sequenceName = "SEQ_DISEASE_PK", allocationSize = 1)
  private long pk;

  @Column(name = "DISEASE_NAME")
  private String diseaseName;

  @Column(name = "CREATION_TIME", insertable = false, updatable = false)
  private Date creationTime;

  @Column(name = "MODIFIED_TIME", insertable = false, updatable = false)
  private Date modifiedTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @OneToMany(mappedBy = "disease")
  private List<PatientDiseaseRelModel> patientDiseaseRelModels;

  public long getPk() {
    return pk;
  }

  public void setPk(long pk) {
    this.pk = pk;
  }

  public String getDiseaseName() {
    return diseaseName;
  }

  public void setDiseaseName(String diseaseName) {
    this.diseaseName = diseaseName;
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

  public List<PatientDiseaseRelModel> getPatientDiseaseRelModels() {
    return patientDiseaseRelModels;
  }

  public void setPatientDiseaseRelModels(List<PatientDiseaseRelModel> patientDiseaseRelModels) {
    this.patientDiseaseRelModels = patientDiseaseRelModels;
  }
}
