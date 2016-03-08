/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.service;

import com.sanger.solr.config.Config;
import java.io.IOException;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.search.solr.connect.SolrCloudConnect;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mw8
 */
@Component
public class SearchService {

    org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public SearchService() {
    }
    
    @Autowired
    Config config;

    public QueryResponse getSearchResponse(ModifiableSolrParams solrParams) {
        QueryResponse response = null;
        
        SolrCloudConnect solrConnect = new SolrCloudConnect("lego");

        try {
            response = solrConnect.query(solrParams);

        } catch (SolrServerException | IOException ex) {
            logger.error("Exception" + ex);
        }
        return response;
    }

}
