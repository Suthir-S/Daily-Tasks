package com.example.billing.model;

public class Wholesaler {

    int id;

    String whname;

    int whcode;


    public Wholesaler(int id, int whcode, String whname) {
        this.id = id;
        this.whname = whname;
        this.whcode = whcode;
    }
    public Wholesaler(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWhname() {
        return whname;
    }

    public void setWhname(String whname) {
        this.whname = whname;
    }

    public int getWhcode() {
        return whcode;
    }

    public void setWhcode(int whcode) {
        this.whcode = whcode;
    }
}


