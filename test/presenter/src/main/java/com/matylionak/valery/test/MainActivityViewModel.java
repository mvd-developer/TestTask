package com.matylionak.valery.test;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.SearchView;
import android.widget.Toast;

import com.matylionak.valery.data.People;
import com.matylionak.valery.domain.UseCaseASC;
import com.matylionak.valery.domain.UseCaseDESC;
import com.matylionak.valery.domain.UseCaseLoad;
import com.matylionak.valery.domain.UseCaseSearching;
import com.matylionak.valery.test.base.BaseViewModel;
import com.matylionak.valery.test.databinding.ActivityMainBinding;
import com.matylionak.valery.test.di.TestApplication;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;


public class MainActivityViewModel implements BaseViewModel {

    private Context activity;
    private ActivityMainBinding binding;
    @Inject MyAdaptor adaptor;
    @Inject UseCaseLoad load;
    @Inject UseCaseSearching searching;
    @Inject UseCaseASC useCaseASC;
    @Inject UseCaseDESC useCaseDESC;


    public MainActivityViewModel(Context context) {
        this.activity= context;
        TestApplication.appComponent.inject2(this);
    }

    @Override
    public void init() {
        binding.recycle.setLayoutManager(new LinearLayoutManager(activity));
        binding.recycle.setAdapter(adaptor);
        load.execute(activity, new DisposableObserver<List<People>>() {
            @Override
            public void onNext(List<People> people) {
                adaptor.setList(people);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Toast.makeText(activity, s.toUpperCase(), Toast.LENGTH_SHORT).show();
                searching.execute(s, new DisposableObserver<List<People>>() {
                    @Override
                    public void onNext(List<People> people) {
                        adaptor.setList(people);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


                return false;
            }
        });


    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {
        load.dispose();
        searching.dispose();
        if (useCaseASC != null) {
            useCaseASC.dispose();
        }

        if (useCaseDESC != null) {
            useCaseDESC.dispose();
        }


    }


    public void sortASC() {
        useCaseASC.execute(activity, new DisposableObserver<List<People>>() {
            @Override
            public void onNext(List<People> people) {
                adaptor.setList(people);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    public void sortDESC(){
        useCaseDESC.execute(activity, new DisposableObserver<List<People>>() {
            @Override
            public void onNext(List<People> people) {
                adaptor.setList(people);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });



    }


    //GETTERS & SETTERS

    public void setBinding(ActivityMainBinding binding) {
        this.binding = binding;
    }
}
