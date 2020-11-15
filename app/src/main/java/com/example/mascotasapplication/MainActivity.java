package com.example.mascotasapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> listaMascotas  = new ArrayList<Mascotas>();
    RecyclerView recicler;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int selec = item.getItemId();
        if(selec == R.id.action_favorite){
            Intent favorito = new Intent(this, Favorito.class);
            ArrayList<Mascotas> listaMascotasFav  = new ArrayList<Mascotas>();
            for (Mascotas mascota:
                 listaMascotas) {
                if (mascota.isFavorito()){
                    listaMascotasFav.add(mascota);
                }
            }
            favorito.putExtra("obj",listaMascotasFav);
            this.startActivity(favorito);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista();
        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionbar);
        setSupportActionBar(miActionBar);

        recicler = (RecyclerView) findViewById(R.id.rvMascotas);
        recicler.setHasFixedSize(true);
        RecyclerView.LayoutManager Manager = new LinearLayoutManager(this);
        recicler.setLayoutManager(Manager);

        MascotaAdaptador adapter = new MascotaAdaptador(listaMascotas, this);
        recicler.setAdapter(adapter);
    }
    public void lista(){

        listaMascotas.add(new Mascotas(R.drawable.perro0, "Luna", "3", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "5 años"));
        listaMascotas.add(new Mascotas(R.drawable.perro1, "Kira", "5", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "2 años"));
        listaMascotas.add(new Mascotas(R.drawable.perro2, "Thor", "4", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "1 años"));
        listaMascotas.add(new Mascotas(R.drawable.perro3, "Lola", "2", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "2 años" ));
        listaMascotas.add(new Mascotas(R.drawable.perro4, "Nala", "5", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "1 años" ));
        listaMascotas.add(new Mascotas(R.drawable.perro5, "Rex", "4", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "1 años" ));
        listaMascotas.add(new Mascotas(R.drawable.perro6, "Zeus", "3", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "2 años"));
        listaMascotas.add(new Mascotas(R.drawable.perro7, "Rocky", "5", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "2 años"));
        listaMascotas.add(new Mascotas(R.drawable.perro8, "Taison", "4", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "1 años"));
        listaMascotas.add(new Mascotas(R.drawable.perro9, "Rambo", "5", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "2 años"));
    }
}