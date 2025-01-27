package com.example.loginandroid_29_09_2023.lstPro.model;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.loginandroid_29_09_2023.beans.Categoria;
import com.example.loginandroid_29_09_2023.lstPro.ContractListProducts;
import com.example.loginandroid_29_09_2023.lstPro.data.DataProducto;
import com.example.loginandroid_29_09_2023.lstPro.presenter.LstProductsPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstProductsModel implements ContractListProducts.Model {

    private LstProductsPresenter lstProductsPresenter;
    private Context context;

    public LstProductsModel(LstProductsPresenter lstProductsPresenter, Context context) {
        this.lstProductsPresenter = lstProductsPresenter;
        this.context = context;
    }

    @Override
    public void listarProductosAPI(OnLstProductsListener onLstProductsListener) {
        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);
        Call<DataProducto> call = apiService.getProductos();

        call.enqueue(new Callback<DataProducto>() {
            @Override
            public void onResponse(Call<DataProducto> call, Response<DataProducto> response) {
                if (response.isSuccessful() && response.body() != null) {
                    DataProducto productos = response.body();
                    onLstProductsListener.onFinished(productos);
                }
            }

            @Override
            public void onFailure(Call<DataProducto> call, Throwable t) {
                onLstProductsListener.onFailure(t.getMessage());
            }
        });
    }

    @Override
    public void cargarCategoriasAPI(OnLstProductsListener onLstProductsListener) {
        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);
        Call<ArrayList<Categoria>> call = apiService.getCategorias();

        call.enqueue(new Callback<ArrayList<Categoria>>() {
            @Override
            public void onResponse(Call<ArrayList<Categoria>> call, Response<ArrayList<Categoria>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Categoria> listaCategorias = response.body();
                    onLstProductsListener.onCategoriasLoaded(listaCategorias);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Categoria>> call, Throwable t) {
                onLstProductsListener.onFailure(t.getMessage());
            }
        });
    }

    @Override
    public void lstProductosByCategoria(int categoriaId, OnLstProductsListener onLstProductsListener) {
        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);
        Call<DataProducto> call = apiService.getProductosByCategoriaId(categoriaId);

        call.enqueue(new Callback<DataProducto>() {
            @Override
            public void onResponse(Call<DataProducto> call, Response<DataProducto> response) {
                if (response.isSuccessful() && response.body() != null) {
                    DataProducto productos = response.body();
                    onLstProductsListener.onFinished(productos);
                }
            }

            @Override
            public void onFailure(Call<DataProducto> call, Throwable t) {
                onLstProductsListener.onFailure(t.getMessage());
            }
        });
    }
}
