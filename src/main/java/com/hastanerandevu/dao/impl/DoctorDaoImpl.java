package com.hastanerandevu.dao.impl;

import com.hastanerandevu.converter.Encryptor;
import com.hastanerandevu.enums.AppointmentStatusEnum;
import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.DoctorModel;

import javax.persistence.Query;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DoctorDaoImpl extends BaseDaoImpl<DoctorModel> {
  public DoctorModel loginDoctor(DoctorModel doctorModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM DoctorModel e WHERE e.recordNumber = :RECORD_NUMBER AND e.password = :PASSWORD");
    query.setParameter("RECORD_NUMBER", doctorModel.getRecordNumber());
    query.setParameter("PASSWORD", Encryptor.encryptPassword(doctorModel.getPassword()));

    if(query.getResultList().size() > 0) {
      return (DoctorModel) query.getResultList().get(0);
    } else {
      return null;
    }
  }

  public List<AppointmentModel> getAppointmentHistoryByDoctor(DoctorModel doctorModel) {

    List<AppointmentStatusEnum> appointmentStatusEnums = Arrays.asList(AppointmentStatusEnum.COMPLETED, AppointmentStatusEnum.RESERVED);

    Query query = getEntitymanager().createQuery("SELECT e FROM AppointmentModel e WHERE e.inspectionPlace.doctor = :DOCTOR AND e.appointmentStatus IN :APPOINTMENT_STATUS ORDER BY e.appointmentDate DESC");

    query.setParameter("DOCTOR", doctorModel);
    query.setParameter("APPOINTMENT_STATUS", appointmentStatusEnums);

    return query.getResultList();
  }

  public long remainingAppointment(DoctorModel doctorModel, Date date) {
    Query query = getEntitymanager().createQuery("SELECT COUNT (id) FROM AppointmentModel e WHERE e.inspectionPlace.doctor = :doctor AND e.appointmentStatus = :status AND e.appointmentDate <= :date");

    query.setParameter("doctor", doctorModel);
    query.setParameter("status", AppointmentStatusEnum.RESERVED);
    query.setParameter("date", date);

    return (long) query.getResultList().get(0);
  }
}
