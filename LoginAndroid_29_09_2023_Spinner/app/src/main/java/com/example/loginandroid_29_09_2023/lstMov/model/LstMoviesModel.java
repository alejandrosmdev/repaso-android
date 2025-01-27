package com.example.loginandroid_29_09_2023.lstMov.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.lstMov.ContractListMovies;
import com.example.loginandroid_29_09_2023.lstMov.presenter.LstMoviesPresenter;
import com.example.loginandroid_29_09_2023.lstMov.data.DataMovies;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstMoviesModel implements ContractListMovies.Model {
    private static final String IP_BASE = "10.0.0.2:8080";
    private LstMoviesPresenter presenter;

    public LstMoviesModel(LstMoviesPresenter presenter){
        this.presenter = presenter;
    }

//    @Override
//    public void moviesAPI(String filtro,
//                          OnLstMoviesListener respuestaMovies) {
//        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).
//                create(ApiService.class);
//
//        // Call<DataMovies> call = apiService.getDataMovies ("MOVIE.LST_PELICULA");
//        call.enqueue(new Callback<DataMovies>() {
//            @Override
//            public void onResponse(Call<DataMovies> call, Response<DataMovies> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<DataMovies> call, Throwable t) {
//
//            }
//        });
//    }
}

