package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.QuestionDao;
import com.hastanerandevu.dao.impl.QuestionDaoImpl;
import com.hastanerandevu.model.QuestionModel;
import com.hastanerandevu.service.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
  private QuestionDao questionDao = new QuestionDaoImpl();

  @Override
  public void createQuestion (String questionText) {
    questionDao.createQuestion(questionText);
  }

  @Override
  public void updateQuestion (long id, String questionText) {
    questionDao.updateQuestion(id, questionText);
  }

  @Override
  public void deleteQuestion (long id) {
    questionDao.deleteQuestion(id);
  }

  @Override
  public QuestionModel findQuestion (long id) {
    return questionDao.findQuestion(id);
  }

  @Override
  public List<QuestionModel> getAllQuestions () {
    return questionDao.getAllQuestions();
  }
}
