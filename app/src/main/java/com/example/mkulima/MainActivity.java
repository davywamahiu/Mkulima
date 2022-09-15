package com.example.mkulima;

import android.os.Bundle;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.content.Intent;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] market = new String[] {"See Available Farmers", "See Potential Buyers", "See farmers Interested in selling to you", "See Buyers Interested in Buying from you","Farmers selling to you currently", "Buyers Buying from you currently", "Get Loans for business", "Get seeds at a subsidized price","Mkulima Information Center"};
    private  String[] mkt = new String[] {"Stat", "Question", "Paper", "Credit"};
    ArrayAdapter<String>  arrayAdapter;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ListView listview = findViewById(R.id.lstView);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, market);
        db = new DatabaseHelper(this);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                String product = ((TextView) view).getText().toString();
                Intent intent1;
                switch (position){
                    case 0:
                    intent1 = new Intent(getApplicationContext(), FarmerAvailable.class);
                    intent1.putExtra("product", product);
                    startActivity(intent1);
                    break;
                    case 1:
                        intent1 = new Intent(getApplicationContext(), PotentialFarmer.class);
                        intent1.putExtra("product", product);
                        startActivity(intent1);
                        break;
                    case 2:
                        intent1 = new Intent(getApplicationContext(), ActiveFarmers.class);

                        intent1.putExtra("product", product);
                        startActivity(intent1);
                        break;
                    case 3:
                        intent1 = new Intent(getApplicationContext(), AvailableBuyers.class);
                        intent1.putExtra("product", product);
                        startActivity(intent1);
                        break;
                    case 4:
                        intent1 = new Intent(getApplicationContext(), PotentialBuyers.class);
                        intent1.putExtra("product", product);
                        startActivity(intent1);
                        break;
                    case 5:
                        intent1 = new Intent(getApplicationContext(), ActiveBuyers.class);
                        intent1.putExtra("product", product);
                        startActivity(intent1);
                        break;
                    case 6:
                        intent1 = new Intent(getApplicationContext(), GetLoans.class);
                        intent1.putExtra("product", product);
                        startActivity(intent1);
                        break;
                    case 7:
                        intent1 = new Intent(getApplicationContext(), GetSeeds.class);
                        intent1.putExtra("product", product);
                        startActivity(intent1);
                        break;
                    case 8:
                        intent1 = new Intent(getApplicationContext(), InfoMkulima.class);
                        intent1.putExtra("product", product);
                        startActivity(intent1);
                        break;
                }
            }

        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pelekea Nyakundi Jonhte", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(getApplicationContext(), Settings.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_login) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_signup) {
            Intent intent = new Intent(getApplicationContext(), Register.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_enroll) {
            Intent intent = new Intent(getApplicationContext(), ViewMe.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_about) {
            Intent intent = new Intent(getApplicationContext(), About.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class Mwananchi {
        @NonNull
        @Override
        public String toString() {
            return super.toString();
        }
    }
}
