package com.quinbay.product.api;

import com.quinbay.product.model.Product;

import java.util.ArrayList;

public interface ProductInterface {
    ArrayList<Product> findAllProduct();
    Product findAllProductByID(int id);
    //String updateProduct(int id);
    void addProduct(ArrayList<Product> inputProducts);
    void deleteAllData();
}
