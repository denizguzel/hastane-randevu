package com.hastanerandevu.service;

import com.hastanerandevu.dao.QuestionDaoImpl;
import com.hastanerandevu.model.QuestionModel;

import java.util.List;

public class QuestionServiceImpl implements BaseService<QuestionModel> {
  private QuestionDaoImpl questionDao = new QuestionDaoImpl();

  @Override
  public void create (QuestionModel model) {
    questionDao.create(model);
  }

  @Override
  public void update (long id, QuestionModel model) {
    questionDao.update(id, model);
  }

  @Override
  public void delete (long id) {
    questionDao.delete(id);
  }

  @Override
  public QuestionModel find (long id) {
    return questionDao.find(id);
  }

  @Override
  public List<QuestionModel> findAll () {
    return questionDao.findAll();
  }
}
