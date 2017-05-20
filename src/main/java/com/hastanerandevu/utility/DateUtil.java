package com.hastanerandevu.utility;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ouzun on 5/20/2017.
 */
public class DateUtil {
  static Calendar calendar;
  public static Date getEndOfDay(){
    calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 999);

    return calendar.getTime();
  }
}
