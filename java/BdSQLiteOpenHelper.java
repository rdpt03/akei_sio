package com.example.akei;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BdSQLiteOpenHelper extends SQLiteOpenHelper {

    private String CreateRayon="create table rayon ("
            + "idRayon INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nomRayon TEXT NOT NULL,"
            + "descriptionRayon TEXT NOT NULL);";

    private String CreateMagasin="create table magasin ("
            + "idMagasin INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nomMagasin TEXT NOT NULL,"
            + "rueMagasin TEXT NOT NULL,"
            + "villeMagasin TEXT NOT NULL,"
            + "cpMagasin CHAR(5) NOT NULL,"
            + "paysMagasin TEXT NOT NULL);";


    private String CreateVehicule="create table vehicule ("
            + "idVehicule INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nomVehicule TEXT NOT NULL,"
            + "marqueVehicule TEXT NOT NULL,"
            + "longueurVehicule REAL NOT NULL,"
            + "largeurVehicule REAL NOT NULL,"
            + "volumeVehicule REAL NOT NULL,"
            + "immatriculationVehicule TEXT NOT NULL,"
            + "CarburantVehicule REAL NOT NULL,"
            + "kmActuelVehicule INTEGER NOT NULL,"
            + "idMagasin INTEGER NOT NULL,"
            + "FOREIGN KEY(idMagasin) REFERENCES magasin(idMagasin));";

    private String CreateProduit="create table produit ("
            + "idProduit INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nomProduit TEXT NOT NULL,"
            + "descriptionTechProduit TEXT NOT NULL,"
            + "prixProduit REAL NOT NULL,"
            + "poidsProduit REAL NOT NULL,"
            + "longueuerProduit REAL NOT NULL,"
            + "largeurProduit REAL NOT NULL,"
            + "hauteurProduit REAL NOT NULL,"
            + "idRayon INTEGER NOT NULL,"
            + "  FOREIGN KEY(idRayon) REFERENCES rayon(idRayon));";

    private String CreateEmploye="create table employe ("
            + "idEmploye INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nomEmploye TEXT NOT NULL,"
            + "prenomEmploye TEXT NOT NULL,"
            + "idRayon INTEGER NOT NULL,"
            + "idMagasin INTEGER NOT NULL,"
            + "FOREIGN KEY(idRayon) REFERENCES rayon(idRayon),"
            + "FOREIGN KEY(idMagasin) REFERENCES magasin(idMagasin));";


    public BdSQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CreateRayon);
        db.execSQL(CreateMagasin);
        db.execSQL(CreateVehicule);
        db.execSQL(CreateProduit);
        db.execSQL(CreateEmploye);
        //donnes de test
        db.execSQL("insert into magasin (nomMagasin,rueMagasin,villeMagasin,cpMagasin,paysMagasin) values('ametzondo','18 rue des fleurs','Bayonne','64100','France');");
        db.execSQL("insert into magasin (nomMagasin,rueMagasin,villeMagasin,cpMagasin,paysMagasin) values('BAB2','18 rue des jonquilles','Anglet','64154','France');");
        db.execSQL("insert into magasin (nomMagasin,rueMagasin,villeMagasin,cpMagasin,paysMagasin) values('Bardos','24 rue des paquerettes','Biarritz','64125','France');");
        db.execSQL("insert into rayon (nomRayon,descriptionRayon) values('Cuisine','Rayon contenant les produits pouvant convenir à une cuisine');");
        db.execSQL("insert into rayon (nomRayon,descriptionRayon) values('Salon','Rayon contenant les produits pouvant convenir à un salon');");
        db.execSQL("insert into rayon (nomRayon,descriptionRayon) values('Chambre','Rayon contenant les produits pouvant convenir à une chambre');");
        db.execSQL("insert into produit (nomProduit,descriptionTechProduit,prixProduit,poidsProduit,longueuerProduit,largeurProduit,hauteurProduit,idRayon) values('Plan de travail','Plan en angle',75,80,2.5,2.5,3,1);");
        db.execSQL("insert into produit (nomProduit,descriptionTechProduit,prixProduit,poidsProduit,longueuerProduit,largeurProduit,hauteurProduit,idRayon) values('canapé','Canapé confortable',120,50,2.5,1,1,2);");
        db.execSQL("insert into produit (nomProduit,descriptionTechProduit,prixProduit,poidsProduit,longueuerProduit,largeurProduit,hauteurProduit,idRayon) values('Lit','Grand Lit',150,20,3.5,2.5,1,3);");
        db.execSQL("insert into vehicule (nomVehicule,marqueVehicule,longueurVehicule,largeurVehicule,volumeVehicule,immatriculationVehicule,CarburantVehicule,kmActuelVehicule,idMagasin) values('C3','Citroen',15,5,225,'CKX-LYVS_52',134.5,14000,1);");
        db.execSQL("insert into vehicule (nomVehicule,marqueVehicule,longueurVehicule,largeurVehicule,volumeVehicule,immatriculationVehicule,CarburantVehicule,kmActuelVehicule,idMagasin) values('Twingo','Renault',20,7,300,'RSP-NNOP_23',225,24568,2);");
        db.execSQL("insert into vehicule (nomVehicule,marqueVehicule,longueurVehicule,largeurVehicule,volumeVehicule,immatriculationVehicule,CarburantVehicule,kmActuelVehicule,idMagasin) values('Twizy','Renault',30,2,152,'PFG-NGLO_26',322.5,14785,3);");

        db.execSQL("insert into employe (nomEmploye,prenomEmploye, idRayon, idMagasin) values ('DA SILVA','Rafael',3,3)");
        db.execSQL("insert into employe (nomEmploye,prenomEmploye, idRayon, idMagasin) values ('Alves','Diogo',3,3)");
        db.execSQL("insert into employe (nomEmploye,prenomEmploye, idRayon, idMagasin) values ('Sousa','Willine',2,3)");
        db.execSQL("insert into employe (nomEmploye,prenomEmploye, idRayon, idMagasin) values ('Jimenez','Albientu',2,3)");
        db.execSQL("insert into employe (nomEmploye,prenomEmploye, idRayon, idMagasin) values ('Marquez','xavier',2,1)");
        db.execSQL("insert into employe (nomEmploye,prenomEmploye, idRayon, idMagasin) values ('Etxuggy','Ibirizar',1,2)");
        db.execSQL("insert into employe (nomEmploye,prenomEmploye, idRayon, idMagasin) values ('Smith','John',1,2)");
        db.execSQL("insert into employe (nomEmploye,prenomEmploye, idRayon, idMagasin) values ('Putin','Vladimir',3,3)");
        db.execSQL("insert into employe (nomEmploye,prenomEmploye, idRayon, idMagasin) values ('Zeleski','Volodymir',3,1)");
        db.execSQL("insert into employe (nomEmploye,prenomEmploye, idRayon, idMagasin) values ('Rebelo de Sousa','Marcelinho',3,1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}
