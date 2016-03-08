/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mw8
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "The Lego Application is running!";
    }
}
