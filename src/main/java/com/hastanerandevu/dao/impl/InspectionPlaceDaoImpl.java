package com.hastanerandevu.dao.impl;

import com.hastanerandevu.model.InspectionPlaceModel;

import javax.persistence.Query;
import java.util.List;

public class InspectionPlaceDaoImpl extends BaseDaoImpl<InspectionPlaceModel> {

  public List<InspectionPlaceModel> getAppointments(InspectionPlaceModel inspectionPlaceModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM InspectionPlaceModel e WHERE e.pk = :inspectionPlace");

    query.setParameter("inspectionPlace", inspectionPlaceModel.getPk());

    return query.getResultList();
  }
}
