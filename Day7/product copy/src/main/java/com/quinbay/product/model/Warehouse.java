package com.quinbay.product.model;

import javax.persistence.*;

@Entity
public class Warehouse {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWloc() {
        return wloc;
    }

    public void setWloc(String wloc) {
        this.wloc = wloc;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;
    @Column (name = "wname")
    String wname;
    @Column (name = "wloc")
    String wloc;

    public Warehouse(int id, String wname, String wloc) {
        this.id = id;
        this.wname = wname;
        this.wloc = wloc;
    }



}
