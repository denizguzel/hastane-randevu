package com.hastanerandevu.beans;

import com.hastanerandevu.model.PageModel;
import com.hastanerandevu.utility.SessionUtils;

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
    if(SessionUtils.getSession().getAttribute("userType").equals("patient")) {
      pageList.add(new PageModel("/view/take-appointment.xhtml", "Randevu Al", "fa fa-book fa-fw"));
      pageList.add(new PageModel("/view/appointments.xhtml", "Randevularım", "fa fa-calendar fa-fw"));
      pageList.add(new PageModel("/view/alergy.xhtml", "Alerjilerim", "fa fa-bug fa-fw"));
      pageList.add(new PageModel("/view/disease.xhtml", "Hastalıklarım", "fa fa-bed fa-fw"));
      pageList.add(new PageModel("/view/assay.xhtml", "Tahlillerim", "fa fa-flask fa-fw"));
      pageList.add(new PageModel("/view/vaccine.xhtml", "Aşı Takvimi", "fa fa-eyedropper fa-fw"));
    } else if(SessionUtils.getSession().getAttribute("userType").equals("doctor")) {
      pageList.add(new PageModel("/view/appointments.xhtml", "Hasta Randevularım", "fa fa-calendar fa-fw"));
      pageList.add(new PageModel("/view/notes.xhtml", "Hasta Notları", "fa fa-sticky-note-o fa-fw"));
      pageList.add(new PageModel("/view/comments.xhtml", "Hasta Yorumları", "fa fa-comment-o fa-fw"));
    }
  }

  public List<PageModel> getPageList() {
    return pageList;
  }

  public String getViewId() {
    return FacesContext.getCurrentInstance().getViewRoot().getViewId();
  }
}
