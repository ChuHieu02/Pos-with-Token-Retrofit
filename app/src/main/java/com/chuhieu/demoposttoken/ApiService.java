package com.chuhieu.demoposttoken;



import com.chuhieu.demoposttoken.model.Category;
import com.chuhieu.demoposttoken.model.CategoryResponse;
import com.google.gson.JsonArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @Headers({"Content-Type: application/json"})
    @POST("api/Category/ProductList")
    Call<List<CategoryResponse>> body1(@Header("Authorization") String auth, @Body Category category);

}
