package com.hastanerandevu.dao.impl;

import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.InspectionPlaceModel;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Okan on 15.4.2017.
 */
public class InspectionPlaceDaoImpl extends BaseDaoImpl<InspectionPlaceModel> {
  public List<AppointmentModel> getAllAppointmentsByInspectionPlace(InspectionPlaceModel inspectionPlaceModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM AppointmentModel e WHERE " + "e.inspectionPlace = :INSPECTION_PLACE AND " + "e.appointmentDate > :date ORDER BY e.appointmentDate");

    query.setParameter("INSPECTION_PLACE", inspectionPlaceModel);
    query.setParameter("date", new Date());

    return query.getResultList();
  }
}