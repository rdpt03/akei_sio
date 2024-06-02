package com.example.akei;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class activityCaracteristiquesEmployeActivity extends AppCompatActivity {

    EmployeDAO employeAcess;
    RayonDAO rayonAcess;
    MagasinDAO magasinAcess;
    Employe employe;
    TextView et_nomEmploye,et_prenomEmploye,et_idEmploye,et_rayon,et_magasin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristiques_employe);
        //find champs de textView
        et_nomEmploye = findViewById(R.id.et_nomEmployee);
        et_prenomEmploye = findViewById(R.id.et_prenomEmploye);
        et_idEmploye = findViewById(R.id.et_idEmploye);
        et_rayon = findViewById(R.id.et_rayon);
        et_magasin = findViewById(R.id.et_magasin);

        //get intent
        Intent intent = getIntent();
        //get id eployee
        long idEmploye=intent.getLongExtra("idEmploye",0);
        //get dao
        employeAcess = new EmployeDAO(this);
        rayonAcess = new RayonDAO(this);
        magasinAcess = new MagasinDAO(this);
        //get employe objet
        employe = employeAcess.getEmploye(idEmploye);
        Log.d("APP-LOG","ID QUE JSP PQ EST NUL : "+employe.getIdRayon());



        //SET LE TEXT
        et_nomEmploye.setText("Nom : " + employe.getNomEmploye());
        et_prenomEmploye.setText("Prenom : " + employe.getPrenomEmploye());
        et_idEmploye.setText("ID : " + employe.getIdEmploye());
        et_rayon.setText("Rayon : " + rayonAcess.getRayon(employe.getIdRayon()).getNomRayon());
        et_magasin.setText("Magasin : " + magasinAcess.getMagasin(employe.getIdMagasin()).getNomMagasin());
    }
}