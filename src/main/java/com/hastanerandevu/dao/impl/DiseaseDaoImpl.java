package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.DiseaseDao;
import com.hastanerandevu.model.DiseaseModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DiseaseDaoImpl implements DiseaseDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createDisease (String diseaseName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    DiseaseModel diseaseModel = new DiseaseModel();
    diseaseModel.setDiseaseName(diseaseName);

    entitymanager.persist(diseaseModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateDisease (long id, String diseaseName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    DiseaseModel diseaseModel = entitymanager.find(DiseaseModel.class, id);

    diseaseModel.setDiseaseName(diseaseName);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteDisease (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    DiseaseModel diseaseModel = entitymanager.find(DiseaseModel.class, id);
    entitymanager.remove(diseaseModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public DiseaseModel findDisease (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(DiseaseModel.class, id);
  }

  @Override
  public List<DiseaseModel> getAllDiseases () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM DiseaseModel e", DiseaseModel.class).getResultList();
  }
}
