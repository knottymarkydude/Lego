/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.config;

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
@SpringApplicationConfiguration(classes = SolrConfig.class)
public class SolrConfigTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SolrConfig solrConfig;

    public SolrConfigTest() {
    }

    /**
     * Test of getCollection method, of class SolrConfig.
     */
    @Test
    public void testGetCollection() {
        logger.info("getCollection");
        String expResult = null;
        String result = solrConfig.getCollection();
        assertEquals(expResult, result);
    }

}
