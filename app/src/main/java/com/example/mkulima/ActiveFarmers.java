package com.example.mkulima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Array;
import java.util.ArrayList;

public class ActiveFarmers extends AppCompatActivity {

    ArrayAdapter arrayAdapter;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_farmers);
        ListView listview = findViewById(R.id.listfew);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("buyersmkulima");


    }
}
