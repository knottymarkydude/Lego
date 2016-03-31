/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.web;

import com.sanger.model.search.QueryForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mw8
 */
@Controller
public class GreetingController {
    
    Logger logger = LoggerFactory.getLogger(getClass());
    
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "Basic Controller Test") String name, Model model) {
        QueryForm queryForm = new QueryForm();
        queryForm.setStart(0);
        queryForm.setRows(10);
        model.addAttribute("queryForm", queryForm);
        model.addAttribute("name", name);
        return "greeting";
    }

}
