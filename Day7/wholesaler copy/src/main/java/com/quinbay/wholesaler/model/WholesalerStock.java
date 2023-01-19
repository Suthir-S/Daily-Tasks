package com.quinbay.wholesaler.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class WholesalerStock {

    @Id
    @Column(name = "id")
    int id;

    @Column(name = "wholesaler_id")
    int wholesaler_id;

    @Column(name = "warehouse_id")
    int warehouse_id;

    @Column(name = "product_id")
    int product_id;

    @Column(name = "price")
    int price;

    @Column(name = "stock")
    int stock;

    public ArrayList<Product> wholesaler_product_list = new ArrayList<>();

    public WholesalerStock(int id, int wholesaler_id, int warehouse_id, int product_id, int price, int stock) {
        this.id = id;
        this.wholesaler_id = wholesaler_id;
        this.warehouse_id = warehouse_id;
        this.product_id = product_id;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWholesaler_id() {
        return wholesaler_id;
    }

    public void setWholesaler_id(int wholesaler_id) {
        this.wholesaler_id = wholesaler_id;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
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
wholesaler_id int,
warehouse_id int,
product_id int,
price int,
stock int,


 */
}
