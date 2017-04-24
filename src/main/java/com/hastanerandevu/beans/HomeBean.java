package com.hastanerandevu.beans;

import com.hastanerandevu.model.FrequentlyAskedQuestionsModel;
import com.hastanerandevu.model.OptionModel;
import com.hastanerandevu.model.SurveyModel;
import com.hastanerandevu.service.impl.FrequentlyAskedQuestionsServiceImpl;
import com.hastanerandevu.service.impl.SurveyServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "home")
@ViewScoped
public class HomeBean implements Serializable {

  private SurveyServiceImpl surveyService;
  private FrequentlyAskedQuestionsServiceImpl frequentlyAskedQuestionsService;

  private Long optionPk;
  private boolean cookieCheck = false;

  private List<FrequentlyAskedQuestionsModel> askedQuestions;
  private List<SurveyModel> surveys;
  private List<OptionModel> options;

  public HomeBean() throws UnsupportedEncodingException {
    surveyService = new SurveyServiceImpl();
    frequentlyAskedQuestionsService = new FrequentlyAskedQuestionsServiceImpl();

    askedQuestions = new ArrayList<>();
    surveys = new ArrayList<>();
    options = new ArrayList<>();

    askedQuestions.addAll(frequentlyAskedQuestionsService.getAllAskedQuestions());
    surveys.addAll(surveyService.getSurveys());
  }

  public boolean isCookieCheck() {
    return cookieCheck;
  }

  public void setCookieCheck(boolean cookieCheck) {
    this.cookieCheck = cookieCheck;
  }

  public Long getOptionPk() {
    return optionPk;
  }

  public void setOptionPk(Long optionPk) {
    this.optionPk = optionPk;
  }

  @PostConstruct
  public void init() {
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    String cookieName = "surveysDone";
    Cookie[] userCookies = request.getCookies();
    if(userCookies.length > 0) {
      for(Cookie userCookie : userCookies) {
        if(userCookie.getName().equals(cookieName) && userCookie.getValue().equals("yes")) {
          setCookieCheck(true);
        }
      }
    }
  }

  public List<FrequentlyAskedQuestionsModel> getAskedQuestions() {
    return askedQuestions;
  }

  public List<SurveyModel> getSurveys() {
    return surveys;
  }

  public List<OptionModel> getOptions() {
    return options;
  }

  public SurveyServiceImpl getSurveyService() {
    return surveyService;
  }

  public void setSurveyService(SurveyServiceImpl surveyService) {
    this.surveyService = surveyService;
  }

  public String answerSurvey() throws UnsupportedEncodingException {
    //surveyService.answerSurvey(new OptionServiceImpl().find(getOptionPk()));
    System.out.println(getOptionPk());
    return "/index?faces-redirect=true";
  }
}
