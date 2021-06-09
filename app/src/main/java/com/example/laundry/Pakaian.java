package com.example.laundry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.RemoteAction;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.laundry.common.common;
import com.example.laundry.model.table_pakaian;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import io.paperdb.Paper;

public class Pakaian extends AppCompatActivity {

    int Harga_Total, Total_pakaian, Harga_celanapendek, Harga_celanapanjang, Harga_celanajeans, Harga_Selimuttipis, Harga_kebayapanjang, Harga_kemeja, Harga_handukbesar, Harga_handukkecil, Harga_Bedcoverbesar, Harga_Bedcoverkecil;
    String tanggal, lokasi, jam, catatan, nama, telp, email;
    int jmlh_celanapendek =0, jmlh_celanapanjang =0, jmlh_celanajeans =0, jmlh_Selimuttipis =0, jmlh_kebayapanjang =0, jmlh_handukbesar =0, jmlh_handukkecil =0, jmlh_Bedcoverbesar =0, jmlh_Bedcoverkecil =0, jmlh_kemeja =0;
    TextView Total_Harga, celanapendek, celanapanjang, celanajeans, selimuttipis, kebayapanjang, kemeja, handukbesar, handukkecil, bedcoverbesar, bedcoverkecil;
    Button konfimasi;
    Button Btn_proses, pcelanapendek, mcelanapendek, pcelanapanjang, micelanapanjang, pcelanajeans, mcelanajeans, pselimuttipis, mselimuttipis, pkebayapanjang, mkebayapanjang, pkemeja, mkemeja, phandukbesar, mhandukbesar, phandukkecil, mhandukkecil,  pbedcoverbesar, mbedcoverbesar, pbedcoverkecil, mbedcoverkecil;
    private DatabaseReference firebaseDatabase;
    private DatabaseReference databaseReference;
    private String user, jumlah_pakaian, jumlah_harga;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pakaian);
        Paper.init(this);
        Total_Harga = findViewById(R.id.Total);
        celanapendek = findViewById(R.id.total_celana_pendek);
        celanapanjang = findViewById(R.id.total_celana_panjang);
        celanajeans = findViewById(R.id.total_celana_jeans);
        selimuttipis = findViewById(R.id.total_selimuttipis);
        kebayapanjang = findViewById(R.id.total_kebaya_panjang);
        kemeja = findViewById(R.id.Total_Kemeja);
        handukbesar = findViewById(R.id.total_HandukBesar);
        handukkecil = findViewById(R.id.Total_Handukkecil);
        bedcoverbesar = findViewById(R.id.total_bed_cover_besar);
        bedcoverkecil = findViewById(R.id.total_bed_cover_kecil);

        pcelanapanjang = findViewById(R.id.plus_celana_panjang);
        micelanapanjang= findViewById(R.id.minus_celana_panjang);
        pcelanapendek = findViewById(R.id.plus_celana_pendek);
        mcelanapendek = findViewById(R.id.minus_celana_pendek);
        pcelanajeans = findViewById(R.id.plus_celana_jeans);
        mcelanajeans = findViewById(R.id.minus_celana_jeans);
        pselimuttipis = findViewById(R.id.plus_selimuttipis);
        mselimuttipis = findViewById(R.id.minus_selimuttipis);
        pkebayapanjang = findViewById(R.id.plus_kebayapanjang);
        mkebayapanjang = findViewById(R.id.minus_kebaya_panjang);
        pkemeja = findViewById(R.id.Plus_Kemeja);
        mkemeja = findViewById(R.id.minus_kemeja);
        pbedcoverbesar = findViewById(R.id.plus_bed_cover_besar);
        pbedcoverkecil = findViewById(R.id.plus_bed_cover_kecil);
        mbedcoverkecil = findViewById(R.id.minus_bed_cover_kecil);
        mbedcoverbesar= findViewById(R.id.minus_bed_cover_besar);
        phandukbesar = findViewById(R.id.plus_HandukBesar);
        mhandukbesar = findViewById(R.id.minus_Handuk_Besar);
        phandukkecil = findViewById(R.id.plus_handukkecil);
        mhandukkecil = findViewById(R.id.minus_handuk_kecil);

        Btn_proses = findViewById(R.id.proses);
        email = Paper.book().read(common.user_name);

        jumlah_harga = String.valueOf(Harga_Total);
        jumlah_pakaian = String.valueOf(Total_pakaian);
        konfimasi = findViewById(R.id.proses);


        //Get FirebaseDatabase instance

        pcelanapanjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              jmlh_celanapanjang += 1;
              celanapanjang.setText(String.valueOf(jmlh_celanapanjang));
              harga();
            }
        });
        pcelanapendek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jmlh_celanapendek +=1;
                celanapendek.setText(String.valueOf(jmlh_celanapendek));
                harga();
            }
        });

        pcelanajeans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jmlh_celanajeans +=1;
                celanajeans.setText(String.valueOf(jmlh_celanajeans));
                harga();
            }
        });

        pselimuttipis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jmlh_Selimuttipis +=1;
                selimuttipis.setText(String.valueOf(jmlh_Selimuttipis));
            }
        });

        pkebayapanjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jmlh_kebayapanjang +=1;
                kebayapanjang.setText(String.valueOf(jmlh_kebayapanjang));
                harga();
            }
        });

        pkemeja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jmlh_kemeja +=1;
                kemeja.setText(String.valueOf(jmlh_kemeja));
                harga();
            }
        });

        phandukbesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jmlh_handukbesar +=1;
                handukbesar.setText(String.valueOf(jmlh_handukbesar));
                harga();
            }
        });

        phandukkecil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jmlh_handukkecil +=1;
                handukkecil.setText(String.valueOf(jmlh_handukkecil));
                harga();
            }
        });

        pbedcoverbesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jmlh_Bedcoverbesar +=1;
                bedcoverbesar.setText(String.valueOf(jmlh_Bedcoverbesar));
                harga();
            }
        });

        pbedcoverkecil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jmlh_Bedcoverkecil +=1;
                bedcoverkecil.setText(String.valueOf(jmlh_Bedcoverkecil));
                harga();
            }
        });
        micelanapanjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(celanapanjang.getText().toString())>=0) {
                    jmlh_celanapanjang = jmlh_celanapanjang - 1;
                    celanapanjang.setText(String.valueOf(jmlh_celanapanjang));
                    harga();
                }
            }
        });
        mcelanapendek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(celanapendek.getText().toString())>=0) {
                    jmlh_celanapendek = jmlh_celanapendek - 1;
                    celanapendek.setText(String.valueOf(jmlh_celanapendek));
                    harga();
                }
            }
        });

        mcelanajeans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(celanajeans.getText().toString())>=0) {
                    jmlh_celanajeans = jmlh_celanajeans - 1;
                    celanajeans.setText(String.valueOf(jmlh_celanajeans));
                    harga();
                }
            }
        });

        mselimuttipis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(selimuttipis.getText().toString())>=0) {
                    jmlh_Selimuttipis = jmlh_Selimuttipis - 1;
                    selimuttipis.setText(String.valueOf(jmlh_Selimuttipis));
                    harga();
                }
            }
        });

        mkemeja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(kemeja.getText().toString())>=0) {
                    jmlh_kemeja = jmlh_kemeja - 1;
                    kemeja.setText(String.valueOf(jmlh_kemeja));
                    harga();
                }
            }
        });

        mhandukkecil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(handukkecil.getText().toString())>=0) {
                    jmlh_handukkecil = jmlh_handukkecil - 1;
                    handukkecil.setText(String.valueOf(jmlh_handukkecil));
                    harga();
                }
            }
        });

        mhandukbesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(handukbesar.getText().toString())>=0) {
                    jmlh_handukbesar = jmlh_handukbesar - 1;
                    handukbesar.setText(String.valueOf(jmlh_handukbesar));
                    harga();
                }
            }
        });

        mkebayapanjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(kebayapanjang.getText().toString())>=0) {
                    jmlh_kebayapanjang = jmlh_kebayapanjang - 1;
                    kebayapanjang.setText(String.valueOf(jmlh_kebayapanjang));
                    harga();
                }
            }
        });

        mbedcoverkecil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(bedcoverkecil.getText().toString())>=0) {
                    jmlh_Bedcoverkecil = jmlh_Bedcoverkecil - 1;
                    bedcoverkecil.setText(String.valueOf(jmlh_Bedcoverkecil));
                    harga();
                }
            }
        });

        mbedcoverbesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(bedcoverbesar.getText().toString())>=0) {
                    jmlh_Bedcoverbesar = jmlh_Bedcoverbesar - 1;
                    bedcoverbesar.setText(String.valueOf(jmlh_Bedcoverbesar));
                    harga();
                }
            }
        });
        konfimasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Pakaian.this);
                alertDialogBuilder.setMessage("apakah semua data sudah benar");

                alertDialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        dialogInterface.dismiss();

                        Intent konfirmasi = new Intent(Pakaian.this, Konfirmasi.class);
                        startActivity(konfirmasi);
                    }
                });

                alertDialogBuilder.setNegativeButton("batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                alertDialogBuilder.show();
            }
        });

        Btn_proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proses = new Intent(Pakaian.this, Riwayat.class);
                startActivity(proses);
            }
        });
    }

    private void harga() {
        firebaseDatabase = FirebaseDatabase.getInstance().getReference("table_Pakaian");
        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                table_pakaian cpanjang = dataSnapshot.child("CelanaPanjang").getValue(com.example.laundry.model.table_pakaian.class);
                table_pakaian cpendek = dataSnapshot.child("CelanaPendek").getValue(com.example.laundry.model.table_pakaian.class);
                table_pakaian cjeans = dataSnapshot.child("Celanajeans").getValue(com.example.laundry.model.table_pakaian.class);
                table_pakaian stipis = dataSnapshot.child("selimutTipis").getValue(com.example.laundry.model.table_pakaian.class);
                table_pakaian kpanjang = dataSnapshot.child("KebayaPanjang").getValue(com.example.laundry.model.table_pakaian.class);
                table_pakaian kemejas = dataSnapshot.child("Kemeja").getValue(com.example.laundry.model.table_pakaian.class);
                table_pakaian hbesar = dataSnapshot.child("HandukBesar").getValue(com.example.laundry.model.table_pakaian.class);
                table_pakaian hkecil = dataSnapshot.child("HandukKecil").getValue(com.example.laundry.model.table_pakaian.class);
                table_pakaian bcbesar = dataSnapshot.child("BedCoverBesar").getValue(com.example.laundry.model.table_pakaian.class);
                table_pakaian bckecil = dataSnapshot.child("BedCoverKecil").getValue(com.example.laundry.model.table_pakaian.class);
                Harga_celanapanjang = (Integer.parseInt(celanapanjang.getText().toString())*cpanjang.getHarga());
                Harga_celanapendek = (Integer.parseInt(celanapendek.getText().toString())*cpendek.getHarga());
                Harga_celanajeans = (Integer.parseInt(celanajeans.getText().toString())*cjeans.getHarga());
                Harga_Selimuttipis = (Integer.parseInt(selimuttipis.getText().toString())*stipis.getHarga());
                Harga_kebayapanjang = (Integer.parseInt(kebayapanjang.getText().toString())*kpanjang.getHarga());
                Harga_kemeja = (Integer.parseInt(kemeja.getText().toString())*kemejas.getHarga());
                Harga_handukbesar = (Integer.parseInt(handukbesar.getText().toString())*hbesar.getHarga());
                Harga_handukkecil = (Integer.parseInt(handukkecil.getText().toString())*hkecil.getHarga());
                Harga_Bedcoverbesar = (Integer.parseInt(bedcoverbesar.getText().toString())*bcbesar.getHarga());
                Harga_Bedcoverkecil = (Integer.parseInt(bedcoverkecil.getText().toString())*bckecil.getHarga());

                Harga_Total = Harga_celanapanjang + Harga_celanapendek + Harga_celanajeans + Harga_Selimuttipis +
                        Harga_kebayapanjang + Harga_kemeja + Harga_handukbesar +
                        Harga_handukkecil + Harga_Bedcoverbesar + Harga_Bedcoverkecil;
                Total_Harga.setText(String.valueOf(Harga_Total));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

