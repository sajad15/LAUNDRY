package com.example.laundry.model;

public class table_pakaian {
    private String Nama_barang;
    private int Harga;
    private int Jumlah_barang;
    private int Total;

    public table_pakaian() {
    }

    public table_pakaian(String nama_barang, int harga, int jumlah_barang, int total) {
        Nama_barang = nama_barang;
        Harga = harga;
        Jumlah_barang = jumlah_barang;
        Total = total;
    }

    public String getNama_barang() {
        return Nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        Nama_barang = nama_barang;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int harga) {
        Harga = harga;
    }

    public int getJumlah_barang() {
        return Jumlah_barang;
    }

    public void setJumlah_barang(int jumlah_barang) {
        Jumlah_barang = jumlah_barang;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }
}
