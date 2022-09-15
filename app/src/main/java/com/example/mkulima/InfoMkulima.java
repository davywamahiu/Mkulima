package com.example.mkulima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class InfoMkulima extends AppCompatActivity {
    ArrayAdapter arrayAdapter;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_mkulima);
        TextView txtshow = findViewById(R.id.txtshow);
        Intent i = getIntent();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("buyersmkulima");
        String product = i.getStringExtra("product");
        txtshow.setText(product);
    }
}
