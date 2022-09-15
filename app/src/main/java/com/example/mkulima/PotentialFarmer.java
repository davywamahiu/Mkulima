package com.example.mkulima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PotentialFarmer extends AppCompatActivity {
    ArrayAdapter arrayAdapter;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potential_farmer);
        TextView txtshow = findViewById(R.id.txtshow);
        Intent i = getIntent();
        String product = i.getStringExtra("product");
        txtshow.setText(product);
    }
}
