package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.PoliclinicDao;
import com.hastanerandevu.model.PoliclinicModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PoliclinicDaoImpl implements PoliclinicDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createPoliclinic (String policlinicName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    PoliclinicModel surveyModel = new PoliclinicModel();
    surveyModel.setPoliclinicName(policlinicName);

    entitymanager.persist(surveyModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updatePoliclinic (long id, String policlinicName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    PoliclinicModel surveyModel = entitymanager.find(PoliclinicModel.class, id);

    surveyModel.setPoliclinicName(policlinicName);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deletePoliclinic (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    PoliclinicModel surveyModel = entitymanager.find(PoliclinicModel.class, id);
    entitymanager.remove(surveyModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public PoliclinicModel findPoliclinic (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(PoliclinicModel.class, id);
  }

  @Override
  public List<PoliclinicModel> getAllPoliclinics () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM PoliclinicModel e", PoliclinicModel.class).getResultList();
  }
}
