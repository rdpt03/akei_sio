package com.example.akei;

import static android.R.layout.*;

import android.R.layout;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class activityListeprincipaleRayonemployeActivity extends AppCompatActivity {
    private ListView lv_listeDesRayons,lv_listeDeMagasins;
    private ArrayList<Rayon> listeRayons;
    private ArrayList<Magasin> listeMagasins;
    private Button bt_obtenirResultat;
    private int posRayonChoisi = -5;
    private int posMagasinChoisi = -5;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeprincipale_rayonemploye);

        //obtenir le listview :
        lv_listeDesRayons = findViewById(R.id.lv_listeDesRayons);
        lv_listeDeMagasins = findViewById(R.id.lv_listeDeMagasins);
        //obtenir button
        bt_obtenirResultat=findViewById(R.id.bt_obtenirResultat);
        //Creer un rayon DAO
        RayonDAO rayonDAO = new RayonDAO(this);
        MagasinDAO magasinDAO = new MagasinDAO(this);

        //___obtenir la liste des magasins___:

        listeMagasins = magasinDAO.getToutMagasins();

        //setter les valeurs dans les listviews
        ArrayAdapter<String> adapterMagasin = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        for (Magasin mg : listeMagasins) {
            adapterMagasin.add(mg.getNomMagasin());
        }

        lv_listeDeMagasins.setAdapter(adapterMagasin);

        //___obtenit la liste des rayons___:
        listeRayons = rayonDAO.getAllRayons();

        //setter les valeurs dans les listviews
        ArrayAdapter<String> adapterRayon = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        for (Rayon ry : listeRayons) {
            adapterRayon.add(ry.getNomRayon());
        }

        lv_listeDesRayons.setAdapter(adapterRayon);

        //rayon choisi
        lv_listeDesRayons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 posRayonChoisi =i;
                 Log.d("Rayon Choisi","Position : "+posRayonChoisi);
                 toast("Magasin "+listeRayons.get(posRayonChoisi).getNomRayon()+" Choisi");

             }
        });
        //magasin choisi
        lv_listeDeMagasins.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                posMagasinChoisi = i;
                Log.d("Magasin Choisi","Position : "+posMagasinChoisi);
                toast("Magasin "+listeMagasins.get(posMagasinChoisi).getNomMagasin()+" Choisi");
            }
        });

        //button
        bt_obtenirResultat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lv_listeDesRayons.getSelectedItemPosition();
                lv_listeDeMagasins.getSelectedItemPosition();

                if (posMagasinChoisi == -5 && posRayonChoisi == -5){
                    Log.e("Choix des Rayons et Magasins","Erreur : Aucun magasin et rayon chosi");
                    toast("Erreur: Aucun magasin et rayon chosi");
                }
                else if (posMagasinChoisi == -5){
                    Log.e("Choix des Rayons et Magasins","Erreur : Aucun magasin chosi");
                    toast("Erreur: Aucun magasin chosi");
                }
                else if (posRayonChoisi == -5){
                    Log.e("Choix des Rayons et Magasins","Erreur : Aucun rayon chosi");
                    toast("Erreur: Aucun rayon chosi");
                }else{
                    Log.i("Choix des Rayons et Magasins","Info : Magasin : "+posMagasinChoisi+" | Rayon : "+posRayonChoisi);
                    /////CONTINUER GLUGLUG
                    //obtenir magasin
                    Magasin magasin = listeMagasins.get(posMagasinChoisi);
                    //obtenir rayon
                    Rayon rayon = listeRayons.get(posRayonChoisi);
                    //intent
                    Intent listeDeRayonsEmployes = new Intent(getApplicationContext(), activityListesecondaireEmployeActivity.class);
                    listeDeRayonsEmployes.putExtra("magasinID",magasin.getIdMagasin());
                    listeDeRayonsEmployes.putExtra("rayonID",rayon.getIdRayon());
                    //start IT
                    startActivity(listeDeRayonsEmployes);
                }
            }
        });
    }
    public void toast(String msg){
        Toast toast = Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}