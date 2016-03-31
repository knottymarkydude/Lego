/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.web;

import com.sanger.model.search.QueryForm;
import com.sanger.solr.config.Config;
import com.sanger.solr.service.SearchService;
import javax.validation.Valid;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * Controller for Search function
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
      
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(Model model) {
        QueryForm queryForm = new QueryForm();
        queryForm.setStart(0);
        queryForm.setRows(10);
        model.addAttribute("queryForm", queryForm);
        model.addAttribute("message", "Lego Application working");
        return "index";
    } 

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model) {
        QueryForm queryForm = new QueryForm();
        queryForm.setStart(0);
        queryForm.setRows(10);
        model.addAttribute("queryForm", queryForm);
        return "search";
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchSubmit(@Valid QueryForm queryForm, BindingResult bindingResult, Model model) {
        logger.debug("newSearch");
        logger.debug("bindingResult" + bindingResult);
        if (bindingResult.hasErrors()) {
            logger.debug("hasErrors");
            return "search";
        }
        
        logger.debug("queryForm:::" + queryForm.toString());
        
        SolrDocumentList solrDocumentList = searchService.getResults(queryForm);
        logger.debug("Results: " + solrDocumentList.toString());
        solrDocumentList.stream().forEach((solrDoc) -> {
            logger.info("HL Field" + solrDoc.getFieldValue("highlight"));
        });
        
        model.addAttribute("response", solrDocumentList);
        model.addAttribute("numFound", solrDocumentList.getNumFound());
        model.addAttribute("queryForm", queryForm);
        model.addAttribute("q", queryForm.getQ());
        return "results";
    }
}
