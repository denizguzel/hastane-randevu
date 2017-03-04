package com.hastanerandevu.utility;

import javax.faces.application.ResourceHandler;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter (filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthorizationFilter implements Filter {

  private static final String AJAX_REDIRECT_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<partial-response><redirect url=\"%s\"></redirect></partial-response>";

  public void init (FilterConfig filterConfig) throws ServletException {

  }

  public void doFilter (ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    try {
      HttpServletRequest  request  = (HttpServletRequest) servletRequest;
      HttpServletResponse response = (HttpServletResponse) servletResponse;
      HttpSession         session  = request.getSession(false);

      String loginURL = request.getContextPath() + "/";

      boolean loggedIn        = (session != null) && (session.getAttribute("firstName") != null);
      boolean loginRequest    = request.getRequestURI().equals(loginURL);
      boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
      boolean ajaxRequest     = "partial/ajax".equals(request.getHeader("Faces-Request"));

      if ( loggedIn || loginRequest || resourceRequest ) {
        if ( !resourceRequest ) { // Prevent browser from caching restricted resources.
          response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
          response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
          response.setDateHeader("Expires", 0); // Proxies.
        }
        filterChain.doFilter(request, response);
      } else if ( ajaxRequest ) {
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().printf(AJAX_REDIRECT_XML, loginURL); // So, return special XML response instructing JSF ajax to send a redirect.
      } else {
        response.sendRedirect(loginURL); // So, just perform standard synchronous redirect.
      }
    } catch ( Exception ex ) {
      System.out.println(ex.getMessage());
    }
  }

  public void destroy () {

  }
}
