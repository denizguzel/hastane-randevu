package com.hastanerandevu.service;

import com.hastanerandevu.model.BloodGroupModel;

import java.util.List;

public interface BloodGroupService {
  BloodGroupModel findBloodGroup (long id);

  List<BloodGroupModel> getAllBloodGroups ();
}
