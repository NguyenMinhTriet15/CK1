package com.example.gk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class info1 extends AppCompatActivity {
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1);
        btnback = (Button) findViewById(R.id.button2);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhomepage();
            }
        });
    }

    private void openhomepage() {
        Intent it=new Intent(this, Homepage.class);
        startActivity(it);
    }
    }
