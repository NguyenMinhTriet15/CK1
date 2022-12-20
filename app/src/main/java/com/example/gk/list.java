package com.example.gk;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class list extends AppCompatActivity {
    int vitri = -1;
    ListView lvclb;
    ArrayList<Club> arrayclub;
    Adapter clubadapter;
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goback();
            }
        });
        clubadapter = new Adapter(this, R.layout.dong, arrayclub);
        lvclb.setAdapter(clubadapter);
        lvclb.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayclub.remove(i);
                clubadapter.notifyDataSetChanged();
                Toast.makeText(list.this, "Item deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        lvclb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if (i==0)
                    {
                        showreal();
                    }
                    if (i==1)
                    {
                        showmanu();
                    }
                    if (i==2)
                    {
                        showmc();

                    }
            }
        });
    }

    private void showmc() {

        Intent it1 = new Intent(this, mancity.class);
        startActivity(it1);
    }

    private void showmanu() {

        Intent i1 = new Intent(this, manunited.class);
        startActivity(i1);
    }

    private void goback() {

        Intent itt = new Intent(this, Homepage.class);
        startActivity(itt);
    }

    private void showreal() {
        Intent it = new Intent(this, realmadrid.class);
        startActivity(it);
    }


    private void Anhxa() {
        lvclb = (ListView) findViewById(R.id.lvclub);
        arrayclub = new ArrayList<>();
        arrayclub.add(new Club("Real Madrid","Coach: Carlo Ancelotti", R.drawable.real));
        arrayclub.add(new Club("Manchester United", "Coach: Erik ten Hag", R.drawable.mu));
        arrayclub.add(new Club("Manchester City","Coach: Pep Guardiola", R.drawable.mc));
        arrayclub.add(new Club("Paris Saint German", "Coach: Mauricio Pochettino", R.drawable.psg));
        btnback = (Button) findViewById(R.id.backk);
    }

}