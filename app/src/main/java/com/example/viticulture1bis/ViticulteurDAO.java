package com.example.viticulture1bis;


import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ViticulteurDAO {


    private static String base = "BDViticulteur";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public ViticulteurDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);

    }

    public void addViticulteur1(Viticulteur unViticulteur){
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        String req = "insert into viticulteur(nomV,niveauV)"
                + " values('"+unViticulteur.getNomV()+"',"+unViticulteur.getNiveauV()+");";
        Log.d("log",req);
        bd.execSQL(req);
        bd.close();
    }

    public long addViticulteur2(Viticulteur unViticulteur){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("nomV", unViticulteur.getNomV());
        value.put("niveauV",unViticulteur.getNiveauV());
        ret = bd.insert("viticulteur", null, value);

        return ret;
    }


    public Viticulteur getViticulteur(long idV){
        Viticulteur leViticulteur = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from viticulteur where idV="+idV+";",null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            leViticulteur = new Viticulteur(idV,curseur.getString(1), curseur.getInt(2));
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


}
