package com.example.mkulima;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    ArrayAdapter<String>  arrayAdapter;
    EditText ed1, ed2, ed3, ed4, ed5;
    TextView textView;
    Button btnregister;
    FirebaseAuth firebaseAuth;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        firebaseAuth = FirebaseAuth.getInstance();
        ed1 = findViewById(R.id.editText9);
        ed2 = findViewById(R.id.editText8);
        ed3 = findViewById(R.id.editText7);
        ed4 = findViewById(R.id.editText5);
        ed5 = findViewById(R.id.editText6);
        textView = findViewById(R.id.textView);
        btnregister = findViewById(R.id.button2);
        if(firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent( getApplicationContext(), MainActivity.class));
            finish();
        }
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = ed1.getText().toString();
                String email = ed2.getText().toString();
                String password = ed3.getText().toString();
                String phone = ed4.getText().toString();
                String comfirm = ed5.getText().toString();
                if(email.equals("")){
                    ed1.setError("Should not be empty");
                }
                if(phone.equals("")){
                    ed1.setError("Should not be empty");
                }
                if(comfirm.equals("")){
                    ed1.setError("Should not be empty");
                }
                if(password.equals("")){
                    ed1.setError("Should not be empty");
                }
                if(uname.equals("")){
                    ed1.setError("Should not be empty");
                }
                if(password.length() <8 && comfirm.length() < 8){
                    ed4.setError("Password should be >=8/ fupi sana");
                }
                if(comfirm.equals(password)){
                    ed5.setError("Passwords mismatch/ Hakikisha umejaza panapohitajika");
                }
                else {
                    Boolean insert = db.insert(uname, email, password);
                    if (insert == true){
                        Toast.makeText(getApplicationContext(), "Register as successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Registration failed", Toast.LENGTH_LONG).show();
                    }
                }
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "You have been regitered successfully/ Asanti kwa kujisajili", Toast.LENGTH_LONG).show();
                            startActivity(new Intent( getApplicationContext(), MainActivity.class));
                        }else {
                            Toast.makeText(getApplicationContext(), "You details were not processed check your internet connection or you already exist/ Asanti kwa kujisajili", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });
    }
}
