/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mw8
 */
@Controller
public class SearchController {
    
    @RequestMapping("/search")
    public String search(@RequestParam(value = "q", required = false, defaultValue = "World") String term, Model model) {
        model.addAttribute("q", term);
        return "search";
    }
}
