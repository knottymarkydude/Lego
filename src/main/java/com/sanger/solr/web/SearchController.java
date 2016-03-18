/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.web;

import com.sanger.model.search.QueryForm;
import com.sanger.solr.config.Config;
import com.sanger.solr.service.SearchService;
import java.util.List;
import javax.validation.Valid;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
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

    /**
    @ModelAttribute("queryFormBean")
    public QueryForm createQueryForm() {
        logger.debug("Creating Query Form");
        return new QueryForm();
    }**/

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(QueryForm queryForm) {
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String newSearch(@Valid QueryForm queryForm, BindingResult bindingResult, Model model) {
        logger.debug("newSearch");
        logger.debug("bindingResult" + bindingResult);
        if (bindingResult.hasErrors()) {
            logger.debug("hasErrors");
            return "search";
        }

        logger.info("queryForm:::" + queryForm.toString());
        
        SolrDocumentList solrDocumentList = searchService.getResults(queryForm);
        logger.info("Results: " + solrDocumentList.toString());
        
        model.addAttribute("response", solrDocumentList);
        model.addAttribute("numFound", solrDocumentList.getNumFound());
        model.addAttribute("start", solrDocumentList.getStart());
        model.addAttribute("rows", queryForm.getRows());
        model.addAttribute("q", queryForm.getQ());
        return "results";
    }
}
