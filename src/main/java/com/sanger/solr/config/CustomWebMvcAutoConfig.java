/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.config;

/**
 *
 * Configuration extension for external resource handler
 * 
 * @author mw8
 */

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class CustomWebMvcAutoConfig extends
                    WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    String myExternalFilePath = "file:/www/data/lego/files/live/";

    registry.addResourceHandler("/docs/**").addResourceLocations(myExternalFilePath);

    super.addResourceHandlers(registry);
  }

}