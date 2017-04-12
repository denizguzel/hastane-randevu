package com.hastanerandevu.dao.impl;

import com.hastanerandevu.comparators.InspectionPlaceComparator;
import com.hastanerandevu.model.HospitalModel;
import com.hastanerandevu.model.HospitalPoliclinicRelModel;
import com.hastanerandevu.model.InspectionPlaceModel;
import com.hastanerandevu.model.PoliclinicModel;

import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

public class PoliclinicDaoImpl extends BaseDaoImpl<PoliclinicModel> {

  public List<InspectionPlaceModel> getInspectionPlacesByHospitalPoliclinic(PoliclinicModel policlinicModel,HospitalModel hospitalModel) {

    Query query = getEntitymanager().createQuery("SELECT e FROM HospitalPoliclinicRelModel e WHERE e.policlinic = :policlinicModel AND e.hospital = :hospitalModel ");
    query.setParameter("policlinicModel", policlinicModel);
    query.setParameter("hospitalModel", hospitalModel);

    HospitalPoliclinicRelModel hospitalPoliclinicRelModel = (HospitalPoliclinicRelModel) query.getResultList().get(0);

    List<InspectionPlaceModel> inspectionPlaceModels = hospitalPoliclinicRelModel.getInspectionPlaceModels();

    Collections.sort(inspectionPlaceModels,new InspectionPlaceComparator());

    return inspectionPlaceModels;
    /*Map<String, String> results = new LinkedHashMap<>();
    for(InspectionPlaceModel inspectionPlace : list) {
      results.put(inspectionPlace.getPlaceName(), String.valueOf(inspectionPlace.getPk()));
    }

    return results;*/
  }

}
