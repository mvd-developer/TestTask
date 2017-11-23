package com.matylionak.valery.domain.base;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<InParam, OutParam> {


    private Disposable disposable;


    //subscribing
    protected abstract Observable<OutParam> builtUseCase(InParam param);


    public void execute(InParam param, DisposableObserver<OutParam> disposableObserver) {
        disposable = builtUseCase(param)
                .observeOn(AndroidSchedulers.mainThread()) //get
                .subscribeOn(Schedulers.newThread()) //working at
                .subscribeWith(disposableObserver);

    }


    //to dispose
    public void dispose() {

        if (disposable != null) {
            if (!disposable.isDisposed()) {

                disposable.dispose();

            }
        }


    }

}