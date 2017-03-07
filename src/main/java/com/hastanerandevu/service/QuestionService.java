package com.hastanerandevu.service;

import com.hastanerandevu.model.QuestionModel;

import java.util.List;

public interface QuestionService {
  void createQuestion (String questionText);

  void updateQuestion (long id, String questionText);

  void deleteQuestion (long id);

  QuestionModel findQuestion (long id);

  List<QuestionModel> getAllQuestions ();
}
