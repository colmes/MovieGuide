package com.faqihzain.movieguide.details;

import android.content.Context;

import com.faqihzain.movieguide.Movie;

public interface MovieDetailsPresenter
{
    void showDetails(Movie movie);

    void showTrailers(Movie movie);

    void showReviews(Movie movie);

    void showFavoriteButton(Movie movie);

    void onFavoriteClick(Movie movie);

    void setView(MovieDetailsView view);

    void destroy();

    void onSimilarMoviesClick(Context context, String id);
}
