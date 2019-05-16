package com.faqihzain.movieguide.similar;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.faqihzain.movieguide.Constants;
import com.faqihzain.movieguide.Movie;
import com.faqihzain.movieguide.R;
import com.faqihzain.movieguide.details.MovieDetailsActivity;
import com.faqihzain.movieguide.details.MovieDetailsFragment;

public class MoviesSimilarActivity extends AppCompatActivity implements MoviesSimilarFragment.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_similar);
        setToolbar();
        Intent intent = getIntent();
        final String id = intent.getStringExtra("id");
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_similar, MoviesSimilarFragment.getInstance(id))
                    .commit();
        }
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.similar);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMovieSimilarClicked(Movie movie) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable(Constants.MOVIE, movie);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
