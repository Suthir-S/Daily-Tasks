package com.quinbay.product.model;

import javax.persistence.*;

@Entity
public class Product {


    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;
    @Column(name = "pname")
    String pname;
    @Column(name = "price")
    int price;
    @Column(name = "gst")
    int gst;

    public Product(int id, String pname, int price, int gst) {
        this.id = id;
        this.pname = pname;
        this.price = price;
        this.gst = gst;
    }

    public int getGst() {
        return gst;
    }

    public void setGst(int gst) {
        this.gst = gst;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return pname;
    }

    public void setName(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public Product() {
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", title=" + pname + ", price=" + price + ", gst=" + gst + "]";
    }


}


