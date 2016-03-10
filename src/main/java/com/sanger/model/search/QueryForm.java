/*
/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.model.search;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * Backing Bean used for Querying
 * 
 * @author mw8
 */
public class QueryForm {
    
    @NotEmpty(message = "Query is empty.")
    private String q;
    @NotNull
    private Integer start;
    private Integer rows;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
    
    
    
}
