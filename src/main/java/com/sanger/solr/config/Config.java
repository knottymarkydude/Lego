/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * Get the properties from the application.yml file in the config directory with
 * the prefix of server
 *
 * @author mw8
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "environments")
public class Config {

    private final List<String> servers = new ArrayList<>();
    private final List<String> collections = new ArrayList<>();
    private String test;

    public List<String> getCollections() {
        return this.collections;
    }

    public List<String> getServers() {
        return servers;
    }

}
