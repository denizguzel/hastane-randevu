package com.hastanerandevu.dao;

import com.hastanerandevu.model.DistrictModel;
import com.hastanerandevu.model.HospitalModel;

import javax.persistence.Query;
import java.util.List;

public class DistrictDaoImpl extends BaseDaoImpl<DistrictModel> {

  public List<HospitalModel> getHospitalByDistrict(DistrictModel districtModel) {
    Query query1 = getEntitymanager().createQuery("SELECT e FROM DistrictModel e WHERE e.districtName = :DISTRICT_NAME").setParameter("DISTRICT_NAME", districtModel.getDistrictName());

    districtModel = (DistrictModel) query1.getSingleResult();

    Query query = getEntitymanager().createQuery("SELECT e.hospitalName FROM HospitalModel e WHERE e.districtModel = :districtModel").setParameter("districtModel", districtModel);

    return (List<HospitalModel>) query.getResultList();
  }
}
