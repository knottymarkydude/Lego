/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mw8
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Lego Application");
        return "index";
    }
}
