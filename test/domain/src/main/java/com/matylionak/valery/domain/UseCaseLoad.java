package com.matylionak.valery.domain;

import android.content.Context;

import com.matylionak.valery.data.DataBaseManager;
import com.matylionak.valery.data.People;
import com.matylionak.valery.domain.base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

//loading IN  and OUT BD
public class UseCaseLoad extends UseCase<Context, List<People>> {
    @Override
    protected Observable<List<People>> builtUseCase(final Context context) {
        return Observable.just(true).map(new Function<Boolean, List<People>>() {
            @Override
            public List<People> apply(Boolean aBoolean) throws Exception {
                DataBaseManager manager = new DataBaseManager(context);
                factory(manager);//dummy data
                List<People> people = new ArrayList<>();
                manager.open(false);
                people.addAll(manager.getPeoples());
                manager.close();

                return people;
            }
        });
    }

    //dummy data
    public void factory(DataBaseManager manager) {
        manager.open(true);
        People people1 = new People();
        people1.setName("Marilyn Manson");
        people1.setProfession("musician");
        people1.setEmail("marylin.manson@mm.us");
        people1.setAge(56);
        people1.setPhone("+375 33 398 23 23");
        manager.insertPeople(people1);

        People people2 = new People();
        people2.setName("Iggy Pop");
        people2.setProfession("musician");
        people2.setEmail("iggy.pop@ig.us");
        people2.setAge(64);
        people2.setPhone("+375 33 00 00 00");
        manager.insertPeople(people2);

        People people3 = new People();
        people3.setName("Justin Biber");
        people3.setProfession("musician");
        people3.setEmail("justin.biber@jb.us");
        people3.setAge(23);
        people3.setPhone("+375 33 11 11 11");
        manager.insertPeople(people3);
        manager.close();


    }


}
