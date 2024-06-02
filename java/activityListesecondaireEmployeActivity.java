package com.example.akei;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class activityListesecondaireEmployeActivity extends AppCompatActivity {
    private EmployeDAO employeeAcess;
    private ListView lv_listeEmployes;
    private ArrayList<String> listeNomsEmployees = new ArrayList<>();
    private ArrayList<Employe> listeObjetsEmployes = new ArrayList<>();
    private SearchView sv_rechercheEmployee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listesecondaire_employe);
        //demarrer lcasse
        //get dao
        employeeAcess = new EmployeDAO(this);
        //get elements
        lv_listeEmployes = findViewById(R.id.lv_listeEmployes);
        sv_rechercheEmployee = findViewById(R.id.sv_rechercheEmployee);
        //intent et obtenir les ids
        Intent intent = getIntent();
        long idMagasin = intent.getLongExtra("magasinID",0);
        long idRayon = intent.getLongExtra("rayonID",0);
        Log.d("APP-LOG",idMagasin+" - "+idRayon);



        //obtenir la liste des emplyees
        for(Employe employe : employeeAcess.getToutEmployes()){
            if(employe.getIdMagasin() == idMagasin && employe.getIdRayon() == idRayon){
                listeObjetsEmployes.add(employe);
            }
        }
              Log.d("APP-LOG",listeObjetsEmployes.size()+"");
        //obtenir noms des employees :
        for(Employe employe : listeObjetsEmployes) {
            listeNomsEmployees.add(employe.getNomEmploye()+" "+employe.getPrenomEmploye());
        }

        ArrayAdapter<String> adapterNomsEmployees = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listeNomsEmployees);
        lv_listeEmployes.setAdapter(adapterNomsEmployees);


        //recherche
        sv_rechercheEmployee.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterNomsEmployees.getFilter().filter(newText);
                return false;
            }
        });

        //cliqué sur choix
        lv_listeEmployes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                long idEmploye = listeObjetsEmployes.get(i).getIdEmploye();


                //intent
                Intent pageEmploye = new Intent(getApplicationContext(), activityCaracteristiquesEmployeActivity.class);
                pageEmploye.putExtra("idEmploye",idEmploye);
                //start IT
                startActivity(pageEmploye);
            }
        });
    }
}