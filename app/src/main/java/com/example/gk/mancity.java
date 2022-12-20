package com.example.gk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class mancity extends AppCompatActivity {

    ListView lvmanc;
    ArrayList<String> arrayCourse;
    Button add;
    EditText edtadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mancity);
        lvmanc = (ListView) findViewById(R.id.lvmc);
        add = (Button) findViewById(R.id.btnadd);
        edtadd  = (EditText)findViewById(R.id.edtplayer);
        arrayCourse = new ArrayList<>();
        arrayCourse.add("Ederson Moraes (GK)");
        arrayCourse.add("Joao Cancelo");
        arrayCourse.add("John Stones");
        arrayCourse.add("Aymeric Larpote");
        arrayCourse.add("Kyle Walker");
        arrayCourse.add("Rodrigo Hernandez Cascante");
        arrayCourse.add("Ikay Gundogan");
        arrayCourse.add("Kevin De Bruyne (C)");
        arrayCourse.add("Jack Grealish");
        arrayCourse.add("Erling Haaland");
        arrayCourse.add("Riyad Mahrez");
        ArrayAdapter adapter = new ArrayAdapter(mancity.this, android.R.layout.simple_list_item_1, arrayCourse);
        lvmanc.setAdapter(adapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =edtadd.getText().toString();
                arrayCourse.add(name);
                adapter.notifyDataSetChanged();
                Toast.makeText(mancity.this, "Player added", Toast.LENGTH_SHORT).show();
            }
        });
        lvmanc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayCourse.remove(i);
                adapter.notifyDataSetChanged();
                Toast.makeText(mancity.this, "Player deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}