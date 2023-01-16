package com.example.ProductManagement.Service;

import com.example.ProductManagement.interfaces.Wholesaler;
//import com.example.ProductManagement.models.Products;
import com.example.ProductManagement.models.Wholesalers;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

@Service
public class DispWholesalers implements Wholesaler{
    static ArrayList<Wholesalers> wholesaler_details = new ArrayList<>();

    public Wholesalers DisWholesalers(int wid) {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader sc2 = new BufferedReader(new FileReader("/Users/suthir/Downloads/wholesaler.csv"));
            while ((line = sc2.readLine()) != null) // returns a Boolean value
            {
                String[] productSplit = line.split(splitBy); // use comma as separator
                wholesaler_details.add(new Wholesalers(Integer.parseInt(productSplit[0]), productSplit[1]));
            }
            sc2.close();
        }
        catch (Exception f) {
            System.out.println(f);
        }
        Wholesalers ne = wholesaler_details.get(0);
        for (Wholesalers w : wholesaler_details)
            if(w.getWholesaler_id() == wid)
                ne = w;
        return ne;
    }
}
