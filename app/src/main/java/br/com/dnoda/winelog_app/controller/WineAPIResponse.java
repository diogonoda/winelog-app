package br.com.dnoda.winelog_app.controller;

import java.util.List;

import br.com.dnoda.winelog_app.model.Wine;
import br.com.dnoda.winelog_app.model.WineResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WineAPIResponse {
    @GET("/wine")
    Call<List<Wine>> listWines();
}
