package com.quinbay.wholesaler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Wholesaler {

    @Id
    @Column(name = "id")
    int id;

    @Column(name = "wholesaler_name")
    String wholesaler_name;

    @Column(name = "wholesaler_location")
    String wholesaler_location;

    public Wholesaler(int id, String wholesaler_name, String wholesaler_location) {
        this.id = id;
        this.wholesaler_name = wholesaler_name;
        this.wholesaler_location = wholesaler_location;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWholesaler_name() {
        return wholesaler_name;
    }

    public void setWholesaler_name(String wholesaler_name) {
        this.wholesaler_name = wholesaler_name;
    }

    public String getWholesaler_location() {
        return wholesaler_location;
    }

    public void setWholesaler_location(String wholesaler_location) {
        this.wholesaler_location = wholesaler_location;
    }





    public Wholesaler(){

    }

//    public Wholesaler(int wholesaler_id, String wholesaler_name) {
//        this.wholesaler_name = wholesaler_name;
//        this.wholesaler_id = wholesaler_id;
//    }
//
//    public String getWholesaler_name() {
//        return wholesaler_name;
//    }
//
//    public void setWholesaler_name(String wholesaler_name) {
//        this.wholesaler_name = wholesaler_name;
//    }
//
//    public int getWholesaler_id() {
//        return wholesaler_id;
//    }
//
//    public void setWholesaler_id(int wholesaler_id) {
//        this.wholesaler_id = wholesaler_id;
//    }
//
//  public void setWholesaler_product_list(Product pr) {
//        this.wholesaler_product_list.add(pr);
//  }

}

