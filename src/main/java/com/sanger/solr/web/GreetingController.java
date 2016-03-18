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
public class GreetingController {
    
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "Basic Controller Test") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
