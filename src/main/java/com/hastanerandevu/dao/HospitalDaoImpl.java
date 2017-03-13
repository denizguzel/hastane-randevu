package com.hastanerandevu.dao;

import com.hastanerandevu.enums.HospitalTypeEnum;
import com.hastanerandevu.model.HospitalModel;

import java.util.List;

public class HospitalDaoImpl extends BaseDaoImpl<HospitalModel> {

  public List<HospitalModel> getAllHospitalsByHospitalType (HospitalTypeEnum hospitalTypeEnum) {
    return super.getEntitymanager().createQuery("SELECT e FROM HospitalModel e WHERE e.hospitalType =:param", HospitalModel.class).setParameter("param", hospitalTypeEnum).getResultList();
  }
}
