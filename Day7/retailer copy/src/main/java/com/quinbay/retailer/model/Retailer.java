package com.quinbay.retailer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Retailer {

    @Id
    @Column(name = "id")
    int id;
    @Column(name = "retailer_name")
    String retailer_name;
    @Column(name = "retailer_ref")
    int retailer_ref;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRetailer_name() {
        return retailer_name;
    }

    public void setRetailer_name(String retailer_name) {
        this.retailer_name = retailer_name;
    }

    public int getRetailer_ref() {
        return retailer_ref;
    }

    public void setRetailer_ref(int retailer_ref) {
        this.retailer_ref = retailer_ref;
    }


    public Retailer(int id, String retailer_name, int retailer_ref) {
        this.id = id;
        this.retailer_name = retailer_name;
        this.retailer_ref = retailer_ref;
    }



  //  public ArrayList<Product> retailer_product_list = new ArrayList<Product>();

//    public Retailer(){
//
//    }
//
//    public Retailer(int retailer_id, String retailer_name) {
//        this.retailer_name = retailer_name;
//        this.retailer_id = retailer_id;
//    }
//
//    public String getRetailer_name() {
//        return retailer_name;
//    }
//
//    public void setRetailer_name(String retailer_name) {
//        this.retailer_name = retailer_name;
//    }
//
//    public int getRetailer_id() {
//        return retailer_id;
//    }
//
//    public void setRetailer_id(int retailer_id) {
//        this.retailer_id = retailer_id;
//    }
//
//  //  public void setRetailerProductList(Product pr) {
 //       this.retailer_product_list.add(pr);
   // }
}
