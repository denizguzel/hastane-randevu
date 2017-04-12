package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.QuestionDaoImpl;
import com.hastanerandevu.model.QuestionModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class QuestionServiceImpl implements BaseService<QuestionModel> {
  private QuestionDaoImpl questionDao = new QuestionDaoImpl();

  @Override
  public void create(QuestionModel model) {
    questionDao.create(model);
  }

  @Override
  public void update(QuestionModel model) {
    questionDao.update(model);
  }

  @Override
  public void delete(QuestionModel model) {
    questionDao.delete(model);
  }

  @Override
  public QuestionModel find(long id) {
    return questionDao.find(id);
  }

  @Override
  public List<QuestionModel> findAll() {
    return questionDao.findAll();
  }
}
