package com.hastanerandevu.beans;

import com.hastanerandevu.model.PageModel;
import com.hastanerandevu.utility.SessionUtils;
import com.hastanerandevu.utility.UTF8Control;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@ManagedBean(name = "pagebean")
@ViewScoped
public class PageBean {
  private List<PageModel> pageList;
  private ResourceBundle bundle = ResourceBundle.getBundle("com.hastanerandevu.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale(), new UTF8Control());

  @PostConstruct
  public void init() {
    pageList = new ArrayList<>();

    pageList.add(new PageModel("/view/dashboard.xhtml", bundle.getString("sidebar.main"), "fa fa-home fa-fw"));

    // "string".equals() to prevent NullPointerException
    if("patient".equals(SessionUtils.getSession().getAttribute("userType"))) {
      pageList.add(new PageModel("/view/take-appointment.xhtml", bundle.getString("sidebar.takeAppointment"), "fa fa-book fa-fw"));
      pageList.add(new PageModel("/view/appointments.xhtml", bundle.getString("sidebar.appoinments"), "fa fa-calendar fa-fw"));
      pageList.add(new PageModel("/view/alergy.xhtml", bundle.getString("sidebar.alergy"), "fa fa-bug fa-fw"));
      pageList.add(new PageModel("/view/disease.xhtml", bundle.getString("sidebar.disease"), "fa fa-bed fa-fw"));
      pageList.add(new PageModel("/view/assay.xhtml", bundle.getString("sidebar.assay"), "fa fa-flask fa-fw"));
      pageList.add(new PageModel("/view/vaccine.xhtml", bundle.getString("sidebar.vaccine"), "fa fa-eyedropper fa-fw"));
    } else if("doctor".equals(SessionUtils.getSession().getAttribute("userType"))) {
      pageList.add(new PageModel("/view/appointments.xhtml", bundle.getString("sidebar.doctorAppointments"), "fa fa-calendar fa-fw"));
      pageList.add(new PageModel("/view/notes.xhtml", bundle.getString("sidebar.doctorNotes"), "fa fa-sticky-note-o fa-fw"));
      pageList.add(new PageModel("/view/comments.xhtml", bundle.getString("sidebar.doctorComments"), "fa fa-comment-o fa-fw"));
    } else if("admin".equals(SessionUtils.getSession().getAttribute("userType"))) {
      pageList.add(new PageModel("/view/survey.xhtml", bundle.getString("page.title.survey"), "fa fa-list-ol fa-fw"));
      pageList.add(new PageModel("/view/comments.xhtml", bundle.getString("sidebar.doctorComments"), "fa fa-comment-o fa-fw"));
      pageList.add(new PageModel("/view/faq.xhtml", bundle.getString("sidebar.faq"), "fa fa-question fa-fw"));
    }
  }

  public List<PageModel> getPageList() {
    return pageList;
  }

  public String getViewId() {
    return FacesContext.getCurrentInstance().getViewRoot().getViewId();
  }
}
