package com.hastanerandevu.dao;

import com.hastanerandevu.model.BranchModel;

import java.util.List;

public interface BranchDao {
  void createBranch (String branchName);

  void updateBranch (long id, String branchName);

  void deleteBranch (long id);

  BranchModel findBranch (long id);

  List<BranchModel> getAllBranchs ();
}
