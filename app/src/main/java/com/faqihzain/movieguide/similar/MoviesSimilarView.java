package com.faqihzain.movieguide.similar;

import com.faqihzain.movieguide.Movie;

import java.util.List;

interface MoviesSimilarView {
    void showSimilarMovies(List<Movie> movies);
    void loadingStarted();
    void onMovieClicked(Movie movie);

}
