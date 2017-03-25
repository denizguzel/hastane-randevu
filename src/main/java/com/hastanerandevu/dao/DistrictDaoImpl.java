package com.hastanerandevu.dao;

import com.hastanerandevu.model.DistrictModel;
import com.hastanerandevu.model.HospitalModel;

import javax.persistence.Query;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DistrictDaoImpl extends BaseDaoImpl<DistrictModel> {

  public List<HospitalModel> getHospitalByDistrict(DistrictModel districtModel) {

    Query query = getEntitymanager().createQuery("SELECT e FROM HospitalModel e WHERE e.districtModel = :districtModel ORDER BY e.hospitalName");
    query.setParameter("districtModel", districtModel);

    return query.getResultList();
    /*Map<String, String> results = new LinkedHashMap<>();
    for(HospitalModel hospitalModel : list) {
      results.put(hospitalModel.getHospitalName(), String.valueOf(hospitalModel.getPk()));
    }

    return results;*/
  }
}
