/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.utils;

import com.sanger.solr.ApplicationTest;
import org.junit.After;
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
@SpringApplicationConfiguration(classes = ApplicationTest.class)
public class MathsFunctionsTest {
    
    Logger logger = LoggerFactory.getLogger(getClass());
    
    private long totalNum;
    private int numOfRows;
    private int pageNum;
    
    @Autowired
    MathsFunctions mathsFunctions; 
    
    public MathsFunctionsTest() {
    }
    
    @Before
    public void setUp() {
        totalNum = 322 ;
        numOfRows = 10;
        pageNum = 5;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRoundedUpNum method, of class MathsFunctions.
     */
    @Test
    public void testGetRoundedUpNum() {
        logger.info("getRoundedUpNum");
        int result = mathsFunctions.getRoundedUpNum(totalNum, numOfRows);
        logger.info("Result: "+ result );
        int expResult = 33;
       
        assertEquals(expResult, result);
    }

    /**
     * Test of getPageNumStartInt method, of class MathsFunctions.
     */
    @Test
    public void testGetPageNumStartInt() {
        logger.info("testGetPageNumStartInt");
        
        int start = mathsFunctions.getPageNumStartInt(pageNum, numOfRows);
        logger.info("Result: "+ start );
        int expResult = 40;
        
        assertEquals(expResult, start);
    }
    
}
