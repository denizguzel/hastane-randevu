package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "patient")
public class PatientModel {
  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  @Column (name = "PK")
  private long pk;

  @Column (name = "FIRST_NAME")
  private String firstName;

  @Column (name = "LAST_NAME")
  private String lastName;

  @Column (name = "PASSWORD")
  private String password;

  @Column (name = "TC_NUMBER")
  private String tcNumber;

  @Column (name = "DATE_OF_BIRTH")
  private Date dateOfBirth;

  @Column (name = "PLACE_OF_BIRTH")
  private String placeOfBirth;

  @Column (name = "EMAIL")
  private String email;

  @Column (name = "PHONE_NUMBER")
  private String phoneNumber;

  @Column (name = "ADDRESS")
  private String address;

  @Column (name = "FATHER_NAME")
  private String fatherName;

  @Column (name = "MOTHER_NAME")
  private String motherName;

  @Column (name = "QUESTION_ANSWER")
  private String questionAnswer;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_GENDER")
  private GenderModel gender;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_SECRET_QUESTION")
  private SecretQuestionModel secretQuestion;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_BLOOD_GROUP")
  private BloodGroupModel bloodGroup;

  @OneToMany (mappedBy = "patientModel")
  private List<AppointmentModel> appointmentModels;

  @OneToMany (mappedBy = "patientModel")
  private List<PatientAlergyRelModel> patientAlergyRelModels;

  @OneToMany (mappedBy = "patientModel")
  private List<PatientAssayRelModel> patientAssayRelModels;

  @OneToMany (mappedBy = "patientModel")
  private List<PatientDiseaseRelModel> patientDiseaseRelModels;

  @OneToMany (mappedBy = "patientModel")
  private List<PatientTreatmentRelModel> patientTreatmentRelModels;

  @OneToMany (mappedBy = "patientModel")
  private List<ReviewsAboutDoctorsModel> reviewsAboutDoctorsModels;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getFirstName () {
    return firstName;
  }

  public void setFirstName (String firstName) {
    this.firstName = firstName;
  }

  public String getLastName () {
    return lastName;
  }

  public void setLastName (String lastName) {
    this.lastName = lastName;
  }

  public Date getDateOfBirth () {
    return dateOfBirth;
  }

  public void setDateOfBirth (Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getPlaceOfBirth () {
    return placeOfBirth;
  }

  public void setPlaceOfBirth (String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }

  public String getTcNumber () {
    return tcNumber;
  }

  public void setTcNumber (String tcNumber) {
    this.tcNumber = tcNumber;
  }

  public String getPassword () {
    return password;
  }

  public void setPassword (String password) {
    this.password = password;
  }

  public String getEmail () {
    return email;
  }

  public void setEmail (String email) {
    this.email = email;
  }

  public String getPhoneNumber () {
    return phoneNumber;
  }

  public void setPhoneNumber (String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress () {
    return address;
  }

  public void setAddress (String address) {
    this.address = address;
  }

  public String getFatherName () {
    return fatherName;
  }

  public void setFatherName (String fatherName) {
    this.fatherName = fatherName;
  }

  public String getMotherName () {
    return motherName;
  }

  public void setMotherName (String motherName) {
    this.motherName = motherName;
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

  public GenderModel getGender () {
    return gender;
  }

  public void setGender (GenderModel gender) {
    this.gender = gender;
  }

  public SecretQuestionModel getSecretQuestion () {
    return secretQuestion;
  }

  public void setSecretQuestion (SecretQuestionModel secretQuestion) {
    this.secretQuestion = secretQuestion;
  }

  public BloodGroupModel getBloodGroup () {
    return bloodGroup;
  }

  public void setBloodGroup (BloodGroupModel bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  public String getQuestionAnswer () {
    return questionAnswer;
  }

  public void setQuestionAnswer (String questionAnswer) {
    this.questionAnswer = questionAnswer;
  }
}
