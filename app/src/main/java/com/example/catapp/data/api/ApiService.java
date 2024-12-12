package com.example.catapp.data.api;

import com.example.catapp.data.model.FoodResponse;
import com.example.catapp.data.model.FilterRequest; // Импортируйте ваш класс FilterRequest
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("api/v1/feed/all")
    Call<FoodResponse> getAllFoodItems(@Body FilterRequest filterRequest);
}