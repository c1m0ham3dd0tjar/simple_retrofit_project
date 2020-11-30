package com.retrofit1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONResponse {

    @SerializedName("movies")
    @Expose
    private Movie[] moviesArray;

    public Movie[] getMoviesArray() {
        return moviesArray;
    }

}
