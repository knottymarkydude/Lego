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

    public MathsFunctions() {
    }

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Round up a number
     *
     * @param totalNum
     * @param numOfRows
     * @return int
     */
    public int getRoundedUpNum(long totalNum, int numOfRows) {
        int a = (int) Math.ceil(totalNum / numOfRows) + 1;
        return a;
    }

    /**
     *
     * @param pageNum
     * @param numOfRows
     * @return
     */
    public int getPageNumStartInt(int pageNum, int numOfRows) {
        int startDoc = ((pageNum * numOfRows) - numOfRows);
        return startDoc;
    }
}
