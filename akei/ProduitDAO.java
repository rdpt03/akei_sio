package com.example.akei;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ProduitDAO {
    private static String base = "BDAKEI";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public ProduitDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public long addProduit(Produit unProduit){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("nomProduit", unProduit.getNomProduit());
        value.put("descriptionTechProduit",unProduit.getDescriptionTechProduit());
        value.put("prixProduit",unProduit.getPrixProduit());
        value.put("poidsProduit",unProduit.getPoidsProduit());
        value.put("longueuerProduit",unProduit.getLongueurProduit());
        value.put("largeurProduit",unProduit.getLargeurProduit());
        value.put("hauteurProduit",unProduit.getHauteurProduit());
        value.put("idRayon",unProduit.getIdRayon());
        ret = bd.insert("produit", null, value);

        return ret;
    }

    public Produit getProduit(long idP){
        Produit leProduit = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from produit where idProduit="+idP+";",null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            leProduit = new Produit(idP,curseur.getString(1), curseur.getString(2), curseur.getFloat(3), curseur.getFloat(4), curseur.getFloat(5), curseur.getFloat(6), curseur.getFloat(7), curseur.getInt(8));
        }
        return leProduit;
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
