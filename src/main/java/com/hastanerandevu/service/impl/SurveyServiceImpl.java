package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.SurveyDao;
import com.hastanerandevu.dao.impl.SurveyDaoImpl;
import com.hastanerandevu.model.SurveyModel;
import com.hastanerandevu.service.SurveyService;

import java.util.List;

public class SurveyServiceImpl implements SurveyService {
  private SurveyDao surveyDao = new SurveyDaoImpl();

  @Override
  public void createSurvey (String surveyDescription) {
    surveyDao.createSurvey(surveyDescription);
  }

  @Override
  public void updateSurvey (long id, String surveyDescription) {
    surveyDao.updateSurvey(id, surveyDescription);
  }

  @Override
  public void deleteSurvey (long id) {
    surveyDao.deleteSurvey(id);
  }

  @Override
  public SurveyModel findSurvey (long id) {
    return surveyDao.findSurvey(id);
  }

  @Override
  public List<SurveyModel> getAllSurveys () {
    return surveyDao.getAllSurveys();
  }
}
