package com.retrofit1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPICall {

    @GET("movie")
    Call<Movie> getMovieCall();
}
