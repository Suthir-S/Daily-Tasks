package com.example.ProductManagement.Service;
import com.example.ProductManagement.models.Products;
import com.example.ProductManagement.models.Retailers;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

@Service
public class DispRetailers {
    static ArrayList<Retailers> retailer_details = new ArrayList<>();
    String line = "";
    String splitBy = ",";
    public Retailers DisRetailers(int rid) {
        try {
            BufferedReader sc2 = new BufferedReader(new FileReader("/Users/suthir/Downloads/Retailer.csv"));
            while ((line = sc2.readLine()) != null) // returns a Boolean value
            {
                String[] productSplit = line.split(splitBy); // use comma as separator
                retailer_details.add(new Retailers(Integer.parseInt(productSplit[0]), productSplit[1]));
            }
            sc2.close();
        } catch (Exception f) {
            System.out.println(f);
        }
        Retailers ne = retailer_details.get(0);
        for (Retailers r : retailer_details)
            if (r.getRetailer_id() == rid)
                ne = r;
        return ne;
    }
}
