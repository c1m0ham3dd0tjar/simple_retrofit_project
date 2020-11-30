package com.retrofit1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    static String baseUrl = "";
    TextView id, name, videosrv, videook;
    ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = findViewById(R.id.id);
        videook = findViewById(R.id.videook);
        videosrv = findViewById(R.id.videosrv);
        name = findViewById(R.id.name);
        picture = findViewById(R.id.picture);

        //Retrofit Builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instance for interface
        MyAPICall myAPICall = retrofit.create(MyAPICall.class);

        Call<Movie> call = myAPICall.getMovieCall();

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                //checking for response
                if (response.code() != 200) {
                    name.setText("verify the network");
                    return;
                } else {
                    id.setText(response.body().getId());
                    name.setText(response.body().getName());
                    videook.setText(response.body().getVideoOk());
                    videosrv.setText(response.body().getVideoSrv());
                    Picasso.get().load(response.body().getPicture()).into(picture);
                }

            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }
}