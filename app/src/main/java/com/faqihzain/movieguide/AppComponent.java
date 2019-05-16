package com.faqihzain.movieguide;

import com.faqihzain.movieguide.details.DetailsComponent;
import com.faqihzain.movieguide.details.DetailsModule;
import com.faqihzain.movieguide.favorites.FavoritesModule;
import com.faqihzain.movieguide.listing.ListingComponent;
import com.faqihzain.movieguide.listing.ListingModule;
import com.faqihzain.movieguide.network.NetworkModule;
import com.faqihzain.movieguide.similar.SimilarComponent;
import com.faqihzain.movieguide.similar.SimilarModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        FavoritesModule.class})

public interface AppComponent {

    ListingComponent plus(ListingModule listingModule);

    DetailsComponent plus(DetailsModule detailsModule);

    SimilarComponent plus(SimilarModule similarModule);
}
