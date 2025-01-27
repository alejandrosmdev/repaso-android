package com.example.loginandroid_29_09_2023.lstPro;

import android.widget.SpinnerAdapter;

import com.example.loginandroid_29_09_2023.beans.Categoria;
import com.example.loginandroid_29_09_2023.beans.Producto;

import java.util.ArrayList;

public interface ContractListProducts {
    interface View {
        void successProducts(ArrayList<Producto> productos);
        void failureProducts(String err);
        void setCategorias(ArrayList<Categoria> categorias);
    }

    interface Presenter {
        void listarProductos();
        void cargarCategorias();
        void listarProductosPorCategoria(int categoriaId);
    }

    interface Model {
        interface OnLstProductsListener {
            void onFinished(ArrayList<Producto> productos);
            void onFailure(String err);
            void onCategoriasLoaded(ArrayList<Categoria> categorias);
        }

        void listarProductosAPI(OnLstProductsListener onLstProductsListener);
        void cargarCategoriasAPI(OnLstProductsListener onLstProductsListener);
        void lstProductosByCategoria(int categoriaId, OnLstProductsListener onLstProductsListener);
    }
}
