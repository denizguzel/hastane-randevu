package com.hastanerandevu.dao;

import com.hastanerandevu.enums.HospitalTypeEnum;
import com.hastanerandevu.model.HospitalModel;

import java.util.List;

/**
 * Created by Okan on 6.3.2017.
 */
public interface HospitalDao {

  public List<HospitalModel> getAllHospitalsByHospitalType(HospitalTypeEnum hospitalTypeEnum);
}
