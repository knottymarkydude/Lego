/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mw8
 */
public class DefaultPropertiesTest {
    
    org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
    
    public DefaultPropertiesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPropValue method, of class DefaultProperties.
     */
    @Test
    public void testGetPropValue() {
        logger.info("testGetPropValue");
        String propKey = "docRoot";
        DefaultProperties instance = new DefaultProperties("app");
        String expResult = "/www/data/lego/files/live/";
        String result = instance.getPropValue(propKey);
        logger.info("Result: "+result);
        assertEquals(expResult, result);
    }
    
}
