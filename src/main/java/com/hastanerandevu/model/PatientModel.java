package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "patient")
public class PatientModel {
  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  @Column (name = "PK")
  private long pk;
  @Column (name = "FIRST_NAME")
  private String firstName;
  private String lastName;
  private Date dateOfBirth;
  private Date placeOfBirth;
  private String tcNumber;
  @Column (name = "PASSWORD")
  private String password;
  private String email;
  private String phoneNumber;
  private String address;
  private String fatherName;
  private String motherName;
  private String questionAnswer;
  /*  private GenderModel genderModel;
    private BloodGroupModel bloodGroupModel;
    private SecretQuestionModel secretQuestionModel;*/
  private Date creationTime;
  private Date modifiedTime;
  private char isActive;

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

  public Date getPlaceOfBirth () {
    return placeOfBirth;
  }

  public void setPlaceOfBirth (Date placeOfBirth) {
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

  public String getQuestionAnswer () {
    return questionAnswer;
  }

  public void setQuestionAnswer (String questionAnswer) {
    this.questionAnswer = questionAnswer;
  }

/*  public GenderModel getGenderModel () {
    return genderModel;
  }

  public void setGenderModel (GenderModel genderModel) {
    this.genderModel = genderModel;
  }

  public BloodGroupModel getBloodGroupModel () {
    return bloodGroupModel;
  }

  public void setBloodGroupModel (BloodGroupModel bloodGroupModel) {
    this.bloodGroupModel = bloodGroupModel;
  }

  public SecretQuestionModel getSecretQuestionModel () {
    return secretQuestionModel;
  }

  public void setSecretQuestionModel (SecretQuestionModel secretQuestionModel) {
    this.secretQuestionModel = secretQuestionModel;
  }*/

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
}
