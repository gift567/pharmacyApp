package com.example.pharamacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class registration extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText regmail,regpassword;
    private Button btnreg;
    private TextView txtlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);




        mAuth = FirebaseAuth.getInstance();
        regmail = findViewById(R.id.regmail);
        regpassword = findViewById(R.id.regpassword);
        btnreg = findViewById(R.id.btnreg);
        txtlogin = findViewById(R.id.txtlogin);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });

        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(registration.this,MainActivity.class));
            }
        });
    }

    private void Register() {

        String user = regmail.getText().toString().trim();
        String pass = regpassword.getText().toString().trim();
        if (user.isEmpty()){
            regmail.setError("Email cannot be empty");
        }
        if (pass.isEmpty()){
            regpassword.setError("Password cannot be Empty");
        }
        else{
            mAuth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(registration.this, "Registration Succesfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(registration.this, homepage.class));

                    }
                    else{
                        Toast.makeText(registration.this, "Registration Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }
}