package com.faqihzain.movieguide.similar;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.faqihzain.movieguide.Api;
import com.faqihzain.movieguide.Movie;
import com.faqihzain.movieguide.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesSimilarAdapter extends RecyclerView.Adapter<MoviesSimilarAdapter.ViewHolder> {
    private List<Movie> movies;
    private Context context;
    private MoviesSimilarView view;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.movie_poster)
        ImageView poster;
        @BindView(R.id.title_background)
        View titleBackground;
        @BindView(R.id.movie_name)
        TextView name;

        public Movie movie;

        public ViewHolder(View root) {
            super(root);
            ButterKnife.bind(this, root);
        }

        @Override
        public void onClick(View view) {
            MoviesSimilarAdapter.this.view.onMovieClicked(movie);

        }
    }
    public MoviesSimilarAdapter(List<Movie> movies, MoviesSimilarView moviesView) {
        this.movies = movies;
        view = moviesView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View rootView = LayoutInflater.from(context).inflate(R.layout.movie_grid_item, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(holder);
        holder.movie = movies.get(position);
        holder.name.setText(holder.movie.getTitle());

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .priority(Priority.HIGH);

        Glide.with(context)
                .asBitmap()
                .load(Api.getPosterPath(holder.movie.getPosterPath()))
                .apply(options)
                .into(new BitmapImageViewTarget(holder.poster) {
                    @Override
                    public void onResourceReady(Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
                        super.onResourceReady(bitmap, transition);
                        Palette.from(bitmap).generate(palette -> setBackgroundColor(palette, holder));
                    }
                });
    }

    private void setBackgroundColor(Palette palette, ViewHolder holder) {
        holder.titleBackground.setBackgroundColor(palette.getVibrantColor(context
                .getResources().getColor(R.color.black_translucent_60)));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}