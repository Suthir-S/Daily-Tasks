package com.example.ProductManagement.Controller;

import com.example.ProductManagement.Service.DispProducts;
import com.example.ProductManagement.Service.DispRetailers;
import com.example.ProductManagement.Service.DispWholesalers;
import com.example.ProductManagement.interfaces.Product;
import com.example.ProductManagement.models.Products;
import com.example.ProductManagement.models.Retailers;
import com.example.ProductManagement.models.Wholesalers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/display")

public class ProdManagement {
    @Autowired
    DispProducts p;

    @Autowired
    DispWholesalers w;

    @Autowired
    DispRetailers r;

    @GetMapping("/Products/{pid}")
    public Products DispProducts(@PathVariable int pid){

        return p.DisProducts(pid);
    }

    @GetMapping("/Wholesalers/{wid}")
    public Wholesalers DispWholesaler(@PathVariable int wid){

        return w.DisWholesalers(wid);
    }

    @GetMapping("/Retailers/{rid}")
    public Retailers DispRetailer(@PathVariable int rid){
        return r.DisRetailers(rid);
    }


}
