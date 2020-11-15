package com.example.mascotasapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Favorito extends AppCompatActivity   {

    ArrayList<Mascotas> listaMascotas = new ArrayList<Mascotas>();
    RecyclerView recicler;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionbar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setTitle("Favoritos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        extras = getIntent().getExtras();
        listaMascotas= (ArrayList<Mascotas>)extras.getSerializable("obj");
        recicler = (RecyclerView) findViewById(R.id.rvMascotasFavorito);
        recicler.setHasFixedSize(true);
        RecyclerView.LayoutManager Manager = new LinearLayoutManager(this);
        recicler.setLayoutManager(Manager);
        MascotaAdaptador adapter = new MascotaAdaptador(listaMascotas, this);
        recicler.setAdapter(adapter);

    }

}