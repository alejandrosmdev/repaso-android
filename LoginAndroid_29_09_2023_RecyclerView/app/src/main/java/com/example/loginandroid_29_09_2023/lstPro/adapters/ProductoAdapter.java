package com.example.loginandroid_29_09_2023.lstPro.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.utils.SAMBA_ANDROID;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Producto> productos;

    public ProductoAdapter(Context context, ArrayList<Producto> productos) {
        this.context = context;
        this.productos = productos;
    }

    public interface OnItemClickListener {
        void onItemClick(Producto producto);
    }

    private OnItemClickListener listener;

    // Método para establecer el listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,
                parent,
                false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ViewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.proNombre.setText(producto.getNombre());
        holder.proDescripcion.setText((producto.getDescripcion()));
        holder.proPrecio.setText(producto.getPrecio());
        holder.proImagenUrl.setText(producto.getImagen_url());

        String myUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4-dTsAVcnogXdROu71NB5BcRnznA4vAOevg&s";
        SAMBA_ANDROID samba_android = new SAMBA_ANDROID.Builder(myUrl, holder.ivImagenProducto).build();
        samba_android.load();

        holder.bind(producto);

    }

    public void updateData(ArrayList<Producto> productos) {
        this.productos = productos;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView proNombre, proDescripcion, proPrecio, proImagenUrl;
        private ImageView ivImagenProducto;
        private Producto currentProducto;


        public ViewHolder(View itemView, final ProductoAdapter.OnItemClickListener onItemClickListener) {
            super(itemView);
            proNombre = itemView.findViewById(R.id.proNombre);
            proDescripcion = itemView.findViewById(R.id.proDescripcion);
            proPrecio = itemView.findViewById(R.id.proPrecio);
            proImagenUrl = itemView.findViewById(R.id.proImagenUrl);
            ivImagenProducto = itemView.findViewById(R.id.ivProductoImagen);
        }

        public void bind(Producto producto){currentProducto = producto;}
    }
}
