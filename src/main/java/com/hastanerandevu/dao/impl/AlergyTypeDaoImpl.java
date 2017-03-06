package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.AlergyTypeDao;
import com.hastanerandevu.model.AlergyTypeModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AlergyTypeDaoImpl implements AlergyTypeDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createAlergyType (String alergyTypeName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    AlergyTypeModel alergyTypeModel = new AlergyTypeModel();
    alergyTypeModel.setTypeName(alergyTypeName);

    entitymanager.persist(alergyTypeModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateAlergyType (long id, String alergyTypeName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    AlergyTypeModel alergyTypeModel = entitymanager.find(AlergyTypeModel.class, id);

    alergyTypeModel.setTypeName(alergyTypeName);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteAlergyType (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    AlergyTypeModel alergyTypeModel = entitymanager.find(AlergyTypeModel.class, id);
    entitymanager.remove(alergyTypeModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public AlergyTypeModel findAlergyType (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(AlergyTypeModel.class, id);
  }

  @Override
  public List<AlergyTypeModel> getAllAlergyTypes () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM AlergyTypeModel e", AlergyTypeModel.class).getResultList();
  }
}
