package com.example.akei;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class VehiculeDAO {
    private static String base = "BDAKEI";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public VehiculeDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public long addVehicule(Vehicule unVehicule){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();
        //attributs a introduire en base
        ContentValues value = new ContentValues();
        value.put("nomVehicule", unVehicule.getNomVehicule());
        value.put("longueurVehicule",unVehicule.getLongueurVehicule());
        value.put("largeurVehicule",unVehicule.getLargeurVehicule());
        value.put("volumeVehicule",unVehicule.getVolumeVehicule());
        value.put("immatriculationVehicule",unVehicule.getImmatriculationVehicule());
        value.put("CarburantVehicule",unVehicule.getCarburantVehicule());
        value.put("kmActuelVehicule",unVehicule.getKmActuelVehicule());
        value.put("idMagasin",unVehicule.getMagasin());




        ret = bd.insert("vehicule", null, value);

        return ret;
    }

    public Vehicule getVehicule(long idVeh){
        Vehicule vehicule = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from vehicule where vehicule="+idVeh+";",null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            vehicule = new Vehicule(idVeh,
                    curseur.getString(1),
                    curseur.getString(2),
                    curseur.getDouble(3),
                    curseur.getDouble(4),
                    curseur.getDouble(5),
                    curseur.getDouble(6),
                    curseur.getString(7),
                    curseur.getDouble(8),
                    curseur.getInt(9),
                    curseur.getLong(10)
            );
        }
        return vehicule;
    }
    /**         AMODIFIER
     public Vehicule updVehicule(long idV) {
     /*
        obsolete - fait appel de this.getVehicule(idV)
        Vehicule leVehicule = null;
     Cursor curseur;
     curseur = accesBD.getWritableDatabase().rawQuery("SELECT * FROM viticulteur WHERE idV = " + idV + ";", null);
     if (curseur.getCount() > 0) {
     curseur.moveToFirst();
     leVehicule = new Vehicule(idV, curseur.getString(1), curseur.getInt(2));
     *./
         //obtenir vehicule
     Vehicule vehicule = this.getVehicule(idV);
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


