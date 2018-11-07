package com.faqihzain.movieguide.details;

import com.faqihzain.movieguide.favorites.FavoritesInteractor;
import com.faqihzain.movieguide.network.TmdbWebService;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailsModule {
    @Provides
    @DetailsScope
    MovieDetailsInteractor provideInteractor(TmdbWebService tmdbWebService) {
        return new MovieDetailsInteractorImpl(tmdbWebService);
    }

    @Provides
    @DetailsScope
    MovieDetailsPresenter providePresenter(MovieDetailsInteractor detailsInteractor,
                                           FavoritesInteractor favoritesInteractor) {
        return new MovieDetailsPresenterImpl(detailsInteractor, favoritesInteractor
        );
    }
}
