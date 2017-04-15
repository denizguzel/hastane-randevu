package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.SurveyDaoImpl;
import com.hastanerandevu.model.SurveyModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class SurveyServiceImpl implements BaseService<SurveyModel> {
  private SurveyDaoImpl surveyDao = new SurveyDaoImpl();

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

  public List<SurveyModel> getSurveys(){
    return surveyDao.getSurveys();
  }
}
