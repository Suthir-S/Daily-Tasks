package com.example.com.service;

import com.example.com.model.FetchDetails;
import com.example.com.model.Product;
import com.example.com.model.Wholesaler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class GetWholesalerDetails implements FetchDetails {
    @Override
    public String getDetails(int id) {
        ArrayList<Wholesaler> wholesaler_details = ProductService.wholesaler_details;
        String str="";
        for (Wholesaler itr : wholesaler_details) {
            if (itr.getWholesaler_id() == id) {

                str += itr.getWholesaler_id()+" "+itr.getWholesaler_name();
                for(Product pr: itr.wholesaler_product_list)
                {
                    str += " ("+pr.getId()+" "+pr.getName()+" "+pr.getPrice()+" "+pr.getStock()+") ";
                }
            }
        }
        return str;

    }
}

