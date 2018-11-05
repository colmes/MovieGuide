package com.faqihzain.movieguide.listing;

import com.faqihzain.movieguide.Movie;

import java.util.List;


interface MoviesListingView
{
    void showMovies(List<Movie> movies);
    void loadingStarted();
    void loadingFailed(String errorMessage);
    void onMovieClicked(Movie movie);
}
