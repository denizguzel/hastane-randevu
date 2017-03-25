package com.hastanerandevu.dao;

import com.hastanerandevu.model.HospitalPoliclinicRelModel;
import com.hastanerandevu.model.InspectionPlaceModel;
import com.hastanerandevu.model.PoliclinicModel;

import javax.persistence.Query;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PoliclinicDaoImpl extends BaseDaoImpl<PoliclinicModel> {

  public Map<String, String> getInspectionPlaceByPoliclinic(HospitalPoliclinicRelModel hospitalPoliclinicRelModel) {

    Query query = getEntitymanager().createQuery("SELECT e FROM InspectionPlaceModel e WHERE e.hospitalPoliclinicRel = :policlinicModel ORDER BY e.placeName");
    query.setParameter("policlinicModel", hospitalPoliclinicRelModel);

    List<InspectionPlaceModel> list = query.getResultList();
    Map<String, String> results = new LinkedHashMap<>();
    for(InspectionPlaceModel inspectionPlace : list) {
      results.put(inspectionPlace.getPlaceName(), String.valueOf(inspectionPlace.getPk()));
    }

    return results;
  }

}
