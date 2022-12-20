package com.example.gk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {
    Button btnprofile;
    Button btnlist, btnso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Anhxa1();
        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openprofile();
            }
        });
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensonglist();
            }
        });
        btnso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signout();
            }
        });
    }

    private void signout() {
        Intent myIntentt=new Intent(this, MainActivity.class);
        startActivity(myIntentt);
    }

    private void opensonglist() {
        Intent myIntent2=new Intent(this, list.class);
        startActivity(myIntent2);
    }

    private void openprofile() {
            Intent myIntent1=new Intent(this, info1.class);
            startActivity(myIntent1);
        }
    private void Anhxa1(){
        btnlist = (Button) findViewById(R.id.buttonlist);
        btnprofile = (Button) findViewById(R.id.buttonprofile);
        btnso = (Button) findViewById(R.id.btnsignout);

    }
    }

