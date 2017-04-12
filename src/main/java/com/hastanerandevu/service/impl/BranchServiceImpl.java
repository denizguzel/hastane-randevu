package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.BranchDaoImpl;
import com.hastanerandevu.model.BranchModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class BranchServiceImpl implements BaseService<BranchModel> {
  private BranchDaoImpl branchDao = new BranchDaoImpl();

  @Override
  public void create(BranchModel model) {
    branchDao.create(model);
  }

  @Override
  public void update(BranchModel model) {
    branchDao.update(model);
  }

  @Override
  public void delete(BranchModel model) {
    branchDao.delete(model);
  }

  @Override
  public BranchModel find(long id) {
    return branchDao.find(id);
  }

  @Override
  public List<BranchModel> findAll() {
    return branchDao.findAll();
  }
}
