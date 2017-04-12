package com.hastanerandevu.dao.impl;

import com.hastanerandevu.model.DistrictModel;
import com.hastanerandevu.model.HospitalModel;
import com.hastanerandevu.model.HospitalPoliclinicRelModel;

import javax.persistence.Query;
import java.util.List;

public class DistrictDaoImpl extends BaseDaoImpl<DistrictModel> {

  public List<HospitalModel> getHospitalByDistrict(DistrictModel districtModel) {

    Query query = getEntitymanager().createQuery("SELECT e FROM HospitalModel e WHERE e.districtModel = :districtModel ORDER BY e.hospitalName");
    query.setParameter("districtModel", districtModel);

    return query.getResultList();

  }

  public List<HospitalPoliclinicRelModel> getPoliclinicByDistrict(DistrictModel districtModel){
    Query query = getEntitymanager().createQuery("SELECT e FROM HospitalPoliclinicRelModel e WHERE e.hospital.districtModel = :districtModel ORDER BY e.policlinic.policlinicName");
    query.setParameter("districtModel",districtModel);

    return query.getResultList();
  }

}
