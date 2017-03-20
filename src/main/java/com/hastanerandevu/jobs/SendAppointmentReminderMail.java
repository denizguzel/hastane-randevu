package com.hastanerandevu.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by Okan on 20.3.2017.
 */
public class SendAppointmentReminderMail implements Job {
  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    //System.out.println("HATIRLATMA MAILI GONDER");
  }
}
