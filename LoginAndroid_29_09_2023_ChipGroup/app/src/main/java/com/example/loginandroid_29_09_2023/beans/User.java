package com.example.loginandroid_29_09_2023.beans;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String email;
    private String password; // Puedes agregar otros campos según tus necesidades

    public User(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    // Getters y setters
}
