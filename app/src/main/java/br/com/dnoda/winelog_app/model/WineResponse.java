package br.com.dnoda.winelog_app.model;

import java.util.List;

public class WineResponse {
    private List<Wine> results;

    public void setResults(List<Wine> results) {
        this.results = results;
    }

    public List<Wine> getResults() {
        return results;
    }
}
