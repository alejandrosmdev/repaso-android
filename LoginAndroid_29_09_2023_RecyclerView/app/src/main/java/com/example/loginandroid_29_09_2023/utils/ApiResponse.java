package com.example.loginandroid_29_09_2023.utils;

import com.example.loginandroid_29_09_2023.beans.User;

import java.util.ArrayList;

public class ApiResponse {
    private String message;
    private ArrayList<User> lstUsers;


    public String getMessage() {
        return message;
    }
    public ArrayList<User> getLstUsers() {
        return lstUsers;
    }
    public void setLstUsers(ArrayList<User> lstUsers) {
        this.lstUsers = lstUsers;
    }
}
