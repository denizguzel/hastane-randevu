package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.FrequentlyAskedQuestionsDao;
import com.hastanerandevu.dao.impl.FrequentlyAskedQuestionsDaoImpl;
import com.hastanerandevu.model.FrequentlyAskedQuestionsModel;
import com.hastanerandevu.service.FrequentlyAskedQuestionsService;

import java.util.List;

public class FrequentlyAskedQuestionsServiceImpl implements FrequentlyAskedQuestionsService {
  private FrequentlyAskedQuestionsDao frequentlyAskedQuestionsDao = new FrequentlyAskedQuestionsDaoImpl();

  @Override
  public void createFrequentlyAskedQuestions (String question, String answer) {
    frequentlyAskedQuestionsDao.createFrequentlyAskedQuestions(question, answer);
  }

  @Override
  public void updateFrequentlyAskedQuestions (long id, String question, String answer) {
    frequentlyAskedQuestionsDao.updateFrequentlyAskedQuestions(id, question, answer);
  }

  @Override
  public void deleteFrequentlyAskedQuestions (long id) {
    frequentlyAskedQuestionsDao.deleteFrequentlyAskedQuestions(id);
  }

  @Override
  public FrequentlyAskedQuestionsModel findFrequentlyAskedQuestions (long id) {
    return frequentlyAskedQuestionsDao.findFrequentlyAskedQuestions(id);
  }

  @Override
  public List<FrequentlyAskedQuestionsModel> getAllFrequentlyAskedQuestions () {
    return frequentlyAskedQuestionsDao.getAllFrequentlyAskedQuestions();
  }
}
