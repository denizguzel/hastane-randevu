package com.hastanerandevu.dao.impl;

import com.hastanerandevu.model.OptionModel;
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

  public List<OptionModel> getOptionsBySurvey(SurveyModel surveyModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM OptionModel e WHERE e.survey = :SURVEY_MODEL " + "ORDER BY e.sortOrderNo ASC");

    query.setParameter("SURVEY_MODEL", surveyModel);

    return query.getResultList();
  }

  public List<OptionModel> getNumberOfVotes(SurveyModel surveyModel) {
    Query query = getEntitymanager().createQuery("SELECT SUM(e.count) FROM OptionModel e WHERE e.survey = :survey_model");

    query.setParameter("survey_model", surveyModel);

    return query.getResultList();
  }
}
