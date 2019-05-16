package com.faqihzain.movieguide.similar;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faqihzain.movieguide.BaseApplication;
import com.faqihzain.movieguide.Movie;
import com.faqihzain.movieguide.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MoviesSimilarFragment extends Fragment implements MoviesSimilarView {

    @Inject
    MoviesSimilarPresenter moviesSimilarPresenter;

    @BindView(R.id.movies_similar)
    RecyclerView moviesSimilarListing;

    private RecyclerView.Adapter adapter;
    private List<Movie> movies = new ArrayList<>(20);

    private Unbinder unbinder;

    private Callback callback;

    String id;

    public MoviesSimilarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication) getActivity().getApplication()).createSimilarComponent().inject(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movies_similar, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        initLayoutReferences();

        // Inflate the layout for this fragment
        return rootView;
    }

    private void initLayoutReferences() {
        moviesSimilarListing.setHasFixedSize(true);

        int columns;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            columns = 2;
        } else {
            columns = getResources().getInteger(R.integer.no_of_columns);
        }
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), columns);

        moviesSimilarListing.setLayoutManager(layoutManager);
        adapter = new MoviesSimilarAdapter(movies, this);
        moviesSimilarListing.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null)
        {
            String id = (String) getArguments().get("id");
            if (id != null)
            {
                this.id = id;
                moviesSimilarPresenter.setView(this);
                moviesSimilarPresenter.showSimilarMovies(id);
            }
        }

    }

    public static MoviesSimilarFragment getInstance(@NonNull String id)
    {
        Bundle args = new Bundle();
        args.putString("id", id);
        MoviesSimilarFragment moviesSimilarFragment = new MoviesSimilarFragment();
        moviesSimilarFragment.setArguments(args);
        return moviesSimilarFragment;
    }
    
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (Callback) context;
    }

    @Override
    public void onDetach() {
        callback = null;
        super.onDetach();
    }

    @Override
    public void showSimilarMovies(List<Movie> movies) {
        this.movies.clear();
        this.movies.addAll(movies);
        moviesSimilarListing.setVisibility(View.VISIBLE);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadingStarted() {

    }

    @Override
    public void onMovieClicked(Movie movie) {
        callback.onMovieSimilarClicked(movie);

    }


    public interface Callback {
        void onMovieSimilarClicked(Movie movie);
    }

}
