/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author mw8
 */
@Configuration  //tells Spring to treat this as a configuration class and register it as a Bean
@EnableConfigurationProperties //  tells Spring to treat this class as a consumer of application.yml/properties values
@ConfigurationProperties(prefix = "solr") //tells Spring what section this class represents.
public class SolrConfig {
    private String collection;
    private String sport;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
    
    
}
