package com.hastanerandevu.dao;

import com.hastanerandevu.model.QuestionModel;

import java.util.List;

public interface QuestionDao {
  void createQuestion (String questionText);

  void updateQuestion (long id, String questionText);

  void deleteQuestion (long id);

  QuestionModel findQuestion (long id);

  List<QuestionModel> getAllQuestions ();
}
