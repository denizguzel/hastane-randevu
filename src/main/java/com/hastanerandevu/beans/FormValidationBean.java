package com.hastanerandevu.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;

@ManagedBean(name = "form")
@ViewScoped
public class FormValidationBean {
  private UIInput tcNumber;
  private UIInput recordNumber;
  private UIInput password;
  private UIInput passwordAgain;
  private UIInput firstName;
  private UIInput lastName;
  private UIInput birthdate;
  private UIInput birthplace;
  private UIInput fatherName;
  private UIInput motherName;
  private UIInput secretAnswer;
  private UIInput email;
  private UIInput phone;
  private UIInput address;

  public UIInput getTcNumber() {
    return tcNumber;
  }

  public void setTcNumber(UIInput tcNumber) {
    this.tcNumber = tcNumber;
  }

  public UIInput getRecordNumber() {
    return recordNumber;
  }

  public void setRecordNumber(UIInput recordNumber) {
    this.recordNumber = recordNumber;
  }

  public UIInput getPassword() {
    return password;
  }

  public void setPassword(UIInput password) {
    this.password = password;
  }

  public UIInput getPasswordAgain() {
    return passwordAgain;
  }

  public void setPasswordAgain(UIInput passwordAgain) {
    this.passwordAgain = passwordAgain;
  }

  public UIInput getFirstName() {
    return firstName;
  }

  public void setFirstName(UIInput firstName) {
    this.firstName = firstName;
  }

  public UIInput getLastName() {
    return lastName;
  }

  public void setLastName(UIInput lastName) {
    this.lastName = lastName;
  }

  public UIInput getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(UIInput birthdate) {
    this.birthdate = birthdate;
  }

  public UIInput getBirthplace() {
    return birthplace;
  }

  public void setBirthplace(UIInput birthplace) {
    this.birthplace = birthplace;
  }

  public UIInput getFatherName() {
    return fatherName;
  }

  public void setFatherName(UIInput fatherName) {
    this.fatherName = fatherName;
  }

  public UIInput getMotherName() {
    return motherName;
  }

  public void setMotherName(UIInput motherName) {
    this.motherName = motherName;
  }

  public UIInput getSecretAnswer() {
    return secretAnswer;
  }

  public void setSecretAnswer(UIInput secretAnswer) {
    this.secretAnswer = secretAnswer;
  }

  public UIInput getEmail() {
    return email;
  }

  public void setEmail(UIInput email) {
    this.email = email;
  }

  public UIInput getPhone() {
    return phone;
  }

  public void setPhone(UIInput phone) {
    this.phone = phone;
  }

  public UIInput getAddress() {
    return address;
  }

  public void setAddress(UIInput address) {
    this.address = address;
  }
}
