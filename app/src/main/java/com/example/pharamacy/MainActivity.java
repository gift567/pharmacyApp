package com.example.pharamacy;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pharamacy.views.homepage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends android.app.Activity {

 private FirebaseAuth mAuth;
 private EditText mail,password;
 private Button btn;
 private TextView newreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        mAuth = FirebaseAuth.getInstance();
        mail = findViewById(R.id.mail);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.btn);
        newreg = findViewById(R.id.newreg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        newreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,registration.class));
            }
        });
    }


    private void login() {

        String user = mail.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if (user.isEmpty()){
            mail.setError("Email cannot be empty");
        }
        if (pass.isEmpty()){
            password.setError("Password cannot be Empty");
        }
        else {
            mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Login Succesfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, homepage.class));
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Login Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

}