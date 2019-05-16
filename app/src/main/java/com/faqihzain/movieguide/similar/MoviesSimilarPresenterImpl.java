package com.faqihzain.movieguide.similar;

import com.faqihzain.movieguide.Movie;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MoviesSimilarPresenterImpl implements MoviesSimilarPresenter {
    private MoviesSimilarView view;
    private MoviesSimilarInteractor moviesSimilarInteractor;
    private Disposable fetchSubscription;
    private Disposable movieSearchSubscription;
    private int currentPage = 1;
    private List<Movie> loadedSimilarMovies = new ArrayList<>();

    MoviesSimilarPresenterImpl(MoviesSimilarInteractor interactor){
        this.moviesSimilarInteractor = interactor;
    }

    @Override
    public void setView(MoviesSimilarView view) {
        this.view = view;
    }

    @Override
    public void showSimilarMovies(String id) {
        showLoading();
        movieSearchSubscription = moviesSimilarInteractor.similarMovies(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onFailed);
    }

    private void onFailed(Throwable throwable) {
    }

    private void onSuccess(List<Movie> movies) {
        loadedSimilarMovies.clear();
        loadedSimilarMovies = new ArrayList<>(movies);
        if (isViewAttached()) {
            view.showSimilarMovies(loadedSimilarMovies);
        }
    }

    private void showLoading() {
        if (isViewAttached()) {
            view.loadingStarted();
        }
    }

    private boolean isViewAttached() {
        return view != null;
    }
}
