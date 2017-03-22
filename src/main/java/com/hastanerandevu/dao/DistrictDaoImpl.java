package com.hastanerandevu.dao;

import com.hastanerandevu.model.DistrictModel;
import com.hastanerandevu.model.HospitalModel;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class DistrictDaoImpl extends BaseDaoImpl<DistrictModel> {

  public List<String> getHospitalByDistrict(DistrictModel districtModel) {
    Query query1 = getEntitymanager().createQuery("SELECT e FROM DistrictModel e WHERE e.districtName = :DISTRICT_NAME").setParameter("DISTRICT_NAME", districtModel.getDistrictName());

    districtModel = (DistrictModel) query1.getSingleResult();

    Query query = getEntitymanager().createQuery("SELECT e.hospitalName, e.hospitalType FROM HospitalModel e WHERE e.districtModel = :districtModel").setParameter("districtModel", districtModel);

    List<HospitalModel> list = query.getResultList();
    List<String> result = new ArrayList<>(list.size());

    for(Object aList : list) {
      Object[] obj = (Object[]) aList;

      String name = String.valueOf(obj[0]);
      String type = String.valueOf(obj[1]);

      result.add(name + " - " + type);
    }

    return result;
  }
}
