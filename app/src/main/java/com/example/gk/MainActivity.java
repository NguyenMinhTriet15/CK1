package com.example.gk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button btnxacnhan, btnsu;
    EditText edtusername, edtpassword;
    FirebaseAuth mauth;
    CheckBox cbrmb;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvitylogin);
        Anhxa();
        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        btnsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensu();
            }
        });
    }

    private void login() {
        String emailed, passed;
        emailed = edtusername.getText().toString();
        passed = edtpassword.getText().toString();
        if(TextUtils.isEmpty(emailed)){
            Toast.makeText(this, "Nhap Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(passed)){
            Toast.makeText(this, "Nhap Password",Toast.LENGTH_SHORT).show();
            return;
        }
        mauth.signInWithEmailAndPassword(emailed,passed).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Intent intent = new Intent(MainActivity.this, Homepage.class);
                    startActivity(intent);
                    if(cbrmb.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email", emailed);
                        editor.putString("password", passed);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Sai tai khoan hoac mat khau", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void opensu() {
        Intent it=new Intent(this, signupactv.class);
        startActivity(it);
    }

    private  void Anhxa(){
        btnxacnhan = (Button) findViewById(R.id.button);
        edtpassword = (EditText) findViewById(R.id.edtpass);
        edtusername = (EditText) findViewById(R.id.edtuser);
        mauth = FirebaseAuth.getInstance();
        btnsu = (Button) findViewById(R.id.btnsup);
        cbrmb = (CheckBox) findViewById(R.id.rmb);
        sharedPreferences = getSharedPreferences("datalogin", MODE_PRIVATE);
        edtusername.setText(sharedPreferences.getString("email",""));
        edtpassword.setText(sharedPreferences.getString("password",""));
        cbrmb.setChecked(sharedPreferences.getBoolean("Checked", false));
    }
}