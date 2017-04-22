package com.hastanerandevu.beans;

import com.hastanerandevu.model.FrequentlyAskedQuestionsModel;
import com.hastanerandevu.model.QuestionModel;
import com.hastanerandevu.model.SurveyModel;
import com.hastanerandevu.service.impl.FrequentlyAskedQuestionsServiceImpl;
import com.hastanerandevu.service.impl.SurveyServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "home")
@ViewScoped
public class HomeBean implements Serializable {

  private List<FrequentlyAskedQuestionsModel> askedQuestions = new ArrayList<>();
  private List<SurveyModel> surveys = new ArrayList<>();
  private List<QuestionModel> surveyQuestions = new ArrayList<>();

  public HomeBean(){
    FrequentlyAskedQuestionsServiceImpl frequentlyAskedQuestionsService = new FrequentlyAskedQuestionsServiceImpl();
    askedQuestions.addAll(frequentlyAskedQuestionsService.getAllAskedQuestions());

    SurveyModel surveyModel = new SurveyModel();
    surveyModel.setPk(100);
    SurveyServiceImpl surveyService = new SurveyServiceImpl();
    surveys.addAll(surveyService.getSurveys());
    surveyQuestions.addAll(surveyService.getQuestionsBySurvey(surveyModel));
  }

  public List<FrequentlyAskedQuestionsModel> getAskedQuestions() {
    return askedQuestions;
  }

  public List<SurveyModel> getSurveys() {
    return surveys;
  }

  public List<QuestionModel> getSurveyQuestions() {
    return surveyQuestions;
  }
}
