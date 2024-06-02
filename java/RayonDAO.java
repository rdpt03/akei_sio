package com.example.akei;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class RayonDAO {
    private static String base = "BDAKEI";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public RayonDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public long addRayon(Rayon unRayon){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("nomProduit", unRayon.getNomRayon());
        value.put("descriptionRayon",unRayon.getDescriptionRayon());
        ret = bd.insert("rayon", null, value);

        return ret;
    }

    public Rayon getRayon(long idR){
        Rayon leRayon = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from rayon where idRayon="+idR+";",null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            leRayon = new Rayon(idR,curseur.getString(1), curseur.getString(2));
        }
        return leRayon;
    }


    public ArrayList<Rayon> getAllRayons() {
        //creer curseur
        Cursor curseur;
        //requete
        String req = "SELECT * FROM rayon;";
        //obtenir les resultats
        curseur = accesBD.getReadableDatabase().rawQuery(req, null);
        //convertir le curseuren liste
        ArrayList<Rayon> rayons = cursorToRayonArrayList(curseur);
        //printer
        Log.d("Log de donnés - Rayons", rayons.toString());
        //return
        return cursorToRayonArrayList(curseur);
    }


    private ArrayList<Rayon> cursorToRayonArrayList(Cursor curseur){
        ArrayList<Rayon> listeRayon = new ArrayList<Rayon>();
        long idRayon;
        String nomRayon;
        String descriptionRayon;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            idRayon = curseur.getLong(0);
            nomRayon = curseur.getString(1);
            descriptionRayon = curseur.getString(2);
            listeRayon.add(new Rayon(idRayon,nomRayon,descriptionRayon));
            curseur.moveToNext();
        }
        return listeRayon;
    }


    /**         AMODIFIER
     public Employe updEmploye(long idV) {
     Employe leEmploye = null;
     Cursor curseur;
     curseur = accesBD.getWritableDatabase().rawQuery("SELECT * FROM viticulteur WHERE idV = " + idV + ";", null);
     if (curseur.getCount() > 0) {
     curseur.moveToFirst();
     leEmploye = new Viticulteur(idV, curseur.getString(1), curseur.getInt(2));

     int nouveauNiveau = 10000;
     ContentValues values = new ContentValues();
     values.put("niveauV", nouveauNiveau);

     SQLiteDatabase bd = accesBD.getWritableDatabase();
     bd.update("viticulteur", values, "idV = ?", new String[]{idV+""});

     leEmploye.setNiveauV(nouveauNiveau);
     }
     return leViticulteur;
     }


     public ArrayList<Viticulteur> getViticulteurs(String nomV){
     Cursor curseur;
     String req = "select * from viticulteur where nomV like '"+nomV+"';";
     curseur = accesBD.getReadableDatabase().rawQuery(req,null);
     return cursorToViticulteurArrayList(curseur);
     }

     private ArrayList<Viticulteur> cursorToViticulteurArrayList(Cursor curseur){
     ArrayList<Viticulteur> listeViticulteur = new ArrayList<Viticulteur>();
     long idV;
     String nomV;
     int niveauV;

     curseur.moveToFirst();
     while (!curseur.isAfterLast()){
     idV = curseur.getLong(0);
     nomV = curseur.getString(1);
     niveauV = curseur.getInt(2);
     listeViticulteur.add(new Viticulteur(idV,nomV,niveauV));
     curseur.moveToNext();
     }
     return listeViticulteur;
     }
     **/
}
