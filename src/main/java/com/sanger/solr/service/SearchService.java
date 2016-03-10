/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.service;

import java.io.IOException;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SolrPingResponse;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.search.solr.connect.SolrCloudConnect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * Service that connects to the Solr Instance and generates the required response.
 * 
 * @author mw8
 */
@Service
public class SearchService {

    Logger logger = LoggerFactory.getLogger(getClass());

    private SolrCloudConnect solrConnect;

    public SearchService() {
    }
    
    public SearchService(String collection) {
        solrConnect = new SolrCloudConnect(collection);
    }
    
    /**
     * 
     * @param solrParams
     * @return QueryResponse
     */
    public QueryResponse getSearchResponse(ModifiableSolrParams solrParams) {
        QueryResponse response = null;
        
        try {
            response = solrConnect.query(solrParams);

        } catch (SolrServerException | IOException ex) {
            logger.error("Exception" + ex);
        }
        return response;
    }
    
    /**
     * 
     * @return SolrPingResponse
     */
    public SolrPingResponse pingServer() {
        SolrPingResponse response = null;
        
        try {
            response = solrConnect.pingServerDetails();
            logger.info("Ping Response: " + response.toString());

        } catch (SolrServerException | IOException ex) {
            logger.error("Exception" + ex);
        }
        return response;
    }

}
