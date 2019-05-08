package com.e.sqlite;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeClient {
    @GET("employees")
    Call<List<Employee>>getEmployees();
}
