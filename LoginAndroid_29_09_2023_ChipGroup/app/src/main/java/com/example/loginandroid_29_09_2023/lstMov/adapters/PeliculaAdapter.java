package com.example.loginandroid_29_09_2023.lstMov.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Pelicula;
import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolder> {

    private List<Pelicula> peliculas;
    private Context context;

    public PeliculaAdapter(Context context, List<Pelicula> peliculas) {

    }

    public interface OnItemClickListener {
        void onItemClick(Pelicula pelicula);
    }

    private  OnItemClickListener listener;

    // Método para establecer el listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_card,
                            parent,
                        false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);


            }
//            public void bind(Pelicula pelicula) {
//                currentPelicula = pelicula;
//            }
        }
    }

