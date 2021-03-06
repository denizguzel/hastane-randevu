package com.hastanerandevu.utility;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
  private static Calendar calendar = Calendar.getInstance();

  public static Date getEndOfDay() {
    calendar.setTime(new Date());
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 999);

    return calendar.getTime();
  }

  public static Date getEndOfDay(Date date) {
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 999);

    return calendar.getTime();
  }

  public static Date getStartOfDay(Date date) {
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);

    return calendar.getTime();
  }

  public static int calculateAge(Date date){
    LocalDate birthDay = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate now = LocalDate.now();

    return Period.between(birthDay,now).getYears();
  }
}
