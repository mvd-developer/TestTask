package com.matylionak.valery.test;


import android.databinding.ObservableField;

public class ItemViewModel {

    private ObservableField<String> name = new ObservableField<>("");
    private ObservableField<String> profession = new ObservableField<>("");
    private ObservableField<String> phone = new ObservableField<>("");
    private ObservableField<String> age = new ObservableField<>();
    private ObservableField<String> email = new ObservableField<>("");


    public ObservableField<String> getName() {
        return name;
    }

    public ObservableField<String> getProfession() {
        return profession;
    }

    public ObservableField<String> getPhone() {
        return phone;
    }

    public ObservableField<String> getAge() {
        return age;
    }

    public ObservableField<String> getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setProfession(String profession) {
        this.profession.set(profession);
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public void setAge(int age) {
        this.age.set(String.valueOf(age));
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}
