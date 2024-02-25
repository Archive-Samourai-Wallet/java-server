package com.samourai.javaserver.config;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.util.StringUtils;

public abstract class ServerConfig {
  private String name;
  private String metricsLokiUrl;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMetricsLokiUrl() {
    return metricsLokiUrl;
  }

  public void setMetricsLokiUrl(String metricsLokiUrl) {
    this.metricsLokiUrl = metricsLokiUrl;
  }

  public void validate() throws Exception {
    if (StringUtils.isEmpty(name)) {
      throw new Exception("server.name is empty");
    }
  }

  public Map<String, String> getConfigInfo() {
    Map<String, String> configInfo = new LinkedHashMap<>();
    configInfo.put("name", name);
    configInfo.put("metricsLokiUrl", metricsLokiUrl);
    return configInfo;
  }
}
