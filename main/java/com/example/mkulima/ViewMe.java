package com.example.mkulima;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class ViewMe extends AppCompatActivity {
    EditText fname, lname, phonenumber, category, county, selling, uzaji, kununua, email;
    Button btnEnroll;
    FirebaseDatabase database;
    Buyersmkulima buyersmkulima;
    DatabaseReference databaseReference;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_me);
        fname = (EditText) findViewById(R.id.editText);
        lname = findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText11);
        selling = findViewById(R.id.selling);
        category = findViewById(R.id.category);
        county = findViewById(R.id.editText12);
        uzaji = findViewById(R.id.editText4);
        kununua = findViewById(R.id.editText10);
        phonenumber = findViewById(R.id.editText3);
        databaseReference = FirebaseDatabase.getInstance("https://mkulima-1e15b.firebaseio.com/").getReference("mkulima15");
        db = new DatabaseHelper(this);

        btnEnroll = findViewById(R.id.button5);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                databaseReference.child("Buyersmkulimna").push().setValue(buyersmkulima);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        btnEnroll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String firstname1 = fname.getText().toString();
                String email1 = email.getText().toString();
                String phone1 = phonenumber.getText().toString();
                String lastname1 = lname.getText().toString();
                String category1 = category.getText().toString();
                String uuzaji1 = uzaji.getText().toString();
                String county1 = county.getText().toString();
                String kununua1 = kununua.getText().toString();
                String selling1 = selling.getText().toString();
                if(firstname1.equals("")){
                    fname.setError("Can not be empty", null);
                }
                    if(lastname1.equals("")){
                        lname.setError("Can not be empty", null);
                    }
                    if(phone1.equals("")){
                        phonenumber.setError("Can not be empty", null);
                    }
                    if(email1.equals("")){
                        email.setError("Can not be empty", null);
                    }
                    if(category1.equals("")){
                        category.setError("Can not be empty", null);
                    }
                    if (uuzaji1.equals("")){
                        uzaji.setError("Can not be empty", null);
                    }
                    if(county1.equals("")){
                        county.setError("Can not be empty", null);
                    }
                        if(kununua1.equals("")){
                            kununua.setError("Can not be empty", null);
                        }
                            if (selling1.equals("")){
                                selling.setError("Can not be empty", null);
                            }
                            else{
                                createUser(firstname1, lastname1, email1, phone1, county1, category1, uuzaji1, kununua1, selling1);
                            }


            }
        });
    }



    private void createUser(String firstname, String lastname, String email, String phone, String county, String category, String uuzaji, String kununua, String selling) {
        // TODO
        // In real apps this "Buyersmkulimna should be fetched
        // by implementing firebase auth

        Buyersmkulima buyersmkulima = new Buyersmkulima(firstname, lastname, email, phone, county, category, uuzaji, kununua, selling);

        databaseReference.child("Buyersmkulimna").push().setValue(buyersmkulima);

        addUserChangeListener();
    }
    private void addUserChangeListener() {
        // User data change listener
        databaseReference.child("Buyersmkulimna").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Buyersmkulima buyersmkulima = dataSnapshot.getValue(Buyersmkulima.class);

                // Check for null
                if (buyersmkulima == null) {
                    return;
                }

                // Display newly updated name and email

                // clear edit text
                fname.setText("");
                email.setText("");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }
    private void getBuyersmkulima(){
        buyersmkulima = new Buyersmkulima() {

        };
    }
}
