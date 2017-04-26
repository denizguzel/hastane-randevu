package com.hastanerandevu.constants;

public class ProjectConstants {
  public final static String persistenceUnitName = "Hibernate_JPA";

  public final static String PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

  public final static String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." + "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" + "(\\.[A-Za-z]{2,})$";

  public final static String CAPTCHA_SECRET_KEY = "6LcjxBcUAAAAAP-NHMzhsDDRAck1fDX8vs_ZzC_3";
  public final static String CAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s";

  public final static String localizationFilePath = "com.hastanerandevu.messages";

  public final static String SALT = "498#2D83B631%3800EBD!801600D*7E3CC13";

  public final static long ONE_MINUTE_IN_MILLIS = 60000;
}
