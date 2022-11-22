package ru.vysokov.phonebook;

public class Individual extends User {
    int id;
    String age;
    String education;
    String profession;

    public Individual(String name, String phone, String address, String age, String education, String profession) {
        super(name, phone, address);
        this.id = ENV.ID;
        this.age = age;
        this.education = education;
        this.profession = profession;
    }

}
