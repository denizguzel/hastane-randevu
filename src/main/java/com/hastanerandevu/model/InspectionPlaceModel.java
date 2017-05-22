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
@Table(name = "T_INSPECTION_PLACE")
public class InspectionPlaceModel implements Creatable, Updatable {

  @Id
  @Column(name = "PK")
  @GeneratedValue(generator = "inspection_place_pk")
  @SequenceGenerator(name = "inspection_place_pk", sequenceName = "SEQ_INSPECTION_PLACE_PK", allocationSize = 1)
  private long pk;

  @Column(name = "PLACE_NAME")
  private String placeName;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @Column(name = "CREATION_TIME")
  private Date creationTime;

  @Column(name = "MODIFIED_TIME")
  private Date modifiedTime;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_DOCTOR")
  private DoctorModel doctor;

  @OneToMany(mappedBy = "inspectionPlace")
  private List<AppointmentModel> appointmentModels;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_HOSPITAL_POLICLINIC_REL")
  private HospitalPoliclinicRelModel hospitalPoliclinicRel;

  public long getPk() {
    return pk;
  }

  public void setPk(long pk) {
    this.pk = pk;
  }

  public String getPlaceName() {
    return placeName;
  }

  public void setPlaceName(String placeName) {
    this.placeName = placeName;
  }

  public char getIsActive() {
    return isActive;
  }

  public void setIsActive(char isActive) {
    this.isActive = isActive;
  }

  public HospitalPoliclinicRelModel getHospitalPoliclinicRel() {
    return hospitalPoliclinicRel;
  }

  public void setHospitalPoliclinicRel(HospitalPoliclinicRelModel hospitalPoliclinicRel) {
    this.hospitalPoliclinicRel = hospitalPoliclinicRel;
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

  public List<AppointmentModel> getAppointmentModels() {
    return appointmentModels;
  }

  public void setAppointmentModels(List<AppointmentModel> appointmentModels) {
    this.appointmentModels = appointmentModels;
  }

  public DoctorModel getDoctor() {
    return doctor;
  }

  public void setDoctor(DoctorModel doctor) {
    this.doctor = doctor;
  }
}
