package com.quinbay.wholesaler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @Column(name = "id")
    int id;
    @Column(name = "pname")
    String pname;
    @Column(name = "price")
    int price;
    @Column(name = "gst")
    int gst;

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

    public int getStock() {
        return gst;
    }

    public void setStock(int gst) {
        this.gst = gst;
    }

    public Product() {
    }

    public Product(int id, String pname, int price, int gst) {
        this.id = id;
        this.pname = pname;
        this.price = price;
        this.gst = gst;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", title=" + pname + ", price=" + price + ", gst=" + gst + "]";
    }

}
