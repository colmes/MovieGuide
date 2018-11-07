package com.faqihzain.movieguide.favorites;

import com.faqihzain.movieguide.Movie;

import java.util.List;

public interface FavoritesInteractor
{
    void setFavorite(Movie movie);
    boolean isFavorite(String id);
    List<Movie> getFavorites();
    void unFavorite(String id);
}
