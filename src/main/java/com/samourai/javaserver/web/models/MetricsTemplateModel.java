package com.samourai.javaserver.web.models;

import org.springframework.ui.Model;

public class MetricsTemplateModel extends DashboardTemplateModel {
  public String metricsUrl;

  public MetricsTemplateModel(
      String pageTitle, String logoTitle, String currentPage, String metricsUrl) {
    super(pageTitle, logoTitle, currentPage);
    this.metricsUrl = metricsUrl;
  }

  public MetricsTemplateModel(String pageTitle, String logoTitle, String metricsUrl) {
    this(pageTitle, logoTitle, "metrics", metricsUrl);
  }

  public void apply(Model model) {
    super.apply(model);
    model.addAttribute("metricsModel", this);
  }
}
