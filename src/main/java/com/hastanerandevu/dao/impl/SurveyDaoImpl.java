package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.SurveyDao;
import com.hastanerandevu.model.SurveyModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SurveyDaoImpl implements SurveyDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createSurvey (String surveyDescription) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    SurveyModel surveyModel = new SurveyModel();
    surveyModel.setSurveyDescription(surveyDescription);

    entitymanager.persist(surveyModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateSurvey (long id, String surveyDescription) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    SurveyModel surveyModel = entitymanager.find(SurveyModel.class, id);

    surveyModel.setSurveyDescription(surveyDescription);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteSurvey (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    SurveyModel surveyModel = entitymanager.find(SurveyModel.class, id);
    entitymanager.remove(surveyModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public SurveyModel findSurvey (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(SurveyModel.class, id);
  }

  @Override
  public List<SurveyModel> getAllSurveys () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM SurveyModel e", SurveyModel.class).getResultList();
  }
}
