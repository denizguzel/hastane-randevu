package com.hastanerandevu.jobs;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ScheduleApp implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    // First job register
    JobKey sendMailKey = new JobKey("SendAppointmentReminderMailJob", "AGroup");
    JobDetail sendMail = JobBuilder.newJob(SendAppointmentReminderMail.class).withIdentity(sendMailKey).build();

    // Second job register
    JobKey updateStatusKey = new JobKey("UpdateAppointmentStatusJob", "AGroup");
    JobDetail updateStatus = JobBuilder.newJob(UpdateAppointmentStatus.class).withIdentity(updateStatusKey).build();

    // First job trigger
    Trigger sendMailTrigger = TriggerBuilder.newTrigger().withIdentity("SendAppointmentReminderMailTrigger", "AGroup").withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();

    // Second job trigger
    Trigger updateStatusTrigger = TriggerBuilder.newTrigger().withIdentity("UpdateAppointmentStatusTrigger", "AGroup").withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();

    try {
      Scheduler scheduler = new StdSchedulerFactory().getScheduler();
      scheduler.start();
      scheduler.scheduleJob(sendMail, sendMailTrigger);
      scheduler.scheduleJob(updateStatus, updateStatusTrigger);
    } catch(SchedulerException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {

  }
}
