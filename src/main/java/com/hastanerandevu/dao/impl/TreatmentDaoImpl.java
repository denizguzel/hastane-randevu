package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.TreatmentDao;
import com.hastanerandevu.model.TreatmentModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TreatmentDaoImpl implements TreatmentDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createTreatment (String treatmentName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    TreatmentModel treatmentModel = new TreatmentModel();
    treatmentModel.setTreatmentName(treatmentName);

    entitymanager.persist(treatmentModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateTreatment (long id, String treatmentName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    TreatmentModel treatmentModel = entitymanager.find(TreatmentModel.class, id);

    treatmentModel.setTreatmentName(treatmentName);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteTreatment (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    TreatmentModel treatmentModel = entitymanager.find(TreatmentModel.class, id);
    entitymanager.remove(treatmentModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public TreatmentModel findTreatment (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(TreatmentModel.class, id);
  }

  @Override
  public List<TreatmentModel> getAllTreatments () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM TreatmentModel e", TreatmentModel.class).getResultList();
  }
}
