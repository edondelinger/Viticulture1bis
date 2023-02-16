package com.example.viticulture1bis;


import java.util.ArrayList;
import java.util.Iterator;

import android.os.Bundle;
//import android.app.Activity;
//import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddViticulteurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnAjout = (Button) findViewById(R.id.btnAjouter);

        btnAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ajouter();
            }
        });

    }

    private void ajouter(){
        ViticulteurDAO viticulteurAcces = new ViticulteurDAO(this);

        // recuperation des valeurs saisies
        EditText txtNomV = (EditText) findViewById(R.id.txtNomV);
        EditText txtNiveauV = (EditText) findViewById(R.id.txtNiveauV);

        Viticulteur nouveauViticulteur = new Viticulteur(txtNomV.getText().toString(), Integer.parseInt(txtNiveauV.getText().toString()));

        viticulteurAcces.addViticulteur1(nouveauViticulteur);


        // test :
        ArrayList<Viticulteur> listeViticulteurRecherche;
        listeViticulteurRecherche = viticulteurAcces.getViticulteurs("%");

        Iterator<Viticulteur> itViticulteur;
        Viticulteur unViticulteur;
        for( itViticulteur = listeViticulteurRecherche.iterator(); itViticulteur.hasNext(); ){
            unViticulteur = itViticulteur.next();
            Log.d("log",unViticulteur.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
