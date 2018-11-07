package com.faqihzain.movieguide.favorites;

import com.faqihzain.movieguide.AppModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = AppModule.class)
public class FavoritesModule
{
    @Provides
    @Singleton
    FavoritesInteractor provideFavouritesInteractor(FavoritesStore store)
    {
        return new FavoritesInteractorImpl(store);
    }
}
