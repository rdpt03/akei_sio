package com.example.akei;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MagasinDAO {
    private static String base = "BDAKEI";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public MagasinDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public long addMagasin(Magasin unMagasin){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("nomMagasin", unMagasin.getNomMagasin());
        value.put("rueMagasin",unMagasin.getRueMagasin());
        value.put("villeMagasin",unMagasin.getVilleMagasin());
        value.put("cpMagasin",unMagasin.getCpMagasin());
        value.put("paysMagasin",unMagasin.getPaysMagasin());
        ret = bd.insert("magasin", null, value);

        return ret;
    }

    public Magasin getMagasin(long idM){
        Magasin leMagasin = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from magasin where idMagasin="+idM+";",null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            leMagasin = new Magasin(idM,curseur.getString(1), curseur.getString(2), curseur.getString(3), curseur.getString(4), curseur.getString(5));
        }
        return leMagasin;
    }



    //  LISTE DES MAGASINS
    public ArrayList<Magasin> getToutMagasins() {
        Cursor curseur;
        String req = "SELECT * FROM magasin;";
        curseur = accesBD.getReadableDatabase().rawQuery(req, null);
        ArrayList<Magasin> magasins = cursorToMagasinArrayList(curseur);
        Log.d("logdedonnes", magasins.toString());
        return cursorToMagasinArrayList(curseur);
    }


    private ArrayList<Magasin> cursorToMagasinArrayList(Cursor curseur){
        ArrayList<Magasin> listeMagasin = new ArrayList<Magasin>();
        long idMagasin;
        String nomMagasin;
        String rueMagasin;
        String villeMagasin;
        String cpMagasin;
        String paysMagasin;


        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            idMagasin = curseur.getLong(0);
            nomMagasin = curseur.getString(1);
            rueMagasin = curseur.getString(2);
            villeMagasin = curseur.getString(3);
            cpMagasin = curseur.getString(4);
            paysMagasin = curseur.getString(5);
            listeMagasin.add(new Magasin(idMagasin,nomMagasin,rueMagasin,villeMagasin,cpMagasin,paysMagasin));
            curseur.moveToNext();
        }
        return listeMagasin;
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
