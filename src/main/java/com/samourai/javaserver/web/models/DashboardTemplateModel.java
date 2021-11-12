package com.samourai.javaserver.web.models;

import org.springframework.ui.Model;

public class DashboardTemplateModel {
  public String pageTitle;
  public String logoTitle;
  public String currentPage;
  public long now;

  public DashboardTemplateModel(String pageTitle, String logoTitle, String currentPage) {
    this.pageTitle = pageTitle;
    this.logoTitle = logoTitle;
    this.currentPage = currentPage;
    this.now = System.currentTimeMillis();
  }

  public void apply(Model model) {
    model.addAttribute("dashboardModel", this);
  }
}
