package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.enums.AppointmentStatusEnum;
import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.InspectionPlaceModel;

import javax.persistence.Query;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AppointmentDaoImpl extends BaseDaoImpl<AppointmentModel> {
  public List<AppointmentModel> getAllAppointmentsByInspectionPlace(InspectionPlaceModel inspectionPlaceModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM AppointmentModel e WHERE " + "e.inspectionPlace = :INSPECTION_PLACE AND " + "e.appointmentDate > :date ORDER BY e.appointmentDate");

    query.setParameter("INSPECTION_PLACE", inspectionPlaceModel);
    query.setParameter("date", new Date());

    return query.getResultList();
  }

  public List<AppointmentModel> getAllCompletableAppointments() {

    Calendar date = Calendar.getInstance();
    long t = date.getTimeInMillis();

    Query query = getEntitymanager().createQuery("SELECT e FROM AppointmentModel e WHERE e.appointmentDate < :date");

    query.setParameter("date", new Date(t - (ProjectConstants.APPOINTMENT_COMPLETION_TIME * ProjectConstants.ONE_MINUTE_IN_MILLIS)));

    return query.getResultList();
  }

  public List<AppointmentModel> getAllSuspendedAppointments() {
    Query query = getEntitymanager().createQuery("SELECT e FROM AppointmentModel e WHERE e.appointmentStatus = :APPOINTMENT_STATUS AND e.expirationTimeForSuspend < :date");
    query.setParameter("APPOINTMENT_STATUS", AppointmentStatusEnum.SUSPENDED);
    query.setParameter("date", new Date());

    return query.getResultList();
  }

}
