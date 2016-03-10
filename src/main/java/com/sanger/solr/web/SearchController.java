/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.web;

import com.sanger.model.search.QueryForm;
import com.sanger.solr.config.Config;
import com.sanger.solr.service.SearchService;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mw8
 */
@Controller
public class SearchController {
    
    Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private Config config;
    
    SearchService searchService;
    
    private String collection;
    private static final String QT = "/tika";

    public SearchController() {
        searchService = new SearchService("lego");
    }
    
    
    
    // 
    @ModelAttribute("queryFormBean")
    public QueryForm createQueryForm() {
        logger.debug("Creating Query Form");
        return new QueryForm();
    }
    
    @RequestMapping("/search")
    public String search(@RequestParam(value = "q", required = false, defaultValue = "*:*") String q, Model model) {
        
        ModifiableSolrParams solrParams = new ModifiableSolrParams();
        solrParams.set("q", q);
        QueryResponse response = searchService.getSearchResponse(solrParams);
        logger.info("QueryResponse: " + response);
        model.addAttribute("response", response);
        model.addAttribute("q", q);
        return "search";
    }
}
