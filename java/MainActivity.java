package com.example.akei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button bt_listeRayonEmploye;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //obtenir le button
        bt_listeRayonEmploye = findViewById(R.id.bt_listeRayonEmploye);
        //créer l'intent d'acces
        Intent listeDeRayonsEmployes = new Intent(this, activityListeprincipaleRayonemployeActivity.class);
        bt_listeRayonEmploye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(listeDeRayonsEmployes);
            }
        });


        //créer les DAO
        EmployeDAO employeAccces = new EmployeDAO(this);
        MagasinDAO magasinAccces = new MagasinDAO(this);
        Log.d("TestBD",magasinAccces.getMagasin(1).toString());
    }
}