package com.faqihzain.movieguide.similar;

import com.faqihzain.movieguide.Movie;

import java.util.List;

import io.reactivex.Observable;

public interface MoviesSimilarInteractor {

    Observable<List<Movie>> similarMovies(String id);
}
