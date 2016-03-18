/*
 * Lego Project
 * 
 * Sanger Institute
 */
package com.sanger.solr.service.model;

/**
 * Solr response for adding to result page.
 *
 * @author mw8
 */
public class ResultDocument {
    private String id;
    private String content_type;
    private String directory;
    private String filename;
    private String score;
    private String highlights;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getHighlights() {
        return highlights;
    }

    public void setHighlights(String highlights) {
        this.highlights = highlights;
    }

    @Override
    public String toString() {
        return "ResultDocument{" + "id=" + id + ", content_type=" + content_type + ", directory=" + directory + ", filename=" + filename + ", score=" + score + ", highlights=" + highlights + '}';
    }
    
    
}
