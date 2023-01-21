package com.quinbay.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product{
    @Id
    @Column(name="id")
    int id;

    @Column(name = "pcode")
    int pcode;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    int price;

    @Column(name = "gst")
    double gst;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }
    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", pcode=" + pcode + ", name=" + name + ", price=" + price +"gst="+gst +"]";
    }





}


