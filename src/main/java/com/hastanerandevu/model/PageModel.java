package com.hastanerandevu.model;

public class PageModel {
  private String link;
  private String linkName;
  private String iconName;

  public PageModel(String link, String linkName, String iconName) {
    this.link = link;
    this.linkName = linkName;
    this.iconName = iconName;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getLinkName() {
    return linkName;
  }

  public void setLinkName(String linkName) {
    this.linkName = linkName;
  }

  public String getIconName() {
    return iconName;
  }

  public void setIconName(String iconName) {
    this.iconName = iconName;
  }
}
