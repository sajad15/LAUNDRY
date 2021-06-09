package com.example.laundry.model;

public class table_customer {
    private String Id;
    private String Alamat_customer;
    private String Nama_customer;
    private String Tlp_customer;

    public table_customer() {

    }

    public table_customer(String id, String alamat_customer, String nama_customer, String tlp_customer) {
        Id = id;
        Alamat_customer = alamat_customer;
        Nama_customer = nama_customer;
        Tlp_customer = tlp_customer;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAlamat_customer() {
        return Alamat_customer;
    }

    public void setAlamat_customer(String alamat_customer) {
        Alamat_customer = alamat_customer;
    }

    public String getNama_customer() {
        return Nama_customer;
    }

    public void setNama_customer(String nama_customer) {
        Nama_customer = nama_customer;
    }

    public String getTlp_customer() {
        return Tlp_customer;
    }

    public void setTlp_customer(String tlp_customer) {
        Tlp_customer = tlp_customer;
    }
}
