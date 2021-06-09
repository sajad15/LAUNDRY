package com.example.laundry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.laundry.common.common;
import com.example.laundry.model.table_user;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import io.paperdb.Paper;
import static com.example.laundry.R.id.input_email;
import static com.example.laundry.R.id.progress_activity_signup;


public class Login extends AppCompatActivity {
    Button Login;
    Button btn_login;
    EditText inputemail, inputpassword;
    TextView daftar;
    RelativeLayout relativeLayoutProgress;
    private DatabaseReference User;
    private Task task;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login = findViewById(R.id.Btn_Login);
        daftar = findViewById(R.id.text_daftar);
        inputemail = findViewById(R.id.input_email);
        inputpassword = findViewById(R.id.input_password);
        btn_login = findViewById(R.id.proses);
        progressBar = findViewById(progress_activity_signup);

       //Get FirebaseDatabase instance

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User = FirebaseDatabase.getInstance().getReference("table_user");
                User.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(inputemail.getText().toString()).exists()){
                            table_user table_user = dataSnapshot.child(inputemail.getText().toString()).getValue(table_user.class);

                            if(table_user.getPassword().equals(inputpassword.getText().toString())){
                                startActivity(new Intent(Login.this, Home.class));
                                Paper.book().write(common.user_name,inputemail.getText().toString());
                            }else{
                                Toast.makeText(Login.this,"Password Salah!!!", Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(Login.this, "Username tidak terdaftar.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent daftar = new Intent(Login.this, Daftar.class);
                startActivity(daftar);
            }
        });

    }
    private void goToDashboard() {
        Intent dashboard = new Intent(this, Home.class);
        startActivity(dashboard);
    }

    private void Login(final String username, String password) {
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Email Anda Belum di isi", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Password anda belum di isi", Toast.LENGTH_SHORT).show();
        } else {
            Log.d("test", "outcome = " + username + password);
            // do login
            showProgress();

            hideProgress();
            if (task.isSuccessful()) {
                // login sucess
                // go to dashboard
            } else {
                // login failed
                showMessageBox("Login failed. your username and password is not matched");
            }
            goToDashboard();
        }
    }
    private void showMessageBox(String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Login");
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialogBuilder.show();

    }
    private void hideProgress() {
        relativeLayoutProgress.setVisibility(View.VISIBLE);
        inputemail.setEnabled(true);
        inputpassword.setEnabled(true);
    }
    private  void showProgress() {
        relativeLayoutProgress.setVisibility(View.VISIBLE);
        inputemail.setEnabled(false);
        inputemail.setEnabled(false);
    }
    public boolean isLoggedIn() {
        if (FirebaseDatabase.getInstance() != null) {
            // user logged in
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void onBackPressed() {

    }

}

