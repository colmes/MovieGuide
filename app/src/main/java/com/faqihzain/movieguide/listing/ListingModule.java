package com.faqihzain.movieguide.listing;

import com.faqihzain.movieguide.listing.sorting.SortingOptionStore;
import com.faqihzain.movieguide.network.TmdbWebService;

import dagger.Module;
import dagger.Provides;

@Module
public class ListingModule {

    @Provides
    MoviesListingInteractor provideMovieListingInteractor(//FavoritesInteractor favoritesInteractor,
                                                          TmdbWebService tmdbWebService
                                                          ,SortingOptionStore sortingOptionStore
                                                          ) {
        return new MoviesListingInteractorImpl(//favoritesInteractor,
                 tmdbWebService
                , sortingOptionStore
                );
    }

    @Provides
    MoviesListingPresenter provideMovieListingPresenter(MoviesListingInteractor interactor) {
        return new MoviesListingPresenterImpl(interactor);
    }
}
