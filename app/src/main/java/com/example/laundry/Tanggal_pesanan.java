package com.example.laundry;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.UpdateLayout;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Tanggal_pesanan extends AppCompatActivity {
    TextView Txt_tempat, Txt_jam_informasi, Txt_ctt;
    String jam, tanggal, catatan, toastMsg, Tempat;
    Button Btn_next;
    Button next;
    Calendar mycalendar;
    EditText Edt_tanggal_order, Edt_catatan_order, Edt_jam_order;
    ImageView Img_addlokasi;
    Locale id;
    private final static int PlacePicker = 1;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanggal_pesanan);

        Img_addlokasi = findViewById(R.id.imageView);
        Btn_next = findViewById(R.id.Btn_next);
        Txt_tempat = findViewById(R.id.text_tempat);
        Txt_jam_informasi = findViewById(R.id.Edt_jam_order);
        Txt_ctt = findViewById(R.id.Edt_catatan_order);
        Edt_tanggal_order = findViewById(R.id.Edt_tgl_order);
        Edt_jam_order = findViewById(R.id.Edt_jam_order);
        Edt_catatan_order = findViewById(R.id.Edt_catatan_order);
        next = findViewById(R.id.Btn_next);

        Calendar calendar = Calendar.getInstance();
         int month = calendar.get(Calendar.MONTH)+1;
         final String dates = calendar.get(Calendar.DAY_OF_MONTH)+"-"+month+"-"+calendar.get(Calendar.YEAR);

         final String Time = calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE);

         Edt_tanggal_order.setText(dates);
         Edt_jam_order.setText(Time);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Tanggal_pesanan.this, Pakaian.class));
            }
        });
        }


    }
//       Img_addlokasi.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view)

