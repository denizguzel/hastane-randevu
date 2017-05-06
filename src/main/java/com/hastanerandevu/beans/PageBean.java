package com.hastanerandevu.beans;

import com.hastanerandevu.model.PageModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "pagebean")
@ViewScoped
public class PageBean {

  private List<PageModel> pageList = new ArrayList<>();

  public PageBean() {
    pageList.add(new PageModel("/view/dashboard.xhtml", "Ana Sayfa", "fa fa-home fa-fw"));
    pageList.add(new PageModel("/view/take-appointment.xhtml", "Randevu Al", "fa fa-book fa-fw"));
    pageList.add(new PageModel("/view/appointments.xhtml", "Randevularım", "fa fa-calendar fa-fw"));
    pageList.add(new PageModel("/view/alergy.xhtml", "Alerjilerim", "fa fa-thermometer-2 fa-fw"));
    pageList.add(new PageModel("/view/vaccine.xhtml", "Aşı Takvimi", "fa fa-calendar-check-o fa-fw"));
  }

  public List<PageModel> getPageList() {
    return pageList;
  }

  public String getViewId() {
    return FacesContext.getCurrentInstance().getViewRoot().getViewId();
  }
}
