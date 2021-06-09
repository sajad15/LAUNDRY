package com.example.laundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Map;

public class Home extends AppCompatActivity {
    private LinearLayout btncuci,akun,riwayat,map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btncuci= findViewById(R.id.cuci);
        akun = findViewById(R.id.Akun);
        riwayat = findViewById(R.id.riwayat);
        map = findViewById(R.id.Maps);

       btncuci.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent cuci = new Intent(Home.this, Tanggal_pesanan.class);

               startActivity(cuci);
           }
       });
        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent akun = new Intent(Home.this, Login.class);

                startActivity(akun);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map = new Intent(Home.this, Map.class);
                startActivity(map);
            }
        });

        riwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent riwayat = new Intent(Home.this, Riwayat.class);
                startActivity(riwayat);
            }
        });
    }
    public void onBackPressed() {
    }
}
