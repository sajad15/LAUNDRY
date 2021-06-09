package com.example.laundry.model;

public class table_user {
    private String Nama;
    private String Email;
    private String No_hp;
    private String Password;

    public table_user(String nama, String email, String no_hp, String password) {
        Nama = nama;
        Email = email;
        No_hp = no_hp;
        Password = password;
    }

    public table_user() {

    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNo_hp() {
        return No_hp;
    }

    public void setNo_hp(String no_hp) {
        No_hp = no_hp;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
