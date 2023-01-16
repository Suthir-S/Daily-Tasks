package com.example.ProductManagement.models;

import com.example.ProductManagement.interfaces.Wholesaler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Wholesalers {
    String wholesaler_name;
    int wholesaler_id;

//    public Wholesalers(String wholesaler_name, int wholesaler_id, ArrayList<Products> wholesaler_product_list) {
//        this.wholesaler_name = wholesaler_name;
//        this.wholesaler_id = wholesaler_id;
//        this.wholesaler_product_list = wholesaler_product_list;
//    }
//
//    ArrayList<Products> wholesaler_product_list = new ArrayList<>();

    public Wholesalers(){}

    public Wholesalers(int wholesaler_id, String wholesaler_name) {
        this.wholesaler_name = wholesaler_name;
        this.wholesaler_id = wholesaler_id;
    }

    public String getWholesaler_name() {
        return wholesaler_name;
    }

    public void setWholesaler_name(String wholesaler_name) {
        this.wholesaler_name = wholesaler_name;
    }

    public int getWholesaler_id() {
        return wholesaler_id;
    }

    public void setWholesaler_id(int wholesaler_id) {
        this.wholesaler_id = wholesaler_id;
    }

//    public void setWholesaler_product_list(Products pr) {
//        this.wholesaler_product_list.add(pr);
//    }
}
