package com.faqihzain.movieguide.similar;

import com.faqihzain.movieguide.Movie;
import com.faqihzain.movieguide.MoviesWraper;
import com.faqihzain.movieguide.network.TmdbWebService;

import java.util.List;

import io.reactivex.Observable;

public class MoviesSimilarInteractorImpl implements MoviesSimilarInteractor {

    private TmdbWebService tmdbWebService;

    MoviesSimilarInteractorImpl(TmdbWebService tmdbWebService){
        this.tmdbWebService = tmdbWebService;
    }

    @Override
    public Observable<List<Movie>> similarMovies(String id) {
        return tmdbWebService.similarMovies(id).map(MoviesWraper::getMovieList);
    }
}
