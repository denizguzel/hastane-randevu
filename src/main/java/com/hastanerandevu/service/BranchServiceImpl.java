package com.hastanerandevu.service;

import com.hastanerandevu.dao.BranchDaoImpl;
import com.hastanerandevu.model.BranchModel;

import java.util.List;

public class BranchServiceImpl implements BaseService<BranchModel> {
  private BranchDaoImpl branchDao = new BranchDaoImpl();

  @Override
  public void create (BranchModel model) {
    branchDao.create(model);
  }

  @Override
  public void update (long id, BranchModel model) {
    branchDao.update(id, model);
  }

  @Override
  public void delete (long id) {
    branchDao.delete(id);
  }

  @Override
  public BranchModel find (long id) {
    return branchDao.find(id);
  }

  @Override
  public List<BranchModel> findAll () {
    return branchDao.findAll();
  }
}
