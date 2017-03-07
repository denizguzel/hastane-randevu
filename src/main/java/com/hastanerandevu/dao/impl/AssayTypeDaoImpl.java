package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.AssayTypeDao;
import com.hastanerandevu.model.AssayTypeModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AssayTypeDaoImpl implements AssayTypeDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createAssayType (String assayTypeName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    AssayTypeModel assayTypeModel = new AssayTypeModel();
    assayTypeModel.setTypeName(assayTypeName);

    entitymanager.persist(assayTypeModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateAssayType (long id, String assayTypeName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    AssayTypeModel assayTypeModel = entitymanager.find(AssayTypeModel.class, id);

    assayTypeModel.setTypeName(assayTypeName);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteAssayType (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    AssayTypeModel assayTypeModel = entitymanager.find(AssayTypeModel.class, id);
    entitymanager.remove(assayTypeModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public AssayTypeModel findAssayType (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(AssayTypeModel.class, id);
  }

  @Override
  public List<AssayTypeModel> getAllAssayTypes () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM AssayTypeModel e", AssayTypeModel.class).getResultList();
  }
}
