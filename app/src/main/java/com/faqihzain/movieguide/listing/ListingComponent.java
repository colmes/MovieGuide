package com.faqihzain.movieguide.listing;

import com.faqihzain.movieguide.listing.sorting.SortingDialogFragment;
import com.faqihzain.movieguide.listing.sorting.SortingModule;

import dagger.Subcomponent;

@ListingScope
@Subcomponent(modules = {ListingModule.class, SortingModule.class})
public interface ListingComponent {
    MoviesListingFragment inject(MoviesListingFragment fragment);

    SortingDialogFragment inject(SortingDialogFragment fragment);
}
