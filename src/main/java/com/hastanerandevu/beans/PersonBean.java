package com.hastanerandevu.beans;

import com.hastanerandevu.DAO.AccountDAO;
import com.hastanerandevu.service.SessionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@ManagedBean (name = "person")
@SessionScoped
public class PersonBean implements Serializable {
  private static final long serialVersionUID = 1094801825228386363L;
  private String username;
  private String password;
  private String tcNo;

  public String getUsername () {
    return username;
  }

  public void setUsername (String username) {
    this.username = username;
  }

  public String getPassword () {
    return password;
  }

  public void setPassword (String password) {
    this.password = password;
  }

  public String getTcNo () {
    return tcNo;
  }

  public void setTcNo (String tcNo) {
    this.tcNo = tcNo;
  }

  public String validateLogin () {
    boolean valid = AccountDAO.loginUser(username, password);
    if ( valid ) {
      HttpSession session = SessionUtils.getSession();
      session.setAttribute("username", username);
      return "view/dashboard?faces-redirect=true";
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Kullanıcı adı ya da şifre yanlış", "Lütfen kullanıcı adı ve şifrenizi tekrar giriniz"));
      return "/";
    }
  }

  public String validateRegister () {
    boolean valid = AccountDAO.createUser(username, password, tcNo);
    if ( valid ) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Kayıt başarılı", null));
      return "/";
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kullaıcı kaydı yapılamadı", "Bilgileri tekrar kontrol edin"));
      return "/";
    }
  }

  public String logout () {
    HttpSession session = SessionUtils.getSession();
    session.invalidate();
    return "/index?faces-redirect=true";
  }

}