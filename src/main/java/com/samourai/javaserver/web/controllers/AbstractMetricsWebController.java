package com.samourai.javaserver.web.controllers;

import com.samourai.javaserver.web.models.MetricsTemplateModel;
import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AbstractMetricsWebController {
  private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  public String metrics(Model model, MetricsTemplateModel templateModel) {
    templateModel.apply(model);
    return "decorators/metrics.html";
  }
}
