package com.example.mascotasapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class MascotaAdaptador  extends  RecyclerView.Adapter<MascotaAdaptador.MascotasViewHolder> {
    ArrayList<Mascotas> listaMascota;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascotas> listaMascota, Activity activity) {
        this.listaMascota = listaMascota;
        this.activity = activity;
    }

    //infla el layout y le pasará al viewholder para obtener los views
    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascotas_cardview, null, false);
        return new MascotasViewHolder(view);
    }

    //asocia cada elemento
    @Override
    public void onBindViewHolder(@NonNull MascotasViewHolder holder, int position) {
        holder.ImgFoto.setImageResource(listaMascota.get(position).getFoto());
        holder.tvNombreCV.setText(listaMascota.get(position).getNombre());
        holder.tvhuesoCV.setText(listaMascota.get(position).getNumerohueso());
        holder.mascotaCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, listaMascota.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                Intent Siguiente = new Intent(activity, Detalle_Mascota.class);
                Siguiente.putExtra("fotoD", listaMascota.get(position).getFoto());
                Siguiente.putExtra("nombre", listaMascota.get(position).getNombre());
                Siguiente.putExtra("edad", listaMascota.get(position).getEdad());
                Siguiente.putExtra("descripcion", listaMascota.get(position).getDescripcion());
                Siguiente.putExtra("hueso", listaMascota.get(position).getNumerohueso());
                activity.startActivity(Siguiente);
            }
        });
        holder.star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, " Añadido a Favorito " + listaMascota.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                listaMascota.get(position).setFavorito( true);
            }
        });
    }

    @Override  //la cantidad de elementos que tiene la lista
    public int getItemCount() {
        return listaMascota.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder {

        CardView mascotaCardView;
        ImageView ImgFoto;
        TextView tvNombreCV;
        TextView tvhuesoCV;
        ImageView star;

        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);

            mascotaCardView = (CardView) itemView.findViewById(R.id.cardView);
            ImgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvhuesoCV = (TextView) itemView.findViewById(R.id.tvhuesoCV);
            star = (ImageView) itemView.findViewById(R.id.star);
        }

    }
}