package com.hastanerandevu.service;

import com.hastanerandevu.dao.SurveyDaoImpl;
import com.hastanerandevu.model.SurveyModel;

import java.util.List;

public class SurveyServiceImpl implements BaseService<SurveyModel> {
  private SurveyDaoImpl surveyDao = new SurveyDaoImpl();

  @Override
  public void create (SurveyModel model) {
    surveyDao.create(model);
  }

  @Override
  public void update (long id, SurveyModel model) {
    surveyDao.update(id, model);
  }

  @Override
  public void delete (long id) {
    surveyDao.delete(id);
  }

  @Override
  public SurveyModel find (long id) {
    return surveyDao.find(id);
  }

  @Override
  public List<SurveyModel> findAll () {
    return surveyDao.findAll();
  }
}
