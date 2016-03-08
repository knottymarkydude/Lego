/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.service;

import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mw8
 */
public class SearchServiceTest {
    
    Logger logger = LoggerFactory.getLogger(getClass());
    
    private static final String WT = "json";
    private static final String QT = "/tika2";
    private static final String JSONNL = "map";
    private static final String FACETMINCOUNT = "1";
    private String QUERY = "CGP";
    private static final String STARTDOC = "0";
    private static final String ROWS = "10";
    
    @Autowired
    SearchService searchService;
    
    ModifiableSolrParams solrParams = null;
    
    public SearchServiceTest() {
    }
    
    @Before
    public void setUp() {
        solrParams = new ModifiableSolrParams();
        solrParams.set("q", QUERY);
        solrParams.set("rows", ROWS);
        solrParams.set("wt", WT);
        solrParams.set("start", STARTDOC);
        solrParams.set("qt", QT);
        solrParams.set("json.nl", JSONNL);
        
    }

    /**
     * Test of getSearchResponse method, of class SearchService.
     */
    @Test
    public void testGetSearchResponse() {
        logger.info("getSearchResponse");
        QueryResponse expResult = null;
        QueryResponse result = null;
        
        try {
            result = searchService.getSearchResponse(solrParams);
        } catch (Exception ex) {
            logger.error("Exception: " + ex);
        }
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
