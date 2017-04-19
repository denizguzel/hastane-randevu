package com.hastanerandevu.model;

import com.hastanerandevu.enums.BloodGroupEnum;
import com.hastanerandevu.enums.GenderEnum;
import com.hastanerandevu.enums.SecretQuestionEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_PATIENT")
public class PatientModel {
  @Id
  @GeneratedValue(generator = "patient_pk")
  @SequenceGenerator(name = "patient_pk", sequenceName = "SEQ_PATIENT_PK", allocationSize = 1)
  @Column(name = "PK")
  private long pk;

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "TC_NUMBER")
  private String tcNumber;

  @Column(name = "DATE_OF_BIRTH")
  private Date dateOfBirth;

  @Column(name = "PLACE_OF_BIRTH")
  private String placeOfBirth;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "PHONE_NUMBER")
  private String phoneNumber;

  @Column(name = "ADDRESS")
  private String address;

  @Column(name = "FATHER_NAME")
  private String fatherName;

  @Column(name = "MOTHER_NAME")
  private String motherName;

  @Column(name = "QUESTION_ANSWER")
  private String questionAnswer;

  @Column(name = "CREATION_TIME", insertable = false, updatable = false)
  private Date creationTime;

  @Column(name = "MODIFIED_TIME", insertable = false, updatable = false)
  private Date modifiedTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @Column(name = "FORGOTTEN_EXPIRATION_DATE")
  private Date forgottenExpirationDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "GENDER")
  private GenderEnum gender;

  @Enumerated(EnumType.STRING)
  @Column(name = "BLOOD_GROUP")
  private BloodGroupEnum bloodGroup;

  @Enumerated(EnumType.STRING)
  @Column(name = "SECRET_QUESTION")
  private SecretQuestionEnum secretQuestion;

  @OneToMany(mappedBy = "patient")
  private List<AppointmentModel> appointmentModels;

  @OneToMany(mappedBy = "patient")
  private List<PatientAlergyRelModel> patientAlergyRelModels;

  @OneToMany(mappedBy = "patient")
  private List<PatientAssayRelModel> patientAssayRelModels;

  @OneToMany(mappedBy = "patient")
  private List<PatientDiseaseRelModel> patientDiseaseRelModels;

  @OneToMany(mappedBy = "patient")
  private List<PatientTreatmentRelModel> patientTreatmentRelModels;

  @OneToMany(mappedBy = "patient")
  private List<ReviewsAboutDoctorsModel> reviewsAboutDoctorsModels;

  public PatientModel() {
  }

  public long getPk() {
    return pk;
  }

  public void setPk(long pk) {
    this.pk = pk;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getPlaceOfBirth() {
    return placeOfBirth;
  }

  public void setPlaceOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }

  public String getTcNumber() {
    return tcNumber;
  }

  public void setTcNumber(String tcNumber) {
    this.tcNumber = tcNumber;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getFatherName() {
    return fatherName;
  }

  public void setFatherName(String fatherName) {
    this.fatherName = fatherName;
  }

  public String getMotherName() {
    return motherName;
  }

  public void setMotherName(String motherName) {
    this.motherName = motherName;
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

  public String getQuestionAnswer() {
    return questionAnswer;
  }

  public void setQuestionAnswer(String questionAnswer) {
    this.questionAnswer = questionAnswer;
  }

  public List<AppointmentModel> getAppointmentModels() {
    return appointmentModels;
  }

  public void setAppointmentModels(List<AppointmentModel> appointmentModels) {
    this.appointmentModels = appointmentModels;
  }

  public List<PatientAlergyRelModel> getPatientAlergyRelModels() {
    return patientAlergyRelModels;
  }

  public void setPatientAlergyRelModels(List<PatientAlergyRelModel> patientAlergyRelModels) {
    this.patientAlergyRelModels = patientAlergyRelModels;
  }

  public List<PatientAssayRelModel> getPatientAssayRelModels() {
    return patientAssayRelModels;
  }

  public void setPatientAssayRelModels(List<PatientAssayRelModel> patientAssayRelModels) {
    this.patientAssayRelModels = patientAssayRelModels;
  }

  public List<PatientDiseaseRelModel> getPatientDiseaseRelModels() {
    return patientDiseaseRelModels;
  }

  public void setPatientDiseaseRelModels(List<PatientDiseaseRelModel> patientDiseaseRelModels) {
    this.patientDiseaseRelModels = patientDiseaseRelModels;
  }

  public List<PatientTreatmentRelModel> getPatientTreatmentRelModels() {
    return patientTreatmentRelModels;
  }

  public void setPatientTreatmentRelModels(List<PatientTreatmentRelModel> patientTreatmentRelModels) {
    this.patientTreatmentRelModels = patientTreatmentRelModels;
  }

  public List<ReviewsAboutDoctorsModel> getReviewsAboutDoctorsModels() {
    return reviewsAboutDoctorsModels;
  }

  public void setReviewsAboutDoctorsModels(List<ReviewsAboutDoctorsModel> reviewsAboutDoctorsModels) {
    this.reviewsAboutDoctorsModels = reviewsAboutDoctorsModels;
  }

  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public BloodGroupEnum getBloodGroup() {
    return bloodGroup;
  }

  public void setBloodGroup(BloodGroupEnum bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  public SecretQuestionEnum getSecretQuestion() {
    return secretQuestion;
  }

  public void setSecretQuestion(SecretQuestionEnum secretQuestion) {
    this.secretQuestion = secretQuestion;
  }

  public Date getForgottenExpirationDate() {
    return forgottenExpirationDate;
  }

  public void setForgottenExpirationDate(Date forgottenExpirationDate) {
    this.forgottenExpirationDate = forgottenExpirationDate;
  }
}
