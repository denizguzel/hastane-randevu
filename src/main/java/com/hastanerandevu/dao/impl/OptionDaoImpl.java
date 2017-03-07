package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.OptionDao;
import com.hastanerandevu.model.OptionModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class OptionDaoImpl implements OptionDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createOption (String optionText) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    OptionModel surveyModel = new OptionModel();
    surveyModel.setOptionText(optionText);

    entitymanager.persist(surveyModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateOption (long id, String optionText) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    OptionModel surveyModel = entitymanager.find(OptionModel.class, id);

    surveyModel.setOptionText(optionText);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteOption (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    OptionModel surveyModel = entitymanager.find(OptionModel.class, id);
    entitymanager.remove(surveyModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public OptionModel findOption (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(OptionModel.class, id);
  }

  @Override
  public List<OptionModel> getAllOptions () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM OptionModel e", OptionModel.class).getResultList();
  }
}
