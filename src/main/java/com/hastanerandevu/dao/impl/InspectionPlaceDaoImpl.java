package com.hastanerandevu.dao.impl;

import com.hastanerandevu.enums.AppointmentStatusEnum;
import com.hastanerandevu.model.InspectionPlaceModel;
import com.hastanerandevu.utility.DateUtil;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class InspectionPlaceDaoImpl extends BaseDaoImpl<InspectionPlaceModel> {

  public List<InspectionPlaceModel> getAppointments(InspectionPlaceModel inspectionPlaceModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM InspectionPlaceModel e WHERE e.pk = :inspectionPlace");

    query.setParameter("inspectionPlace", inspectionPlaceModel.getPk());

    return query.getResultList();
  }

  public List<InspectionPlaceModel> getAppointmentHeaderByInspectionPlace(InspectionPlaceModel inspectionPlaceModel, Date startDate, Date endDate) {
    Query query = getEntitymanager().createQuery("SELECT DISTINCT(ip) FROM InspectionPlaceModel ip INNER JOIN ip.appointmentModels ap WHERE ip = :INSPECTION_PLACE AND ap.appointmentStatus = :APPOINTMENT_STATUS AND ap.appointmentDate BETWEEN :START_DATE AND :END_DATE");

    query.setParameter("INSPECTION_PLACE", inspectionPlaceModel);
    query.setParameter("APPOINTMENT_STATUS", AppointmentStatusEnum.NOT_RESERVED);
    query.setParameter("START_DATE", startDate);
    query.setParameter("END_DATE", endDate);

    return query.getResultList();
  }

  public List<InspectionPlaceModel> getAppointmentHeaderByInspectionPlace(InspectionPlaceModel inspectionPlaceModel, Date startDate) {
    Query query = getEntitymanager().createQuery("SELECT DISTINCT(ip) FROM InspectionPlaceModel ip INNER JOIN ip.appointmentModels ap WHERE ip = :INSPECTION_PLACE AND ap.appointmentStatus = :APPOINTMENT_STATUS AND ap.appointmentDate > :START_DATE");

    query.setParameter("INSPECTION_PLACE", inspectionPlaceModel);
    query.setParameter("APPOINTMENT_STATUS", AppointmentStatusEnum.NOT_RESERVED);
    query.setParameter("START_DATE", startDate);

    return query.getResultList();
  }

  public List<InspectionPlaceModel> getAppointmentHeaderByInspectionPlace(InspectionPlaceModel inspectionPlaceModel) {
    Query query = getEntitymanager().createQuery("SELECT DISTINCT(ip) FROM InspectionPlaceModel ip INNER JOIN ip.appointmentModels ap WHERE ip = :INSPECTION_PLACE AND ap.appointmentStatus = :APPOINTMENT_STATUS AND ap.appointmentDate > :START_DATE");

    query.setParameter("INSPECTION_PLACE", inspectionPlaceModel);
    query.setParameter("APPOINTMENT_STATUS", AppointmentStatusEnum.NOT_RESERVED);
    query.setParameter("START_DATE", DateUtil.getEndOfDay());

    return query.getResultList();
  }
}
