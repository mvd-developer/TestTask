package com.matylionak.valery.domain;

import android.content.Context;

import com.matylionak.valery.data.DataBaseManager;
import com.matylionak.valery.data.People;
import com.matylionak.valery.domain.base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;


public class UseCaseASC extends UseCase<Context, List<People>> {
    @Override
    protected Observable<List<People>> builtUseCase(final Context context) {
        return Observable.just(true).map(new Function<Boolean, List<People>>() {
            @Override
            public List<People> apply(Boolean aBoolean) throws Exception {
                DataBaseManager manager = new DataBaseManager(context);
                List<People> people = new ArrayList<>();
                manager.open(false);
                people.addAll(manager.getPeoplesASC());
                manager.close();
                return people;
            }
        });
    }
}
