package com.e.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import okhttp3.OkHttpClient;
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
        String BASE_URL = "http://dummy.restapiexample.com/api/v1/";
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.client(httpClient.build()).build();
        EmployeeClient employeeClient = retrofit.create(EmployeeClient.class);
        Call<List<Employee>>call = employeeClient.getEmployees();
        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                Log.d("aa",response.body().toString());


            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.d("bb" , t.getLocalizedMessage());
            }
        });
        }
    }
