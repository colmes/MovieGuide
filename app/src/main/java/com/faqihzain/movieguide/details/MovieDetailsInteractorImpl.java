package com.faqihzain.movieguide.details;

import com.faqihzain.movieguide.Review;
import com.faqihzain.movieguide.ReviewsWrapper;
import com.faqihzain.movieguide.Video;
import com.faqihzain.movieguide.VideoWrapper;
import com.faqihzain.movieguide.network.TmdbWebService;

import java.util.List;

import io.reactivex.Observable;

class MovieDetailsInteractorImpl implements MovieDetailsInteractor {

    private TmdbWebService tmdbWebService;

    MovieDetailsInteractorImpl(TmdbWebService tmdbWebService) {
        this.tmdbWebService = tmdbWebService;
    }

    @Override
    public Observable<List<Video>> getTrailers(final String id) {
        return tmdbWebService.trailers(id).map(VideoWrapper::getVideos);
    }

    @Override
    public Observable<List<Review>> getReviews(final String id) {
        return tmdbWebService.reviews(id).map(ReviewsWrapper::getReviews);
    }

}
