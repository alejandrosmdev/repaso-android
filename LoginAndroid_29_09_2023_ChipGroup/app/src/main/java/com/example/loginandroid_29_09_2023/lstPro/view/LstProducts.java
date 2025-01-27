package com.example.loginandroid_29_09_2023.lstPro.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
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
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class LstProducts extends AppCompatActivity implements ContractListProducts.View {
    private LstProductsPresenter lstProductsPresenter;
    private RecyclerView recyclerView;
    private ProductoAdapter adapter;
    private ChipGroup categoryChipGroup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_products);

        recyclerView = findViewById(R.id.recyclerViewProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        lstProductsPresenter = new LstProductsPresenter(this, this);
        lstProductsPresenter.listarProductos();


        categoryChipGroup = findViewById(R.id.categoryChipGroup);
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
            Chip chip = new Chip(this);
            chip.setText(categoria.getNombre());
            chip.setCheckable(true);
            chip.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    lstProductsPresenter.listarProductosPorCategoria(categoria.getId());
                }
            });
            categoryChipGroup.addView(chip);
        }
    }
}