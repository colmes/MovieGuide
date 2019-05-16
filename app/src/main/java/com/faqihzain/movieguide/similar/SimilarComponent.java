package com.faqihzain.movieguide.similar;

import dagger.Subcomponent;

@SimilarScope
@Subcomponent(modules = {SimilarModule.class})
public interface SimilarComponent {
    MoviesSimilarFragment inject(MoviesSimilarFragment fragment);
}
