package com.hastanerandevu.service;

import com.hastanerandevu.model.BranchModel;

import java.util.List;

public interface BranchService {
  void createBranch (String branchName);

  void updateBranch (long id, String branchName);

  void deleteBranch (long id);

  BranchModel findBranch (long id);

  List<BranchModel> getAllBranchs ();
}
