package com.quinbay.product.model;

import javax.persistence.*;

@Entity
public class WarehouseStock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;
    @Column(name = "wareid")
    int wareid;
    @Column(name  = "pid")
    int pid;
    @Column(name = "stock")
    int stock;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWareid() {
        return wareid;
    }

    public void setWareid(int wareid) {
        this.wareid = wareid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public WarehouseStock(int id, int wareid, int pid, int stock) {
        this.id = id;
        this.wareid = wareid;
        this.pid = pid;
        this.stock = stock;
    }


}
