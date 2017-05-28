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
@Table(name = "T_TREATMENT")
public class TreatmentModel implements Creatable, Updatable {

  @Id
  @Column(name = "PK")
  @GeneratedValue(generator = "treatment_pk")
  @SequenceGenerator(name = "treatment_pk", sequenceName = "SEQ_TREATMENT_PK", allocationSize = 1)
  private long pk;

  @Column(name = "TREATMENT_NAME")
  private String treatmentName;

  @Column(name = "CREATION_TIME")
  private Date creationTime;

  @Column(name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @OneToMany(mappedBy = "treatment")
  private List<PatientTreatmentRelModel> patientTreatmentRelModels;

  public long getPk() {
    return pk;
  }

  public String getTreatmentName() {
    return treatmentName;
  }

  public void setTreatmentName(String treatmentName) {
    this.treatmentName = treatmentName;
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

  public List<PatientTreatmentRelModel> getPatientTreatmentRelModels() {
    return patientTreatmentRelModels;
  }

  public void setPatientTreatmentRelModels(List<PatientTreatmentRelModel> patientTreatmentRelModels) {
    this.patientTreatmentRelModels = patientTreatmentRelModels;
  }
}
