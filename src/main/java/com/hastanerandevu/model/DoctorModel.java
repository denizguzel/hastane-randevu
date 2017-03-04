package com.hastanerandevu.model;

import java.util.Date;

public class DoctorModel {
  private long pk;
  private String firstName;
  private String lastName;
  private Date dateOfBirth;
  private String recordNumber;
  private String questionAnswer;
  private GenderModel genderModel;
  private ProfessionModel professionModel;
  private SecretQuestionModel secretQuestionModel;
  private BranchModel branchModel;
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

  public String getRecordNumber () {
    return recordNumber;
  }

  public void setRecordNumber (String recordNumber) {
    this.recordNumber = recordNumber;
  }

  public String getQuestionAnswer () {
    return questionAnswer;
  }

  public void setQuestionAnswer (String questionAnswer) {
    this.questionAnswer = questionAnswer;
  }

  public GenderModel getGenderModel () {
    return genderModel;
  }

  public void setGenderModel (GenderModel genderModel) {
    this.genderModel = genderModel;
  }

  public ProfessionModel getProfessionModel () {
    return professionModel;
  }

  public void setProfessionModel (ProfessionModel professionModel) {
    this.professionModel = professionModel;
  }

  public SecretQuestionModel getSecretQuestionModel () {
    return secretQuestionModel;
  }

  public void setSecretQuestionModel (SecretQuestionModel secretQuestionModel) {
    this.secretQuestionModel = secretQuestionModel;
  }

  public BranchModel getBranchModel () {
    return branchModel;
  }

  public void setBranchModel (BranchModel branchModel) {
    this.branchModel = branchModel;
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
}
