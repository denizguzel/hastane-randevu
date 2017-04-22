package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.QuestionDaoImpl;
import com.hastanerandevu.model.OptionModel;
import com.hastanerandevu.model.QuestionModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class QuestionServiceImpl implements BaseService<QuestionModel> {
  private QuestionDaoImpl questionDao = new QuestionDaoImpl();
  private OptionServiceImpl optionService = new OptionServiceImpl();

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

  public List<OptionModel> getOptionsByQuestion(QuestionModel questionModel){
    return questionDao.getOptionsByQuestion(questionModel);
  }

  public void answerSurveyQuestion(OptionModel optionModel){
    optionModel.setCount(optionModel.getCount() + 1);
    optionService.update(optionModel);
  }
}
