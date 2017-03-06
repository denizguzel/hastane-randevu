package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.DiseaseTypeDao;
import com.hastanerandevu.model.DiseaseTypeModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DiseaseTypeDaoImpl implements DiseaseTypeDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createDiseaseType (String diseaseTypeName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    DiseaseTypeModel diseaseTypeModel = new DiseaseTypeModel();
    diseaseTypeModel.setTypeName(diseaseTypeName);

    entitymanager.persist(diseaseTypeModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateDiseaseType (long id, String diseaseTypeName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    DiseaseTypeModel diseaseTypeModel = entitymanager.find(DiseaseTypeModel.class, id);

    diseaseTypeModel.setTypeName(diseaseTypeName);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteDiseaseType (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    DiseaseTypeModel diseaseTypeModel = entitymanager.find(DiseaseTypeModel.class, id);
    entitymanager.remove(diseaseTypeModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public DiseaseTypeModel findDiseaseType (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(DiseaseTypeModel.class, id);
  }

  @Override
  public List<DiseaseTypeModel> getAllDiseaseTypes () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM DiseaseTypeModel e", DiseaseTypeModel.class).getResultList();
  }
}
