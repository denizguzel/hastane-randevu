package com.hastanerandevu.service;

import com.hastanerandevu.dao.FrequentlyAskedQuestionsDaoImpl;
import com.hastanerandevu.model.FrequentlyAskedQuestionsModel;

import java.util.List;

public class FrequentlyAskedQuestionsServiceImpl implements BaseService<FrequentlyAskedQuestionsModel> {
  private FrequentlyAskedQuestionsDaoImpl frequentlyAskedQuestionsDao = new FrequentlyAskedQuestionsDaoImpl();

  @Override
  public void create (FrequentlyAskedQuestionsModel model) {
    frequentlyAskedQuestionsDao.create(model);
  }

  @Override
  public void update (long id, FrequentlyAskedQuestionsModel model) {
    frequentlyAskedQuestionsDao.update(id, model);
  }

  @Override
  public void delete (long id) {
    frequentlyAskedQuestionsDao.delete(id);
  }

  @Override
  public FrequentlyAskedQuestionsModel find (long id) {
    return frequentlyAskedQuestionsDao.find(id);
  }

  @Override
  public List<FrequentlyAskedQuestionsModel> findAll () {
    return frequentlyAskedQuestionsDao.findAll();
  }
}
