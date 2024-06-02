package com.example.akei;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class EmployeDAO {
    private static String base = "BDAKEI";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public EmployeDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public long addEmploye(Employe unEmploye){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("nomEmploye", unEmploye.getNomEmploye());
        value.put("prenomEmploye",unEmploye.getPrenomEmploye());
        value.put("idRayon",unEmploye.getIdRayon());
        value.put("idMagasin",unEmploye.getIdMagasin());
        ret = bd.insert("employe", null, value);

        return ret;
    }

    public Employe getEmploye(long idE){
        Employe leEmploye = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from employe where idEmploye="+idE+";",null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            leEmploye = new Employe(idE,curseur.getString(1), curseur.getString(2), curseur.getLong(3), curseur.getLong(4));
        }
        return leEmploye;
    }

    //  LISTE DES MAGASINS
    public ArrayList<Employe> getToutEmployes() {
        Cursor curseur;
        String req = "SELECT * FROM employe;";
        curseur = accesBD.getReadableDatabase().rawQuery(req, null);
        ArrayList<Employe> employes = cursorToEmployeArrayList(curseur);
        Log.d("logdedonnes", employes.toString());
        return employes;
    }


    private ArrayList<Employe> cursorToEmployeArrayList(Cursor curseur) {
        ArrayList<Employe> listeEmploye = new ArrayList<Employe>();
        long idEmploye;
        String nomEmployee;
        String prenomEmployee;
        long idRayon;
        long idMagasin;


        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            idEmploye = curseur.getLong(0);
            nomEmployee = curseur.getString(1);
            prenomEmployee = curseur.getString(2);
            idRayon = curseur.getLong(3);
            idMagasin = curseur.getLong(4);
            listeEmploye.add(new Employe(idEmploye, nomEmployee, prenomEmployee, idRayon, idMagasin));
            curseur.moveToNext();
        }
        return listeEmploye;
    }
    /**
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
