package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.AlergyDao;
import com.hastanerandevu.model.AlergyModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AlergyDaoImpl implements AlergyDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createAlergy (String alergyName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    AlergyModel alergyModel = new AlergyModel();
    alergyModel.setAlergyName(alergyName);

    entitymanager.persist(alergyModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateAlergy (long id, String alergyName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    AlergyModel alergyModel = entitymanager.find(AlergyModel.class, id);

    alergyModel.setAlergyName(alergyName);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteAlergy (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    AlergyModel alergyModel = entitymanager.find(AlergyModel.class, id);
    entitymanager.remove(alergyModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public AlergyModel findAlergy (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(AlergyModel.class, id);
  }

  @Override
  public List<AlergyModel> getAllAlergies () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM AlergyModel e", AlergyModel.class).getResultList();
  }
}
