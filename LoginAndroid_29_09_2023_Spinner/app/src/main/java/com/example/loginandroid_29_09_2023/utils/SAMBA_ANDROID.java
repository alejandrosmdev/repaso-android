package com.example.loginandroid_29_09_2023.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SAMBA_ANDROID {
    private String url;
    private ImageView imageView;
    public SAMBA_ANDROID(Builder builder) {
        this.url = builder.url;
        this.imageView = builder.imageView;
    }
    static Bitmap bitmap;
    public void load(){
        new Thread(() ->{
            try {
                URL url = new URL("https://lh4.googleusercontent.com/proxy/JG73x59mTNYlvZ5cQsk9mBag4NiNL_O58q4YC0DtyiSsEw8W2iQcAZhYTyEPbfr1DM3CWbT-LgJ8T8QDy6tKjRGHODw4UDQgN9ZF-rta-ifXdWwCmqw");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream input = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(input);

                // Actualizar el ImageView en el hilo principal
                imageView.post(() -> imageView.setImageBitmap(bitmap));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }).start();
    }

    public static class Builder{
        private String url;
        private ImageView imageView;
        private boolean generateImage = false;

        public Builder(String url, ImageView imageView){
            this.url = url;
            this.imageView = imageView;
        }

        public Builder generateImage() {
            this.generateImage = true;
            return this;
        }

        public SAMBA_ANDROID build(){
            return new SAMBA_ANDROID (this);
        }
    }
}

