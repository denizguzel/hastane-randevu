package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.AssayDao;
import com.hastanerandevu.model.AssayModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AssayDaoImpl implements AssayDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createAssay (String assayName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    AssayModel assayModel = new AssayModel();
    assayModel.setAssayName(assayName);

    entitymanager.persist(assayModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateAssay (long id, String assayName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    AssayModel assayModel = entitymanager.find(AssayModel.class, id);

    assayModel.setAssayName(assayName);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteAssay (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    AssayModel assayModel = entitymanager.find(AssayModel.class, id);
    entitymanager.remove(assayModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public AssayModel findAssay (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(AssayModel.class, id);
  }

  @Override
  public List<AssayModel> getAllAssays () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM AssayModel e", AssayModel.class).getResultList();
  }
}
