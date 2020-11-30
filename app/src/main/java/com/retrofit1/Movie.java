package com.retrofit1;

public class Movie {
    private String id;
    private String name;

    public Details getDetails() {
        return details;
    }

    public Float getRating() {
        return rating;
    }

    public Movie(String id, String name, Float rating, String picture, String videoOk, String videoSrv, Details details) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.picture = picture;
        this.videoOk = videoOk;
        this.videoSrv = videoSrv;
        this.details = details;
    }

    private Float rating;
    private String picture;
    private String videoOk;
    private String videoSrv;
    private Details details;
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public String getVideoOk() {
        return videoOk;
    }

    public String getVideoSrv() {
        return videoSrv;
    }
}
