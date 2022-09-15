package com.example.mkulima;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText ed4, ed5, ed6;
    Button btnlogin;
    TextView txtView;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        ed4 = findViewById(R.id.editText8);
        ed5 = findViewById(R.id.editText7);
        ed6 = findViewById(R.id.editText5);
        btnlogin = findViewById(R.id.button2);
        txtView = findViewById(R.id.textView);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ed4.getText().toString().trim();
                String password = ed6.getText().toString().trim();
                String phone = ed5.getText().toString().trim();
                if(email.equals("")){
                    ed4.setError("Email field is empty/ Hakikisha umejaza panapohitajika!");
                    return;
                }
                if(phone.equals("")){
                    ed4.setError("Email field is empty/ Hakikisha umejaza panapohitajika!");
                    return;
                }
                if(password.equals("")){
                    ed4.setError("Password field is empty/ Hakikisha umejaza panapohitajika!");
                    return;
                }

                if(password.length() < 8){
                    ed5.setError("Password is too short/ Password ni fupi sana!");
                    return;
                }
                else {
                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
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
                progressBar.setVisibility(View.VISIBLE);

            }
        });
        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });
    }
}
