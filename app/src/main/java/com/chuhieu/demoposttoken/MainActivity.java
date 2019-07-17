package com.chuhieu.demoposttoken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.chuhieu.demoposttoken.model.Category;
import com.chuhieu.demoposttoken.model.CategoryResponse;
import com.google.gson.JsonArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://bmsapi.hosco.com.vn/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService client = retrofit.create(ApiService.class);
        Category category = new Category("", "", "",
                true, 0, "", 100, 0);

        Call<List<CategoryResponse>> call = client.body1("Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJob3NjbyIsImF6cCI6ImFkbWluIiwianRpIjoiZDQ1MTI5MjQtNDRjOS00OThhLWE3MjAtNzUwZjY1ZTZhZDA2IiwibmFtZWlkIjoiMSIsInNpZCI6IiIsIm5iZiI6MTU2MzI0MzA0NiwiZXhwIjoxNTY4NDI3MDQ2LCJpc3MiOiJob3Njby52biIsImF1ZCI6Imhvc2NvLnZuIn0.uDULbLwWdUTIN6-5fM6RSyh3G7VtQe56yLaZPC-p9eo", category);
        call.enqueue(new Callback<List<CategoryResponse>>() {
            @Override
            public void onResponse(Call<List<CategoryResponse>> call, Response<List<CategoryResponse>> response) {
                Log.e("SIZE",response.body().size()+"");
            }

            @Override
            public void onFailure(Call<List<CategoryResponse>> call, Throwable t) {

            }
        });
    }


}
