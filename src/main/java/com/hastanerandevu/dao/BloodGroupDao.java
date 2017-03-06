package com.hastanerandevu.dao;

import com.hastanerandevu.model.BloodGroupModel;

import java.util.List;

public interface BloodGroupDao {
  BloodGroupModel findBloodGroup (long id);

  List<BloodGroupModel> getAllBloodGroups ();
}
