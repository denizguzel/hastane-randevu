package com.hastanerandevu.dao;

import com.hastanerandevu.model.SurveyModel;

import java.util.List;

public interface SurveyDao {
  void createSurvey (String surveyDescription);

  void updateSurvey (long id, String surveyDescription);

  void deleteSurvey (long id);

  SurveyModel findSurvey (long id);

  List<SurveyModel> getAllSurveys ();
}
