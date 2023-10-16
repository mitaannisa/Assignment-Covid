package com.example.covidinfoactivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    public static String BASE_URL = "https://disease.sh/v3/covid-19/all";

    @GET("all")
    Call<Covid> getCovidData();

}
