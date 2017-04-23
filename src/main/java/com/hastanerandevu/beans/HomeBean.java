package com.hastanerandevu.beans;

import com.hastanerandevu.model.FrequentlyAskedQuestionsModel;
import com.hastanerandevu.model.OptionModel;
import com.hastanerandevu.model.SurveyModel;
import com.hastanerandevu.service.impl.FrequentlyAskedQuestionsServiceImpl;
import com.hastanerandevu.service.impl.OptionServiceImpl;
import com.hastanerandevu.service.impl.SurveyServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "home")
@ViewScoped
public class HomeBean implements Serializable {

  private SurveyServiceImpl surveyService;
  private FrequentlyAskedQuestionsServiceImpl frequentlyAskedQuestionsService;

  private Long optionPk;

  private List<FrequentlyAskedQuestionsModel> askedQuestions;
  private List<SurveyModel> surveys;
  private List<OptionModel> options;

  public HomeBean() {
    surveyService = new SurveyServiceImpl();
    frequentlyAskedQuestionsService = new FrequentlyAskedQuestionsServiceImpl();

    askedQuestions = new ArrayList<>();
    surveys = new ArrayList<>();
    options = new ArrayList<>();

    askedQuestions.addAll(frequentlyAskedQuestionsService.getAllAskedQuestions());
    surveys.addAll(surveyService.getSurveys());

    //SurveyModel surveyModel = new SurveyModel();
    //surveyModel.setPk(100);
    //options.addAll(surveyService.getOptionsBySurvey(surveyModel));

  }

  public void answerSurvey(){
    surveyService.answerSurvey(new OptionServiceImpl().find(optionPk));
    System.out.println("wqeqwe");
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

  public Long getOptionPk() {
    return optionPk;
  }

  public void setOptionPk(Long optionPk) {
    this.optionPk = optionPk;
  }
}
