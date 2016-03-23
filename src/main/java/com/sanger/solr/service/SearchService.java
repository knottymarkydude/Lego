/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.service;

import com.sanger.model.search.QueryForm;
import com.sanger.solr.service.model.SearchResults;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SolrPingResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.search.solr.connect.SolrCloudConnect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * Service that connects to the Solr Instance and generates the required
 * response.
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
     * Search Results
     * 
     * @param queryForm
     * @return 
     */
    public SolrDocumentList getResults(QueryForm queryForm) {
        SearchResults searchResults = new SearchResults();

        ModifiableSolrParams solrParams = new ModifiableSolrParams();
        solrParams.set("q", queryForm.getQ());
        solrParams.set("start", queryForm.getStart());
        solrParams.set("rows", queryForm.getRows());
        //TODO Set in properties file
        solrParams.set("qt", "/tika");

        // Get Response from Solr
        QueryResponse response = this.getSearchResponse(solrParams);

        // SolrDocuments
        SolrDocumentList solrDocList = response.getResults();
        logger.info("SolrDocList:  " + solrDocList);
        
        // Number of Results
        long numFound = solrDocList.getNumFound();

        //This puts the Highlighted section into the SolrDocument
        solrDocList.stream().forEach((solrDoc) -> {
            String sid = null;
            if (solrDoc.getFieldValue("id") != null) {
                sid = solrDoc.getFieldValue("id").toString().trim();
            }

            // Get Highlights into SolrDocument
            StringBuilder highlights = new StringBuilder();
            if (response.getHighlighting() != null) {
                Map<String, List<String>> mp = response.getHighlighting()
                        .get(sid);
                // Get Map in Set interface to get key and value
                Set<Map.Entry<String, List<String>>> s = mp.entrySet();
                // Move next key and value of Map by iterator
                Iterator<Map.Entry<String, List<String>>> it = s.iterator();
                while (it.hasNext()) {

                    @SuppressWarnings("rawtypes")
                    Map.Entry m = it.next();
                    highlights.append(m.getValue().toString().trim());
                    highlights.append("...");
                }
            }

            solrDoc.addField("highlight", highlights);
            logger.debug(solrDoc.toString());
        });
        logger.debug("SolrDocList:  " + solrDocList);
 
        return solrDocList;
    }

    /**
     *
     * @param solrParams
     * @return QueryResponse
     */
    private QueryResponse getSearchResponse(ModifiableSolrParams solrParams) {
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
