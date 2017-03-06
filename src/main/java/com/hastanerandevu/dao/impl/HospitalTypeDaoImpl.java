package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.HospitalTypeDao;
import com.hastanerandevu.model.HospitalTypeModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class HospitalTypeDaoImpl implements HospitalTypeDao {

  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createHospitalType (String hospitalTypeName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    HospitalTypeModel hospitalTypeModel = new HospitalTypeModel();
    hospitalTypeModel.setTypeName(hospitalTypeName);

    entitymanager.persist(hospitalTypeModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateHospitalType (long id, String hospitalTypeName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    HospitalTypeModel hospitalTypeModel = entitymanager.find(HospitalTypeModel.class, id);

    hospitalTypeModel.setTypeName(hospitalTypeName);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteHospitalType (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    HospitalTypeModel hospitalTypeModel = entitymanager.find(HospitalTypeModel.class, id);
    entitymanager.remove(hospitalTypeModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public HospitalTypeModel findHospitalType (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(HospitalTypeModel.class, id);
  }

  @Override
  public List<HospitalTypeModel> getAllHospitalTypes () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM HospitalTypeModel e", HospitalTypeModel.class).getResultList();
  }
}
