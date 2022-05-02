package com.example.pharamacy.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.pharamacy.MainActivity;
import com.example.pharamacy.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class homepage extends AppCompatActivity {



    RecyclerView featuredRecycler;
    private FirebaseAuth mAuth;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);




mAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }


            public void onStart(){
                homepage.super.onStart();
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser==null){
                    startActivity(new Intent(homepage.this, MainActivity.class));
                }
            }
            public void logout() {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent( homepage.this,MainActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }
}