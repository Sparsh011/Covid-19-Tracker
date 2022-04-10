package com.example.datavid_19.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    String BASE_URL = "https://corona.lmao.ninja/v2/";
    @GET("countries")
    Call<List<CountryData>> getCountryData();
}
