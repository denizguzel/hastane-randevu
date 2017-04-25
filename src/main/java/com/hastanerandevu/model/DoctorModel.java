package com.hastanerandevu.model;

import com.hastanerandevu.enums.GenderEnum;
import com.hastanerandevu.enums.LevelEnum;
import com.hastanerandevu.enums.SecretQuestionEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_DOCTOR")
public class DoctorModel {

  @Id
  @GeneratedValue(generator = "doctor_pk")
  @SequenceGenerator(name = "doctor_pk", sequenceName = "SEQ_DOCTOR_PK", allocationSize = 1)
  @Column(name = "PK")
  private long pk;

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "DATE_OF_BIRTH")
  private Date dateOfBirth;

  @Column(name = "RECORD_NUMBER")
  private String recordNumber;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "QUESTION_ANSWER")
  private String questionAnswer;

  @Column(name = "CREATION_TIME", insertable = false, updatable = false)
  private Date creationTime;

  @Column(name = "MODIFIED_TIME", insertable = false, updatable = false)
  private Date modifiedTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @Enumerated(EnumType.STRING)
  @Column(name = "GENDER")
  private GenderEnum gender;

  @Enumerated(EnumType.STRING)
  @Column(name = "DOCTOR_LEVEL")
  private LevelEnum level;

  @Enumerated(EnumType.STRING)
  @Column(name = "SECRET_QUESTION")
  private SecretQuestionEnum secretQuestion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_BRANCH")
  private BranchModel branch;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_INSPECTION_PLACE")
  private InspectionPlaceModel inspectionPlace;

  @OneToMany(mappedBy = "doctor")
  private List<ReviewsAboutDoctorsModel> reviewsAboutDoctorsModels;

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

  public String getRecordNumber() {
    return recordNumber;
  }

  public void setRecordNumber(String recordNumber) {
    this.recordNumber = recordNumber;
  }

  public String getQuestionAnswer() {
    return questionAnswer;
  }

  public void setQuestionAnswer(String questionAnswer) {
    this.questionAnswer = questionAnswer;
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

  public BranchModel getBranch() {
    return branch;
  }

  public void setBranch(BranchModel branch) {
    this.branch = branch;
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

  public LevelEnum getLevel() {
    return level;
  }

  public void setLevel(LevelEnum level) {
    this.level = level;
  }

  public SecretQuestionEnum getSecretQuestion() {
    return secretQuestion;
  }

  public void setSecretQuestion(SecretQuestionEnum secretQuestion) {
    this.secretQuestion = secretQuestion;
  }

  public InspectionPlaceModel getInspectionPlace() {
    return inspectionPlace;
  }

  public void setInspectionPlace(InspectionPlaceModel inspectionPlace) {
    this.inspectionPlace = inspectionPlace;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
