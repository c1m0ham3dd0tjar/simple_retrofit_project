package com.retrofit1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPICall {

    @GET("movie")
    Call<JSONResponse> getMovies();
//    Call<List<Movie>> getMovies();
}
