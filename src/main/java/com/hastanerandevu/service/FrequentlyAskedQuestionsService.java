package com.hastanerandevu.service;

import com.hastanerandevu.model.FrequentlyAskedQuestionsModel;

import java.util.List;

public interface FrequentlyAskedQuestionsService {
  void createFrequentlyAskedQuestions (String question, String answer);

  void updateFrequentlyAskedQuestions (long id, String question, String answer);

  void deleteFrequentlyAskedQuestions (long id);

  FrequentlyAskedQuestionsModel findFrequentlyAskedQuestions (long id);

  List<FrequentlyAskedQuestionsModel> getAllFrequentlyAskedQuestions ();
}
