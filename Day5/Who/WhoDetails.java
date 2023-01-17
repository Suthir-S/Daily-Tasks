package com.quinbay.wholesaler.service;

import com.quinbay.wholesaler.api.Display;
import com.quinbay.wholesaler.model.Product;
import com.quinbay.wholesaler.model.Wholesaler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WhoDetails implements Display {
    @Override
        public String getDetails(int id) { //Get wholesaler details according to wholesaler id
            ArrayList<Wholesaler> wholesaler_details = WhoService.wholesaler_details;
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
