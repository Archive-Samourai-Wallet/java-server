package com.samourai.javaserver.web.models;

import java.util.Map;
import org.springframework.ui.Model;

public class ConfigTemplateModel extends DashboardTemplateModel {
  public Map<String, String> configInfo;

  public ConfigTemplateModel(String pageTitle, String logoTitle, Map<String, String> configInfo) {
    super(pageTitle, logoTitle, "config");
    this.configInfo = configInfo;
  }

  public void apply(Model model) {
    super.apply(model);
    model.addAttribute("configModel", this);
  }
}
