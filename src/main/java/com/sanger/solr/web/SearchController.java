/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.web;

import com.sanger.solr.model.search.QueryForm;
import com.sanger.solr.service.SearchService;
import com.sanger.solr.utils.DefaultProperties;
import com.sanger.solr.utils.MathsFunctions;
import javax.validation.Valid;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * Controller for Search function
 *
 * @author mw8
 */
@Controller
public class SearchController implements ErrorController {

    Logger logger = LoggerFactory.getLogger(getClass());

    private DefaultProperties props;

    String docRoot;
    SearchService searchService;

    @Autowired
    MathsFunctions maths;
    
    private String collection;
    private static final String QT = "/tika";
    private final String PROPFILE = "app";
    private static final String ERROR_PATH = "/error";

    public SearchController() {
        searchService = new SearchService("lego");
        props = new DefaultProperties(PROPFILE);
    }

    @ModelAttribute("queryFormBean")
    public QueryForm createQueryForm() {
        logger.debug("Creating Query Form");
        QueryForm queryForm = new QueryForm();
        queryForm.setStart(0);
        queryForm.setRows(10);
        return queryForm;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(Model model) {
        model.addAttribute("queryForm", this.createQueryForm());
        model.addAttribute("message", "Lego Application working");
        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model) {
        model.addAttribute("queryForm", this.createQueryForm());
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
        //solrDocumentList.stream().forEach((solrDoc) -> {
        //    logger.debug("HL Field" + solrDoc.getFieldValue("highlight"));
        //});
        
        // Pagination
        long numFound = solrDocumentList.getNumFound();
        long rows = queryForm.getRows();
        int numOfPages = maths.getRoundedUpNum(numFound, rows);
        
        docRoot = props.getPropValue("docRoot");
        logger.debug("DocRoot:::" + docRoot);

        // get document root directory from properties file
        model.addAttribute("response", solrDocumentList);
        model.addAttribute("numFound", solrDocumentList.getNumFound());
        model.addAttribute("numOfPages", numOfPages);
        model.addAttribute("queryForm", queryForm);
        model.addAttribute("q", queryForm.getQ());
        model.addAttribute("docRoot", docRoot);
        return "results";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(value = ERROR_PATH)
    public String error(Model model) {
        model.addAttribute("queryForm", this.createQueryForm());
        return "error";
    }
}
