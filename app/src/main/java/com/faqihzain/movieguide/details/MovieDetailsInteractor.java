package com.faqihzain.movieguide.details;

import com.faqihzain.movieguide.Review;
import com.faqihzain.movieguide.Video;

import java.util.List;

import io.reactivex.Observable;

public interface MovieDetailsInteractor
{
    Observable<List<Video>> getTrailers(String id);
    Observable<List<Review>> getReviews(String id);
}
