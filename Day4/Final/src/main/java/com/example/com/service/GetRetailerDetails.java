package com.example.com.service;

import com.example.com.model.FetchDetails;
import com.example.com.model.Product;
import com.example.com.model.Retailer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class GetRetailerDetails implements FetchDetails {
    @Override
    public String getDetails(int id) {
        ArrayList<Retailer> retailer_details = ProductService.retailer_details;
        String str="";
        for (Retailer itr : retailer_details) {
            if (itr.getRetailer_id() == id) {

                str += itr.getRetailer_id()+" "+itr.getRetailer_name();
                for(Product pr: itr.retailer_product_list)
                {
                    str += " ("+pr.getId()+" "+pr.getName()+" "+pr.getPrice()+" "+pr.getStock()+") ";
                }
            }
        }
        return str;

    }
}
