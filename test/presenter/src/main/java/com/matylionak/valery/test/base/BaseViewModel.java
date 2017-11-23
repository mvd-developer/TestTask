package com.matylionak.valery.test.base;

/**
 * Interface to sync activity and view model lifecycle
 */
public interface BaseViewModel {

    void init();

    void release();

    void resume();

    void pause();


}
