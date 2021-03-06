package com.retrofit1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>  {
    public Context context;
    private List<Movie> moviesList;
    public Adapter(Context context,List<Movie> moviesList){
        this.context=context;
        this.moviesList=moviesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        v=layoutInflater.inflate(R.layout.movie_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.id.setText(moviesList.get(position).getId());
    holder.release.setText(moviesList.get(position).getDetails().getRelease());
    holder.duration.setText(moviesList.get(position).getDetails().getDuration());
    holder.cats.setText(moviesList.get(position).getDetails().getCategory());
    holder.name.setText(moviesList.get(position).getName());
    holder.videosrv.setText(moviesList.get(position).getVideoSrv());
    holder.videook.setText(moviesList.get(position).getVideoOk());
        Picasso.get().load(moviesList.get(position).getPicture()).into(holder.picture);

 holder.rating.setRating(moviesList.get(position).getRating()/2);


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id, name, videosrv, videook,duration,release,cats;
        ImageView picture;
        RatingBar rating;
        public MyViewHolder(View view) {
            super(view);
            cats = view.findViewById(R.id.cats);
            rating = view.findViewById(R.id.rating);
            duration = view.findViewById(R.id.duration);
            release = view.findViewById(R.id.release);
            id = view.findViewById(R.id.id);
            videook = view.findViewById(R.id.videook);
            videosrv = view.findViewById(R.id.videosrv);
            name = view.findViewById(R.id.name);
            picture = view.findViewById(R.id.picture);

        }
    }
}
