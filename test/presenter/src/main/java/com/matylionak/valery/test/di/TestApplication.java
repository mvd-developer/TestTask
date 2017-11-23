package com.matylionak.valery.test.di;

import android.app.Application;



public class TestApplication extends Application {

    public static AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();


    }
}
