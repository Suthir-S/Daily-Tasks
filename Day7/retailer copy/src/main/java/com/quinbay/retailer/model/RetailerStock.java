package com.quinbay.retailer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RetailerStock {

    @Id
    @Column(name = "id")
    int id;
    @Column(name = "retailer_id")
    int retailer_id;

    public RetailerStock(int id, int retailer_id, int wholesaler_id, int product_id, int price, int stock) {
        this.id = id;
        this.retailer_id = retailer_id;
        this.wholesaler_id = wholesaler_id;
        this.product_id = product_id;
        this.price = price;
        this.stock = stock;
    }

    @Column(name = "wholesaler_id")
    int wholesaler_id;
    @Column(name = "product_id")
    int product_id;
    @Column(name = "price")
    int price;
    @Column(name = "stock")
    int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRetailer_id() {
        return retailer_id;
    }

    public void setRetailer_id(int retailer_id) {
        this.retailer_id = retailer_id;
    }

    public int getWholesaler_id() {
        return wholesaler_id;
    }

    public void setWholesaler_id(int wholesaler_id) {
        this.wholesaler_id = wholesaler_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }




    /*

    id int primary key,
retailer_id int,
wholesaler_id int,
product_id int,
price int,
stock int,


     */
}
