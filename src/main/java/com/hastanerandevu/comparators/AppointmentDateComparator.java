package com.hastanerandevu.comparators;

import com.hastanerandevu.model.AppointmentModel;

import java.util.Comparator;

/**
 * Created by ouzun on 2.06.2017.
 */
public class AppointmentDateComparator implements Comparator<AppointmentModel> {
  public int compare(AppointmentModel o1, AppointmentModel o2) {
    return o1.getAppointmentDate().compareTo(o2.getAppointmentDate());
  }
}
