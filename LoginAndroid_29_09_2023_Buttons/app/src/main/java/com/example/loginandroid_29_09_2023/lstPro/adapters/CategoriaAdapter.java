package com.example.loginandroid_29_09_2023.lstPro.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Categoria;

import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.ViewHolder> {

    private List<Categoria> categorias;
    private OnCategoriaClickListener listener;

    public interface OnCategoriaClickListener {
        void onCategoriaClick(Categoria categoria);
    }

    public CategoriaAdapter(List<Categoria> categorias, OnCategoriaClickListener listener) {
        this.categorias = categorias;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoria, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Categoria categoria = categorias.get(position);
        holder.bind(categoria, listener);
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCategoriaNombre;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategoriaNombre = itemView.findViewById(R.id.tvCategoriaNombre);
        }

        void bind(final Categoria categoria, final OnCategoriaClickListener listener) {
            tvCategoriaNombre.setText(categoria.getNombre());
            itemView.setOnClickListener(v -> listener.onCategoriaClick(categoria));
        }
    }
}