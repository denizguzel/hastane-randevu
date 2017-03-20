package com.hastanerandevu.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class UpdateAppointmentStatus implements Job {
  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    System.out.println("RANDEVU BILGISINI GUNCELLE");
  }
}
