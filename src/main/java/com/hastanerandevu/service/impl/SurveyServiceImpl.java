package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.SurveyDaoImpl;
import com.hastanerandevu.model.OptionModel;
import com.hastanerandevu.model.SurveyModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class SurveyServiceImpl implements BaseService<SurveyModel> {
  private SurveyDaoImpl surveyDao = new SurveyDaoImpl();
  private OptionServiceImpl optionService = new OptionServiceImpl();

  @Override
  public void create(SurveyModel model) {
    surveyDao.create(model);
  }

  @Override
  public void update(SurveyModel model) {
    surveyDao.update(model);
  }

  @Override
  public void delete(SurveyModel model) {
    surveyDao.delete(model);
  }

  @Override
  public SurveyModel find(long id) {
    return surveyDao.find(id);
  }

  @Override
  public List<SurveyModel> findAll() {
    return surveyDao.findAll();
  }

  public List<SurveyModel> getSurveys() {
    return surveyDao.getSurveys();
  }

  public List<OptionModel> getOptionsBySurvey(SurveyModel surveyModel) {
    return surveyDao.getOptionsBySurvey(surveyModel);
  }

  public void answerSurvey(OptionModel optionModel) {
    optionModel.setCount(optionModel.getCount() + 1);
    optionService.update(optionModel);
  }

  public void createSurvey(SurveyModel survey, List<OptionModel> surveyOptions) {
    this.create(survey);
    for(OptionModel option : surveyOptions) {
      option.setSurvey(survey);
      optionService.create(option);
    }
  }

  public void updateSurvey(SurveyModel survey, List<OptionModel> surveyOptions) {
    this.update(survey);
    for(OptionModel option : surveyOptions) {
      option.setSurvey(survey);
      optionService.update(option);
    }
  }

  public void deleteSurvey(SurveyModel survey) {
    for(OptionModel option : getOptionsBySurvey(survey)) {
      optionService.delete(option);
    }
    this.delete(survey);
  }

  public List<OptionModel> getNumberOfVotes(SurveyModel survey) {
    return surveyDao.getNumberOfVotes(survey);
  }
}
