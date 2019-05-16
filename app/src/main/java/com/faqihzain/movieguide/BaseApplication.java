package com.faqihzain.movieguide;

import android.app.Application;
import android.os.StrictMode;

import com.faqihzain.movieguide.details.DetailsComponent;
import com.faqihzain.movieguide.details.DetailsModule;
import com.faqihzain.movieguide.favorites.FavoritesModule;
import com.faqihzain.movieguide.listing.ListingComponent;
import com.faqihzain.movieguide.listing.ListingModule;
import com.faqihzain.movieguide.network.NetworkModule;
import com.faqihzain.movieguide.similar.SimilarComponent;
import com.faqihzain.movieguide.similar.SimilarModule;

import io.realm.Realm;

public class BaseApplication extends Application {

    private AppComponent appComponent;
    private ListingComponent listingComponent;
    private DetailsComponent detailsComponent;
    private SimilarComponent similarComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        StrictMode.enableDefaults();
        initRealm();
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent() {

        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .favoritesModule(new FavoritesModule())
                .build();
    }

    private void initRealm(){
        Realm.init(this);
    }

    public DetailsComponent createDetailsComponent()
    {
        detailsComponent = appComponent.plus(new DetailsModule());
        return detailsComponent;
    }

    public void releaseDetailsComponent()
    {
        detailsComponent = null;
    }

    public ListingComponent createListingComponent()
    {
        listingComponent = appComponent.plus(new ListingModule());
        return listingComponent;
    }

    public SimilarComponent createSimilarComponent()
    {
        similarComponent = appComponent.plus(new SimilarModule());
        return similarComponent;
    }

    public void releaseListingComponent()
    {
        listingComponent = null;
    }

    public ListingComponent getListingComponent()
    {
        return listingComponent;
    }
}
