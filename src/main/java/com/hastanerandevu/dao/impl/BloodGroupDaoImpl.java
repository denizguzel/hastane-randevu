package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.BloodGroupDao;
import com.hastanerandevu.model.BloodGroupModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BloodGroupDaoImpl implements BloodGroupDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public BloodGroupModel findBloodGroup (long id) {
    EntityManager entityManager = emfactory.createEntityManager();
    return entityManager.find(BloodGroupModel.class, id);
  }

  @Override
  public List<BloodGroupModel> getAllBloodGroups () {
    EntityManager entityManager = emfactory.createEntityManager();
    return entityManager.createQuery("SELECT e FROM BloodGroupModel e", BloodGroupModel.class).getResultList();
  }
}
