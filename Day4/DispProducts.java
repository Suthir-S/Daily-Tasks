package com.example.ProductManagement.Service;

import com.example.ProductManagement.interfaces.Product;
import com.example.ProductManagement.models.Products;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

@Service
public class DispProducts implements Product {
    static ArrayList<Products> products = new ArrayList<>();

   public Products DisProducts(int pid) {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader sc1 = new BufferedReader(new FileReader("/Users/suthir/Downloads/Product1.csv"));
            while ((line = sc1.readLine()) != null) // returns a Boolean value
            {
                String[] productSplit = line.split(splitBy); // use comma as separator
                products.add(new Products(Integer.parseInt(productSplit[0]), productSplit[1], Integer.parseInt(productSplit[2]), Integer.parseInt(productSplit[3])));
            }
            sc1.close();
        } catch (Exception f) {
            System.out.println(f);
        }

        Products ne = products.get(0);
        for (Products p : products)
            if(p.getId() == pid)
                 ne = p;
        return ne;
    }
}
