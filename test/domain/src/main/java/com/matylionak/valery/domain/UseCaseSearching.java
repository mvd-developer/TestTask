package com.matylionak.valery.domain;

import android.content.Context;

import com.matylionak.valery.data.DataBaseManager;
import com.matylionak.valery.data.People;
import com.matylionak.valery.domain.base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;



public class UseCaseSearching extends UseCase <String, List<People>> {
    private Context context;

    public UseCaseSearching(Context context) {
        this.context = context;
    }

    @Override
    protected Observable<List<People>> builtUseCase(String s) {
        return Observable.just(s).map(new Function<String, List<People>>() {
            @Override
            public List<People> apply(String s) throws Exception {
                List<People> people = new ArrayList<>();
                DataBaseManager manager = new DataBaseManager(context);
                manager.open(false);
                people.addAll(manager.getPeopleByKeyWord(s));
                manager.close();
                return people;
            }
        });
    }


}
