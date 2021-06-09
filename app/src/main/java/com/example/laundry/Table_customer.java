package com.example.laundry;

public class Table_customer {
    private String alamat_customer;
    private String nama_customer;
    private int telepone_customer;

    public Table_customer() {
    }

    public Table_customer(String alamat_customer, String nama_customer, int telepone_customer) {
        this.alamat_customer = alamat_customer;
        this.nama_customer = nama_customer;
        this.telepone_customer = telepone_customer;
    }

    public String getAlamat_customer() {
        return alamat_customer;
    }

    public void setAlamat_customer(String alamat_customer) {
        this.alamat_customer = alamat_customer;
    }

    public String getNama_customer() {
        return nama_customer;
    }

    public void setNama_customer(String nama_customer) {
        this.nama_customer = nama_customer;
    }

    public int getTelepone_customer() {
        return telepone_customer;
    }

    public void setTelepone_customer(int telepone_customer) {
        this.telepone_customer = telepone_customer;
    }
}
