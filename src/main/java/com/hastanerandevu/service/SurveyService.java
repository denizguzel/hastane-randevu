package com.hastanerandevu.service;

import com.hastanerandevu.model.SurveyModel;

import java.util.List;

public interface SurveyService {
  void createSurvey (String surveyDescription);

  void updateSurvey (long id, String surveyDescription);

  void deleteSurvey (long id);

  SurveyModel findSurvey (long id);

  List<SurveyModel> getAllSurveys ();
}
