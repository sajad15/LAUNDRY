package com.example.laundry;

public class Table_barang {
    private int jumlah_barang;
    private int harga;
    private String nama_barang;

    public Table_barang() {
    }

    public Table_barang(int jumlah_barang, int harga, String nama_barang) {
        this.jumlah_barang = jumlah_barang;
        this.harga = harga;
        this.nama_barang = nama_barang;
    }

    public int getJumlah_barang() {
        return jumlah_barang;
    }

    public void setJumlah_barang(int jumlah_barang) {
        this.jumlah_barang = jumlah_barang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }
}

