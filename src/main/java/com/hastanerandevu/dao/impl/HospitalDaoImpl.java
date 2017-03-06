package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.HospitalDao;
import com.hastanerandevu.model.HospitalModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Okan on 6.3.2017.
 */
public class HospitalDaoImpl implements HospitalDao {

  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createHospital(String hospitalName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    HospitalModel hospitalModel = new HospitalModel();
    hospitalModel.setHospitalName(hospitalName);

    entitymanager.persist(hospitalModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateHospital(long id, String hospitalName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    HospitalModel hospitalModel = entitymanager.find(HospitalModel.class, id);

    hospitalModel.setHospitalName(hospitalName);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteHospital(long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    HospitalModel hospitalModel = entitymanager.find(HospitalModel.class, id);
    entitymanager.remove(hospitalModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public HospitalModel findHospital(long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(HospitalModel.class, id);
  }

  @Override
  public List<HospitalModel> getAllHospitals() {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM HospitalModel e", HospitalModel.class).getResultList();
  }
}
