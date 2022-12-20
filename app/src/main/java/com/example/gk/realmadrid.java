package com.example.gk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class realmadrid extends AppCompatActivity {
    ListView lvreal;
    ArrayList<String> arrayCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realmadrid);
        Button btnback = (Button) findViewById(R.id.back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goback();
            }
        });
        lvreal = (ListView) findViewById(R.id.lvrm);
        arrayCourse = new ArrayList<>();
        arrayCourse.add("Thibaut Courtois (GK)");
        arrayCourse.add("Dani Carvajal");
        arrayCourse.add("Eder Militao");
        arrayCourse.add("Antonio Rudiger");
        arrayCourse.add("Ferland Mendy");
        arrayCourse.add("Aurelien Tchouameni");
        arrayCourse.add("Luka Modric");
        arrayCourse.add("Toni Kroos");
        arrayCourse.add("Vinicius Jr");
        arrayCourse.add("Karim Benzema (C)");
        arrayCourse.add("Rodrygo");
        ArrayAdapter adapter = new ArrayAdapter(realmadrid.this, android.R.layout.simple_list_item_1, arrayCourse);
        lvreal.setAdapter(adapter);
        lvreal.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            arrayCourse.remove(i);
            adapter.notifyDataSetChanged();
                Toast.makeText(realmadrid.this, "Player deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void goback() {
        Intent it = new Intent(this, list.class);
        startActivity(it);
    }
}