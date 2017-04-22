package com.hastanerandevu.dao.impl;

import com.hastanerandevu.model.QuestionModel;
import com.hastanerandevu.model.SurveyModel;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class SurveyDaoImpl extends BaseDaoImpl<SurveyModel> {
  public List<SurveyModel> getSurveys() {
    Query query = getEntitymanager().createQuery("SELECT e FROM SurveyModel e WHERE e.expirationTime > :date ORDER BY e.creationTime DESC");
    query.setParameter("date", new Date());

    return query.getResultList();
  }

  public List<QuestionModel> getQuestionsBySurvey(SurveyModel surveyModel){
    Query query = getEntitymanager().createQuery("SELECT e FROM QuestionModel e WHERE e.survey = :SURVEY_MODEL " +
      "ORDER BY e.creationTime DESC");

    return query.getResultList();
  }
}
