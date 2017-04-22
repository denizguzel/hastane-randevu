package com.hastanerandevu.dao.impl;

import com.hastanerandevu.model.OptionModel;
import com.hastanerandevu.model.QuestionModel;

import javax.persistence.Query;
import java.util.List;

public class QuestionDaoImpl extends BaseDaoImpl<QuestionModel> {
  public List<OptionModel> getOptionsByQuestion(QuestionModel questionModel){
    Query query = getEntitymanager().createQuery("SELECT e FROM OptionModel e WHERE e.question = :QUESTION_MODEL ORDER BY e.sortOrderNo");
    query.setParameter("QUESTION_MODEL",questionModel);

    return query.getResultList();
  }
}
