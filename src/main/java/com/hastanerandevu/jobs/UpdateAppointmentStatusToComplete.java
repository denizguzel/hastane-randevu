package com.hastanerandevu.jobs;

import com.hastanerandevu.enums.AppointmentStatusEnum;
import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.service.impl.AppointmentServiceImpl;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class UpdateAppointmentStatusToComplete implements Job {

  private static final Logger LOG = Logger.getLogger(UpdateAppointmentStatusToComplete.class);

  AppointmentServiceImpl appointmentService = new AppointmentServiceImpl();

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    LOG.info("Started Update Appointment Status To COMPLETE Job !");

    try {
      for (AppointmentModel appointmentModel : appointmentService.getAllCompletableAppointments()) {
        if (appointmentModel.getAppointmentStatus() == AppointmentStatusEnum.SUSPENDED){
          appointmentModel.setPatient(null);
          appointmentModel.setExpirationTimeForSuspend(null);
        }
        appointmentModel.setAppointmentStatus(AppointmentStatusEnum.COMPLETED);
        appointmentService.update(appointmentModel);
      }
    } catch (Exception e) {
      LOG.error("Finished Update Appointment Status To COMPLETE Job With Failure : " + e.getMessage());
    }
    LOG.info("Finished Update Appointment Status To COMPLETE Job With Success!");
  }
}
