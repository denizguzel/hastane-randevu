package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.TreatmentTypeDao;
import com.hastanerandevu.model.TreatmentTypeModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TreatmentTypeDaoImpl implements TreatmentTypeDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createTreatmentType (String treatmentTypeName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    TreatmentTypeModel treatmentTypeModel = new TreatmentTypeModel();
    treatmentTypeModel.setTypeName(treatmentTypeName);

    entitymanager.persist(treatmentTypeModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateTreatmentType (long id, String treatmentTypeName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    TreatmentTypeModel treatmentTypeModel = entitymanager.find(TreatmentTypeModel.class, id);

    treatmentTypeModel.setTypeName(treatmentTypeName);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteTreatmentType (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    TreatmentTypeModel treatmentTypeModel = entitymanager.find(TreatmentTypeModel.class, id);
    entitymanager.remove(treatmentTypeModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public TreatmentTypeModel findTreatmentType (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(TreatmentTypeModel.class, id);
  }

  @Override
  public List<TreatmentTypeModel> getAllTreatmentTypes () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM TreatmentTypeModel e", TreatmentTypeModel.class).getResultList();
  }
}
