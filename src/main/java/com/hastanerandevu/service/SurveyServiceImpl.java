package com.hastanerandevu.service;

import com.hastanerandevu.dao.SurveyDaoImpl;
import com.hastanerandevu.model.SurveyModel;

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
}
