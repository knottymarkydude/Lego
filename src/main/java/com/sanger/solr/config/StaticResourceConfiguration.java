/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * Get static files from particular location
 * extend the default static resource handlers
 * "classpath:/META-INF/resources/",
 * "classpath:/resources/",
 * "classpath:/static/",
 * "classpath:/public/",
 *
 * @author mw8
 */
@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class StaticResourceConfiguration extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String myExternalFilePath = "/www/data/lego/files/live/";

        registry.addResourceHandler("/docs/**").addResourceLocations(myExternalFilePath);

        super.addResourceHandlers(registry);
    }
}
