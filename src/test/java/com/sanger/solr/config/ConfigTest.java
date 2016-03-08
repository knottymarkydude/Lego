/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.config;

import com.sanger.solr.Application;
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
public class ConfigTest {
    
    Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    Config config;

    /**
     * Test of getServers method, of class Config.
     */
    @Test
    public void testGetServer() {
        logger.info("testGetServer");
        String expResult = "http://web-solrcloudspardev-01.internal.sanger.ac.uk:8080/";
        String result = config.getServers().get(0);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of testGetCollections method, of class Config.
     */
    @Test
    public void testGetCollections() {
        logger.info("testGetCollections");
        String expResult = "lego";
        String result = config.getCollections().get(0);
        assertEquals(expResult, result);
    }
  
}
