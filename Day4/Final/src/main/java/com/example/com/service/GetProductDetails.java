package com.example.com.service;

import com.example.com.model.FetchDetails;
import com.example.com.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class GetProductDetails implements FetchDetails {
    @Override
    public String getDetails(int id){
        ArrayList<Product> products = ProductService.products;
        for (Product itr : products) {
            if (itr.getId() == id) {
                return itr.getId()+" "+itr.getName()+" "+itr.getPrice()+" "+itr.getStock();

            }
        }
        return "No products found";
    }
}
