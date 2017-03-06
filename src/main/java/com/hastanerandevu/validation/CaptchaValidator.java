package com.hastanerandevu.validation;

import com.google.gson.Gson;
import com.hastanerandevu.constants.ProjectConstants;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CaptchaValidator {

  public static boolean validate (FacesContext context) throws IOException {
    HttpServletRequest request    = (HttpServletRequest) context.getExternalContext().getRequest();
    String             remoteAddr = request.getRemoteAddr();
    String             recap      = request.getParameter("g-recaptcha-response");
    URL                url;

    url = new URL(String.format(ProjectConstants.CAPTCHA_VERIFY_URL, ProjectConstants.CAPTCHA_SECRET_KEY, recap, remoteAddr));
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    String         line;
    StringBuilder  output = new StringBuilder();
    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    while ( (line = reader.readLine()) != null ) {
      output.append(line);
    }
    CaptchaResponse capRes = new Gson().fromJson(output.toString(), CaptchaResponse.class);
    return capRes.isSuccess();
  }
}
