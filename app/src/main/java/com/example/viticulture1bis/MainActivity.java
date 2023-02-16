package com.example.viticulture1bis;


import java.util.ArrayList;
import java.util.Iterator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Viticulteur> listeViticulteurRecherche;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViticulteurDAO viticulteurAcces = new ViticulteurDAO(this);

        listeViticulteurRecherche = viticulteurAcces.getViticulteurs("%");

        for (Viticulteur unViticulteur : listeViticulteurRecherche){
            Log.d("onCreate", unViticulteur.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ajouterViticulteur :
                Intent intent = new Intent(this, AddViticulteurActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

}
