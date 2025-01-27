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
import com.example.loginandroid_29_09_2023.lstPro.adapters.ProductoAdapter;
import com.example.loginandroid_29_09_2023.lstPro.presenter.LstProductsPresenter;

import java.util.ArrayList;

public class LstProducts extends AppCompatActivity implements ContractListProducts.View {
    private LstProductsPresenter lstProductsPresenter;
    private RecyclerView recyclerView;
    private ProductoAdapter adapter;
    private LinearLayout categoryButtonsContainer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_products);

        recyclerView = findViewById(R.id.recyclerViewProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        lstProductsPresenter = new LstProductsPresenter(this, this);
        lstProductsPresenter.listarProductos();


        categoryButtonsContainer = findViewById(R.id.categoryButtonsContainer);
        lstProductsPresenter.cargarCategorias();
    }

    @Override
    public void successProducts(ArrayList<Producto> productos) {
        if (adapter == null) {
            adapter = new ProductoAdapter(this, productos);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.updateData(productos);
        }
    }

    @Override
    public void failureProducts(String err) {
        Toast.makeText(this, "Error al obtener productos "+err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setCategorias(ArrayList<Categoria> categorias) {
        for (Categoria categoria : categorias) {
            Button button = new Button(this);
            button.setText(categoria.getNombre());
            button.setOnClickListener(v -> lstProductsPresenter.listarProductosPorCategoria(categoria.getId()));
            categoryButtonsContainer.addView(button);
        }
    }
}