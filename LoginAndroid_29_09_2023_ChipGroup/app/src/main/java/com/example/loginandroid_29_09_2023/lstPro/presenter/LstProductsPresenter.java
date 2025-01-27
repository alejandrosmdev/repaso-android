package com.example.loginandroid_29_09_2023.lstPro.presenter;

import android.content.Context;
import android.widget.SpinnerAdapter;

import com.example.loginandroid_29_09_2023.beans.Categoria;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.lstPro.ContractListProducts;
import com.example.loginandroid_29_09_2023.lstPro.model.LstProductsModel;

import java.util.ArrayList;

public class LstProductsPresenter implements ContractListProducts.Presenter, ContractListProducts.Model.OnLstProductsListener {

    private ContractListProducts.View view;
    private LstProductsModel lstProductsModel;

    public LstProductsPresenter(ContractListProducts.View view, Context context) {
        this.view = view;
        lstProductsModel = new LstProductsModel(this,context);
    }


    @Override
    public void onFinished(ArrayList<Producto> productos) {
        view.successProducts(productos);
    }

    @Override
    public void onFailure(String err) {
        view.failureProducts(err);
    }

    @Override
    public void onCategoriasLoaded(ArrayList<Categoria> categorias) {
        view.setCategorias(categorias);
    }

    @Override
    public void listarProductos() {
        lstProductsModel.listarProductosAPI(this);
    }

    @Override
    public void cargarCategorias() {
        lstProductsModel.cargarCategoriasAPI(this);
    }

    @Override
    public void listarProductosPorCategoria(int categoriaIdd) {
        lstProductsModel.lstProductosByCategoria(categoriaIdd, this);
    }
}
