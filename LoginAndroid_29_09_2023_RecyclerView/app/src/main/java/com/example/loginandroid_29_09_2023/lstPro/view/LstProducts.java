package com.example.loginandroid_29_09_2023.lstPro.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Categoria;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.lstPro.ContractListProducts;
import com.example.loginandroid_29_09_2023.lstPro.adapters.CategoriaAdapter;
import com.example.loginandroid_29_09_2023.lstPro.adapters.ProductoAdapter;
import com.example.loginandroid_29_09_2023.lstPro.presenter.LstProductsPresenter;

import java.util.ArrayList;

public class LstProducts extends AppCompatActivity implements ContractListProducts.View {
    private LstProductsPresenter lstProductsPresenter;
    private RecyclerView recyclerView;
    private ProductoAdapter productoAdapter;
    private RecyclerView categoriesRecyclerView;
    private CategoriaAdapter categoriaAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_products);

        recyclerView = findViewById(R.id.recyclerViewProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        lstProductsPresenter = new LstProductsPresenter(this, this);
        lstProductsPresenter.listarProductos();


        categoriesRecyclerView = findViewById(R.id.categoriesRecyclerView);
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        lstProductsPresenter.cargarCategorias();
    }

    @Override
    public void successProducts(ArrayList<Producto> productos) {
        if (productoAdapter == null) {
            productoAdapter = new ProductoAdapter(this, productos);
            recyclerView.setAdapter(productoAdapter);
        } else {
            productoAdapter.updateData(productos);
        }
    }

    @Override
    public void failureProducts(String err) {
        Toast.makeText(this, "Error al obtener productos "+err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setCategorias(ArrayList<Categoria> categorias) {
        categoriaAdapter = new CategoriaAdapter(categorias, categoria -> lstProductsPresenter.listarProductosPorCategoria(categoria.getId()));
        categoriesRecyclerView.setAdapter(categoriaAdapter);
    }
}