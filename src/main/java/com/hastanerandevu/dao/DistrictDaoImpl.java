package com.hastanerandevu.dao;

import com.hastanerandevu.model.DistrictModel;
import com.hastanerandevu.model.HospitalModel;

import javax.persistence.Query;
import java.util.List;

public class DistrictDaoImpl extends BaseDaoImpl<DistrictModel> {

  public List<HospitalModel> getHospitalByDistrict(DistrictModel districtModel) {

    Query query = getEntitymanager().createQuery("SELECT e FROM HospitalModel e WHERE e.districtModel = :DISTRICT_MODEL ORDER BY e.hospitalName").setParameter("DISTRICT_MODEL", districtModel);

    return (List<HospitalModel>) query.getResultList();
  }
}
