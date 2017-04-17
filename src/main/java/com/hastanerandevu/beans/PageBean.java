package com.hastanerandevu.beans;

import com.hastanerandevu.model.PageModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "pagebean")
@SessionScoped
public class PageBean {

  private List<PageModel> pageList = new ArrayList<>();

  public PageBean() {
    pageList.add(new PageModel("/view/dashboard.xhtml", "Ana Sayfa", "fa fa-home"));
    pageList.add(new PageModel("/view/appointment.xhtml", "Randevu Al", "fa fa-book"));
  }

  public List<PageModel> getPageList() {
    return pageList;
  }

  public String getViewId() {
    return FacesContext.getCurrentInstance().getViewRoot().getViewId();
  }
}
