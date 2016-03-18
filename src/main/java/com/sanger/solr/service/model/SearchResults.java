/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.service.model;

import java.util.List;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.common.SolrDocumentList;

/**
 *
 * Search Response for Query. 
 * This is used to pull in all the details needed for the results page, and incorporates
 * the highlighted fields into the results.
 * 
 * @author mw8
 */
public class SearchResults {
    private long maxNumFound;
    private long startNum;
    private Float maxScore;
    //private List<ResultDocument> resultsList;
    SolrDocumentList solrDocumentList;
    private List<FacetField> facetFields;
    private int numOfPages;
    private int numOfRows;
    private String resultCounts;
    private String query;

    public long getMaxNumFound() {
        return maxNumFound;
    }

    public void setMaxNumFound(long maxNumFound) {
        this.maxNumFound = maxNumFound;
    }

    public long getStartNum() {
        return startNum;
    }

    public void setStartNum(long startNum) {
        this.startNum = startNum;
    }

    public Float getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Float maxScore) {
        this.maxScore = maxScore;
    }

    public SolrDocumentList getSolrDocumentList() {
        return solrDocumentList;
    }

    public void setSolrDocumentList(SolrDocumentList solrDocumentList) {
        this.solrDocumentList = solrDocumentList;
    }

    public List<FacetField> getFacetFields() {
        return facetFields;
    }

    public void setFacetFields(List<FacetField> facetFields) {
        this.facetFields = facetFields;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public String getResultCounts() {
        return resultCounts;
    }

    public void setResultCounts(String resultCounts) {
        this.resultCounts = resultCounts;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "SearchResults{" + "maxNumFound=" + maxNumFound + ", startNum=" + startNum + ", maxScore=" + maxScore + ", solrDocumentList=" + solrDocumentList + ", facetFields=" + facetFields + ", numOfPages=" + numOfPages + ", numOfRows=" + numOfRows + ", resultCounts=" + resultCounts + ", query=" + query + '}';
    }

    
}
