package com.example.loginandroid_29_09_2023.lstMov.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Pelicula;
import com.example.loginandroid_29_09_2023.lstMov.ContractListMovies;
import com.example.loginandroid_29_09_2023.lstMov.adapters.PeliculaAdapter;
import com.example.loginandroid_29_09_2023.lstMov.presenter.LstMoviesPresenter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class LstMovies extends AppCompatActivity
        /*implements ¿?¿*/{
//    private LstMoviesPresenter lstMoviesPresenter;
//    private RecyclerView recyclerView;
//    private PeliculaAdapter adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lst_movies4);
//
//
//    }
//
//
//
//    @Override
//    public void successMovies(ArrayList<Pelicula> lstPelicula) {
//        // Toast.makeText(this, lstPelicula.get(0).getTitulo(), Toast.LENGTH_SHORT).show();
//        //peliculas = cargarDatos();
//        recyclerView = findViewById(R.id.recyclerViewPeliculas);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        adapter = new PeliculaAdapter(this, lstPelicula);
//        adapter.setOnItemClickListener(new PeliculaAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(Pelicula pelicula) {
//                // Aquí manejas el clic en la película
//                Toast.makeText(LstMovies.this, pelicula.getTitulo(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        recyclerView.setAdapter(adapter);
//    }
//
//    @Override
//    public void failureMovies(String err) {
//
//    }
}