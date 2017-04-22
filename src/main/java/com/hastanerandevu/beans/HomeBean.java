package com.hastanerandevu.beans;

import com.hastanerandevu.model.FrequentlyAskedQuestionsModel;
import com.hastanerandevu.service.impl.FrequentlyAskedQuestionsServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ouzun on 4/22/2017.
 */
@ManagedBean(name = "home")
@ViewScoped
public class HomeBean implements Serializable {
  private FrequentlyAskedQuestionsServiceImpl frequentlyAskedQuestionsService = new FrequentlyAskedQuestionsServiceImpl();

  private List<FrequentlyAskedQuestionsModel> askedQuestions = askedQuestions = new ArrayList<>();

  public HomeBean(){
    for (FrequentlyAskedQuestionsModel askedQuestionsModel : frequentlyAskedQuestionsService.getAllAskedQuestions()){
      askedQuestions.add(askedQuestionsModel);
    }
  }

  public FrequentlyAskedQuestionsServiceImpl getFrequentlyAskedQuestionsService() {
    return frequentlyAskedQuestionsService;
  }

  public void setFrequentlyAskedQuestionsService(FrequentlyAskedQuestionsServiceImpl frequentlyAskedQuestionsService) {
    this.frequentlyAskedQuestionsService = frequentlyAskedQuestionsService;
  }

  public List<FrequentlyAskedQuestionsModel> getAskedQuestions() {
    return askedQuestions;
  }

  public void setAskedQuestions(List<FrequentlyAskedQuestionsModel> askedQuestions) {
    this.askedQuestions = askedQuestions;
  }
}
