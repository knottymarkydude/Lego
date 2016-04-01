/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.web;

import com.sanger.solr.model.search.QueryForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mw8
 */
//@Controller
public class HomeController {

    Logger logger = LoggerFactory.getLogger(getClass());
    
    @ModelAttribute("queryFormBean")
    public QueryForm createQueryForm() {
        logger.debug("Creating Query Form");
        return new QueryForm();
    }
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Lego Application");
        return "index";
    }
}
