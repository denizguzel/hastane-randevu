package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.BranchDao;
import com.hastanerandevu.dao.impl.BranchDaoImpl;
import com.hastanerandevu.model.BranchModel;
import com.hastanerandevu.service.BranchService;

import java.util.List;

public class BranchServiceImpl implements BranchService {
  private BranchDao branchDao = new BranchDaoImpl();

  @Override
  public void createBranch (String branchName) {
    branchDao.createBranch(branchName);
  }

  @Override
  public void updateBranch (long id, String branchName) {
    branchDao.updateBranch(id, branchName);
  }

  @Override
  public void deleteBranch (long id) {
    branchDao.deleteBranch(id);
  }

  @Override
  public BranchModel findBranch (long id) {
    return branchDao.findBranch(id);
  }

  @Override
  public List<BranchModel> getAllBranchs () {
    return branchDao.getAllBranchs();
  }
}
