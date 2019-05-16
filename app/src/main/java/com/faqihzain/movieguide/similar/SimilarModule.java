package com.faqihzain.movieguide.similar;

import com.faqihzain.movieguide.network.TmdbWebService;

import dagger.Module;
import dagger.Provides;

@Module
public class SimilarModule {
    @Provides
    @SimilarScope
    MoviesSimilarInteractor provideMovieSimilarInteractor(TmdbWebService tmdbWebService) {
        return new MoviesSimilarInteractorImpl(tmdbWebService);
    }

    @Provides
    @SimilarScope
    MoviesSimilarPresenter provideMovieSimilarPresenter(MoviesSimilarInteractor interactor) {
        return new MoviesSimilarPresenterImpl(interactor);
    }
}
