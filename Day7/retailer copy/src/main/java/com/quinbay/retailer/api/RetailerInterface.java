package com.quinbay.retailer.api;

import com.quinbay.retailer.model.Retailer;

import java.util.ArrayList;

public interface RetailerInterface {
    ArrayList<Retailer> findAllRetailer();
    Retailer findAllRetailerByID(int id);
    void addRetailer(ArrayList<Retailer> inputRetailer);
    void deleteAllData();
}
