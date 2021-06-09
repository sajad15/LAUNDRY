package com.example.laundry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.laundry.common.common;
import com.example.laundry.model.table_user;
import com.google.android.gms.common.UserRecoverableException;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;

import io.paperdb.Paper;

public class Daftar extends AppCompatActivity {
    Button daftar;
    EditText Edtnama, Edtemail, Edttelepone, Edtpassword;
    FirebaseDatabase firebaseDatabase;
    private DatabaseReference user;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        daftar = findViewById(R.id.Btn_Daftar);
        Edtnama = findViewById(R.id.Edt_nama);
        Edtemail = findViewById(R.id.Edt_nama);
        Edttelepone = findViewById(R.id.Edttelepone);
        Edtpassword = findViewById(R.id.Edttelepone);
        progressBar = findViewById(R.id.progress_activity_signup);

                daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = FirebaseDatabase.getInstance().getReference("table_user");
                user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(Edtnama.getText().toString().isEmpty() || Edtpassword.getText().toString().isEmpty() || Edttelepone.getText().toString().isEmpty()) {
                            Toast.makeText(Daftar.this, "Field tidak boleh kosong", Toast.LENGTH_SHORT).show();
                        }else{
                            table_user table_user = new table_user(Edtnama.getText().toString(), Edtemail.getText().toString(), Edttelepone.getText().toString(), Edtpassword.getText().toString());
                            user.child(Edtemail.getText().toString()).setValue(table_user);
                            Toast.makeText(Daftar.this, "Register Berhasil", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Daftar.this, Login.class));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    private void FirebaseDatabase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        user = FirebaseDatabase.getInstance().getReference();


    }

    private void signup(final String nama, final String telepone, final String email, final String password) {
            if (TextUtils.isEmpty(nama)) {
                Toast.makeText(this, "Nama belum anda masukan", Toast.LENGTH_SHORT).show();

            } else if (TextUtils.isEmpty(telepone)) {
                Toast.makeText(this, "Nomor telepone anda masukan", Toast.LENGTH_SHORT).show();

            } else if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Email anda harus masukan", Toast.LENGTH_SHORT).show();

            } else if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "password anda harus masukan", Toast.LENGTH_SHORT).show();
            } else {
                showProgress();
            }

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Daftar.this);

            alertDialogBuilder.setTitle("Signup");

            alertDialogBuilder.setMessage("your account has been registered. please sign in use your username and password");
            alertDialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    finish();
                }
            });
            alertDialogBuilder.show();
    }

    // signup fail

    private void hideProgress() {
         progressBar.setVisibility(View.INVISIBLE);
    }
    private void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
        }
    }
















