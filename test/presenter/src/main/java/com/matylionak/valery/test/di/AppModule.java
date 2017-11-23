package com.matylionak.valery.test.di;


import android.content.Context;

import com.matylionak.valery.domain.UseCaseASC;
import com.matylionak.valery.domain.UseCaseDESC;
import com.matylionak.valery.domain.UseCaseLoad;
import com.matylionak.valery.domain.UseCaseSearching;
import com.matylionak.valery.test.MainActivityViewModel;
import com.matylionak.valery.test.MyAdaptor;


import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    //creating all the components
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }


    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public MainActivityViewModel provideMainActivityViewModel(Context context) {
        return new MainActivityViewModel(context);
    }


    @Provides
    public MyAdaptor provideMyAdaptor() {
        return new MyAdaptor();
    }


    @Provides
    public UseCaseLoad provideUseCaseLoad() {
        return new UseCaseLoad();
    }


    @Provides
    public UseCaseSearching provideUseCaseSearching(Context context) {
        return new UseCaseSearching(context);
    }


    @Provides
    public UseCaseASC provideUseCaseASC() {
        return new UseCaseASC();
    }


    @Provides
    public UseCaseDESC provideUseCaseDESC() {
        return new UseCaseDESC();
    }


}

