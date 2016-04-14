/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * Utility to perform various Maths needed
 *
 * @author mw8
 */
@Component
public class MathsFunctions {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Round up a number
     *
     * @param totalNum
     * @param numOfRows
     * @return int
     */
    public int getRoundedUpNum(long totalNum, long numOfRows) {
        int a = (int) Math.ceil(totalNum / numOfRows);
        return a;
    }

    /**
     *
     * @return startDoc value
     */
    public String getPageNumStart(int pageNum, double numOfRows) {
        int startDoc = (int) ((pageNum * numOfRows) - numOfRows);
        String s = Integer.toString(startDoc);
        return s;
    }

    /**
     * 
     * @param pageNum
     * @param numOfRows
     * @return 
     */
    public String getPageNumStart(int pageNum, int numOfRows) {
        int startDoc = ((pageNum * numOfRows) - numOfRows);
        String s = Integer.toString(startDoc);
        return s;
    }
}
