package com.hastanerandevu.dao.impl;

import com.hastanerandevu.converter.Encryptor;
import com.hastanerandevu.enums.AppointmentStatusEnum;
import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.DoctorModel;
import com.hastanerandevu.utility.DateUtil;

import javax.persistence.Query;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DoctorDaoImpl extends BaseDaoImpl<DoctorModel> {
  public DoctorModel loginDoctor(DoctorModel doctorModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM DoctorModel e WHERE e.recordNumber = :RECORD_NUMBER AND e.password = :PASSWORD");
    query.setParameter("RECORD_NUMBER", doctorModel.getRecordNumber());
    query.setParameter("PASSWORD", Encryptor.encrypt(doctorModel.getPassword()));

    if(query.getResultList().size() > 0) {
      return (DoctorModel) query.getResultList().get(0);
    } else {
      return null;
    }
  }

  public List<AppointmentModel> getAppointmentHistoryByDoctor(DoctorModel doctorModel) {

    List<AppointmentStatusEnum> appointmentStatusEnums = Arrays.asList(AppointmentStatusEnum.COMPLETED, AppointmentStatusEnum.RESERVED);

    Query query = getEntitymanager().createQuery("SELECT e FROM AppointmentModel e WHERE e.inspectionPlace.doctor = :DOCTOR AND e.appointmentStatus IN :APPOINTMENT_STATUS AND e.patient IS NOT NULL ORDER BY e.appointmentDate DESC");

    query.setParameter("DOCTOR", doctorModel);
    query.setParameter("APPOINTMENT_STATUS", appointmentStatusEnums);

    return query.getResultList();
  }

  public long remainingAppointment(DoctorModel doctorModel) {

    Query query = getEntitymanager().createQuery("SELECT COUNT (e) FROM AppointmentModel e WHERE e.inspectionPlace.doctor = :DOCTOR AND e.appointmentStatus = :APPOINTMENT_STATUS AND e.appointmentDate BETWEEN :NOW AND :END_OF_DAY");

    query.setParameter("DOCTOR", doctorModel);
    query.setParameter("APPOINTMENT_STATUS", AppointmentStatusEnum.RESERVED);
    query.setParameter("NOW", new Date());
    query.setParameter("END_OF_DAY", DateUtil.getEndOfDay());

    return (long) query.getResultList().get(0);
  }

  public List<AppointmentModel> getAppointmentsNote(DoctorModel doctorModel) {
    Query query = getEntitymanager().createQuery("SELECT ap FROM AppointmentModel ap " + "WHERE ap.inspectionPlace.doctor = :DOCTOR AND ap.appointmentStatus = :APPOINTMENT_STATUS AND ap.messageToDoctor IS NOT NULL ORDER BY ap.creationTime DESC");

    query.setParameter("DOCTOR", doctorModel);
    query.setParameter("APPOINTMENT_STATUS", AppointmentStatusEnum.RESERVED);

    return query.getResultList();
  }
}
