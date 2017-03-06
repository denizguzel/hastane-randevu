package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.BranchDao;
import com.hastanerandevu.model.BranchModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BranchDaoImpl implements BranchDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createBranch (String branchName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    BranchModel branchModel = new BranchModel();
    branchModel.setBranchName(branchName);

    entitymanager.persist(branchModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateBranch (long id, String branchName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    BranchModel branchModel = entitymanager.find(BranchModel.class, id);

    branchModel.setBranchName(branchName);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteBranch (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    BranchModel branchModel = entitymanager.find(BranchModel.class, id);
    entitymanager.remove(branchModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public BranchModel findBranch (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(BranchModel.class, id);
  }

  @Override
  public List<BranchModel> getAllBranchs () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM BranchModel e", BranchModel.class).getResultList();
  }
}
