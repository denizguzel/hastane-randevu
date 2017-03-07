package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.QuestionDao;
import com.hastanerandevu.model.QuestionModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createQuestion (String questionText) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    QuestionModel questionModel = new QuestionModel();
    questionModel.setQuestionText(questionText);

    entitymanager.persist(questionModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateQuestion (long id, String questionText) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    QuestionModel questionModel = entitymanager.find(QuestionModel.class, id);

    questionModel.setQuestionText(questionText);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteQuestion (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    QuestionModel questionModel = entitymanager.find(QuestionModel.class, id);
    entitymanager.remove(questionModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public QuestionModel findQuestion (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(QuestionModel.class, id);
  }

  @Override
  public List<QuestionModel> getAllQuestions () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM QuestionModel e", QuestionModel.class).getResultList();
  }
}
