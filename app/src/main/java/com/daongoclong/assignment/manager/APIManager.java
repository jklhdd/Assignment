package com.daongoclong.assignment.manager;

import com.daongoclong.assignment.model.Content;
import com.daongoclong.assignment.model.CurrentCondition;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIManager {
    String SERVER_URL = "http://dataservice.accuweather.com/";

    @GET("forecasts/v1/hourly/12hour/353412?apikey=y86pLx9sK04HxJGOFHd5Aog0nJD7Rv8b&language=vi-vn&metric=true")
    Call<List<Content>> getHoursCondition();

    @GET("currentconditions/v1/353412?apikey=y86pLx9sK04HxJGOFHd5Aog0nJD7Rv8b&language=vi-vn")
    Call<List<CurrentCondition>> getCurrentCondition();
}
