package com.matylionak.valery.test.di;


import com.matylionak.valery.test.MainActivity;
import com.matylionak.valery.test.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {


    public void inject(MainActivity mainActivity);
    public void inject2(MainActivityViewModel mainActivityViewModel);

}
