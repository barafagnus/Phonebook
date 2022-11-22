package ru.vysokov.phonebook;

public class Company extends User {
    int id;
    String mail;
    String activity;
    String staff;
    public Company(String name, String phone, String address, String mail, String activity, String staff) {
        super(name, phone, address);
        this.id = ENV.ID;
        this.mail = mail;
        this.activity = activity;
        this.staff = staff;
    }

}
