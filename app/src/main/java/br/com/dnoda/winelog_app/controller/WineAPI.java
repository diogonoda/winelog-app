package br.com.dnoda.winelog_app.controller;

import br.com.dnoda.winelog_app.model.Wine;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WineAPI {

    @GET("/wine/name/{name}")
    Call<Wine> findWine(@Path("name")String name);

    @POST("wine/new")
    Call<Wine> save(@Body Wine wine);
}