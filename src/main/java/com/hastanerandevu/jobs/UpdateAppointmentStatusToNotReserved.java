package com.hastanerandevu.jobs;

import com.hastanerandevu.enums.AppointmentStatusEnum;
import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.service.impl.AppointmentServiceImpl;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by ouzun on 5/1/2017.
 */
public class UpdateAppointmentStatusToNotReserved implements Job {

  private static final Logger LOG = Logger.getLogger(UpdateAppointmentStatusToNotReserved.class);

  AppointmentServiceImpl appointmentService = new AppointmentServiceImpl();

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {

    LOG.info("Started Update Appoinment Status To Not Reserved Job!");

    try{
      for (AppointmentModel appointmentModel : appointmentService.getAllSuspendedAppointments()){
        appointmentModel.setExpirationTimeForSuspend(null);
        appointmentModel.setAppointmentStatus(AppointmentStatusEnum.NOT_RESERVED);
        appointmentModel.setPatient(null);

        appointmentService.update(appointmentModel);
      }
    }
    catch(Exception e){
      LOG.error("Finished Update Appoinment Status To Not Reserved Job With Failure! : "+e.getMessage());
    }

    LOG.info("Finished Update Appoinment Status To NotReserved Job With Success!");

  }
}
