package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.FrequentlyAskedQuestionsDao;
import com.hastanerandevu.model.FrequentlyAskedQuestionsModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FrequentlyAskedQuestionsDaoImpl implements FrequentlyAskedQuestionsDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createFrequentlyAskedQuestions (String question, String answer) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    FrequentlyAskedQuestionsModel frequentlyAskedQuestionsModel = new FrequentlyAskedQuestionsModel();
    frequentlyAskedQuestionsModel.setQuestion(question);
    frequentlyAskedQuestionsModel.setAnswer(answer);

    entitymanager.persist(frequentlyAskedQuestionsModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateFrequentlyAskedQuestions (long id, String question, String answer) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    FrequentlyAskedQuestionsModel frequentlyAskedQuestionsModel = entitymanager.find(FrequentlyAskedQuestionsModel.class, id);

    frequentlyAskedQuestionsModel.setQuestion(question);
    frequentlyAskedQuestionsModel.setAnswer(answer);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteFrequentlyAskedQuestions (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    FrequentlyAskedQuestionsModel frequentlyAskedQuestionsModel = entitymanager.find(FrequentlyAskedQuestionsModel.class, id);
    entitymanager.remove(frequentlyAskedQuestionsModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public FrequentlyAskedQuestionsModel findFrequentlyAskedQuestions (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(FrequentlyAskedQuestionsModel.class, id);
  }

  @Override
  public List<FrequentlyAskedQuestionsModel> getAllFrequentlyAskedQuestions () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM FrequentlyAskedQuestionsModel e", FrequentlyAskedQuestionsModel.class).getResultList();
  }
}
