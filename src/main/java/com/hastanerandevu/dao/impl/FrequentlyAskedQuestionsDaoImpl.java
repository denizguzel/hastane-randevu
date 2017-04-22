package com.hastanerandevu.dao.impl;

import com.hastanerandevu.model.FrequentlyAskedQuestionsModel;

import javax.persistence.Query;
import java.util.List;

public class FrequentlyAskedQuestionsDaoImpl extends BaseDaoImpl<FrequentlyAskedQuestionsModel> {
  public List<FrequentlyAskedQuestionsModel> getAllAskedQuestions() {
    Query query = getEntitymanager().createQuery("SELECT e FROM FrequentlyAskedQuestionsModel e ORDER BY e.creationTime DESC");
    return query.getResultList();
  }
}
