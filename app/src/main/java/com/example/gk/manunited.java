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

public class manunited extends AppCompatActivity {
    ListView lvmanu;
    ArrayList<String> arrayCourse;
    Button add;
    EditText player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manunited);
        lvmanu = (ListView) findViewById(R.id.lvmu);
        add = (Button) findViewById(R.id.addbtn);
        player  = (EditText)findViewById(R.id.edtpl);
        arrayCourse = new ArrayList<>();
        arrayCourse.add("David de Gea (GK)");
        arrayCourse.add("Diogo Dalot");
        arrayCourse.add("Raphael Varane");
        arrayCourse.add("Lissandro Martinez");
        arrayCourse.add("Tyrell Malacia");
        arrayCourse.add("Scott Mctominay");
        arrayCourse.add("Cristian Eriksen");
        arrayCourse.add("Bruno Fernandes");
        arrayCourse.add("Atony");
        arrayCourse.add("Cristiano Ronaldo (C)");
        arrayCourse.add("Jadon Sancho");
        ArrayAdapter adapter = new ArrayAdapter(manunited.this, android.R.layout.simple_list_item_1, arrayCourse);
        lvmanu.setAdapter(adapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = player.getText().toString();
                arrayCourse.add(name);
                adapter.notifyDataSetChanged();
                Toast.makeText(manunited.this, "Player added", Toast.LENGTH_SHORT).show();
            }
        });
        lvmanu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayCourse.remove(i);
                adapter.notifyDataSetChanged();
                Toast.makeText(manunited.this, "Player deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}