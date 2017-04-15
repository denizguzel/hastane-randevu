package com.hastanerandevu.utility;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/recovery/forgot")
public class AuthorizationFilterPassword implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    try {
      HttpServletRequest request = (HttpServletRequest) servletRequest;
      HttpServletResponse response = (HttpServletResponse) servletResponse;

      String indexURL = request.getContextPath() + "/";
      boolean passReset = request.getParameter("q") != null;

      if(passReset) {
        filterChain.doFilter(request, response);
      } else {
        response.sendRedirect(indexURL);
      }
    } catch(Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Override
  public void destroy() {

  }
}
