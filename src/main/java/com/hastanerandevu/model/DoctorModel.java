package com.hastanerandevu.model;

import com.hastanerandevu.enums.BloodGroupEnum;
import com.hastanerandevu.enums.GenderEnum;
import com.hastanerandevu.enums.LevelEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


// TODO service ve dao gerekli
@Entity
@Table (name = "doctor")
public class DoctorModel {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  @Column (name = "PK")
  private long pk;

  @Column (name = "FIRST_NAME")
  private String firstName;

  @Column (name = "LAST_NAME")
  private String lastName;

  @Column (name = "DATE_OF_BIRTH")
  private Date dateOfBirth;

  @Column (name = "RECORD_NUMBER")
  private String recordNumber;

  @Column (name = "QUESTION_ANSWER")
  private String questionAnswer;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @Enumerated(EnumType.STRING)
  @Column (name = "BLOOD_GROUP")
  private BloodGroupEnum bloodGroup;

  @Enumerated(EnumType.STRING)
  @Column (name = "GENDER")
  private GenderEnum gender;

  @Enumerated(EnumType.STRING)
  @Column (name = "LEVEL")
  private LevelEnum level;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_SECRET_QUESTION")
  private SecretQuestionModel secretQuestion;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_BRANCH")
  private BranchModel branch;

  @OneToMany (mappedBy = "doctor")
  private List<InspectionPlaceDoctorRelModel> inspectionPlaceDoctorRelModels;

  @OneToMany (mappedBy = "doctor")
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

  public SecretQuestionModel getSecretQuestion () {
    return secretQuestion;
  }

  public void setSecretQuestion (SecretQuestionModel secretQuestion) {
    this.secretQuestion = secretQuestion;
  }

  public BranchModel getBranch () {
    return branch;
  }

  public void setBranch (BranchModel branch) {
    this.branch = branch;
  }

  public List<InspectionPlaceDoctorRelModel> getInspectionPlaceDoctorRelModels() {
    return inspectionPlaceDoctorRelModels;
  }

  public void setInspectionPlaceDoctorRelModels(List<InspectionPlaceDoctorRelModel> inspectionPlaceDoctorRelModels) {
    this.inspectionPlaceDoctorRelModels = inspectionPlaceDoctorRelModels;
  }

  public List<ReviewsAboutDoctorsModel> getReviewsAboutDoctorsModels() {
    return reviewsAboutDoctorsModels;
  }

  public void setReviewsAboutDoctorsModels(List<ReviewsAboutDoctorsModel> reviewsAboutDoctorsModels) {
    this.reviewsAboutDoctorsModels = reviewsAboutDoctorsModels;
  }

  public BloodGroupEnum getBloodGroup() {
    return bloodGroup;
  }

  public void setBloodGroup(BloodGroupEnum bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public LevelEnum getLevel() {
    return level;
  }

  public void setLevel(LevelEnum level) {
    this.level = level;
  }
}
