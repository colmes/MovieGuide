package com.faqihzain.movieguide;

import android.app.Application;
import android.os.StrictMode;

import com.faqihzain.movieguide.listing.ListingComponent;
import com.faqihzain.movieguide.listing.ListingModule;
import com.faqihzain.movieguide.network.NetworkModule;

import io.realm.Realm;

public class BaseApplication extends Application {

    private AppComponent appComponent;
    private ListingComponent listingComponent;

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
                .build();
    }

    private void initRealm(){
        Realm.init(this);
    }

    public ListingComponent createListingComponent()
    {
        listingComponent = appComponent.plus(new ListingModule());
        return listingComponent;
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
