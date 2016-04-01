/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.service;

import com.sanger.solr.model.search.QueryForm;
import com.sanger.solr.Application;
import com.sanger.solr.config.Config;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SolrPingResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author mw8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SearchServiceTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Config config;

    SearchService searchService;

    private static final String WT = "json";
    private static final String QT = "/tika";
    private static final String JSONNL = "map";
    private static final String FACETMINCOUNT = "1";
    private String QUERY = "zibzob";
    private static final Integer STARTDOC = 0;
    private static final Integer ROWS = 10;
    private String collection;

    QueryForm queryForm;

    public SearchServiceTest() {
    }

    @Before
    public void setUp() {
        queryForm = new QueryForm();
        queryForm.setQ(QUERY);
        queryForm.setRows(ROWS);
        queryForm.setStart(STARTDOC);

        collection = config.getCollections().get(0);

        searchService = new SearchService(collection);

    }

    /**
     * Test of getSearchResponse method, of class SearchService.
     */
    @Test
    public void testGetSearchResponse() {
        logger.info("getSearchResponse");
        int expResult = 0;
        SolrDocumentList result = new SolrDocumentList();

        try {
            result = searchService.getResults(queryForm);
            logger.info("Results: " + result.toString());
        } catch (Exception ex) {
            logger.error("Exception: " + ex);
        }

        assertEquals(expResult, result.getNumFound());
    }

    /**
     * Test of getSearchResponse method, of class SearchService.
     */
    @Test
    public void testSolrPingResponse() {
        logger.info("testSolrPingResponse");

        SolrPingResponse result = new SolrPingResponse();

        try {
            result = searchService.pingServer();
        } catch (Exception ex) {
            logger.error("Exception: " + ex);
        }
        assertEquals(0, result.getStatus());
    }

}
