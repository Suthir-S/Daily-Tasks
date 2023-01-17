package com.example.com.controller;

import com.example.com.model.Product;
import com.example.com.model.Retailer;
import com.example.com.model.Wholesaler;
import com.example.com.service.GetProductDetails;
import com.example.com.service.GetRetailerDetails;
import com.example.com.service.GetWholesalerDetails;
import com.example.com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/proj")
public class HelloWorldController {
    @Autowired
    ProductService pr;
    @Autowired
    GetProductDetails gpd;
    @Autowired
    GetWholesalerDetails gwd;
    @Autowired
    GetRetailerDetails grd;


    @GetMapping("/Data")
    public String loadData(){
        pr.Service();
        return "data loaded";
    }



    @GetMapping("/Product/{productId}")
    public String viewProduct(@PathVariable int productId)
    {
        //pr.service();
        return gpd.getDetails(productId);
    }

    @GetMapping("/Wholesaler/{wholesalerId}")
    public String viewWholesaler(@PathVariable int wholesalerId){
        return gwd.getDetails(wholesalerId);
    }

    @GetMapping("/Retailer/{retailerId}")
    public String viewRetailer(@PathVariable int retailerId){
        return grd.getDetails(retailerId);
    }

    @PostMapping("/addProduct")
    public String postData(@RequestBody ArrayList<Product> inputProduct)
    {
        return pr.addProduct(inputProduct);
    }

    @PostMapping("/addWholeSaler")
    public String addWholeSaler(@RequestBody ArrayList<Wholesaler> inputWholeSaler)
    {
        return pr.addWholeSaler(inputWholeSaler);
    }

    @PostMapping("/addRetailer")
    public String addRetailer(@RequestBody ArrayList<Retailer> inputRetailer)
    {
        return pr.addRetailer(inputRetailer);
    }

    @PutMapping("/allocateWholeSaler/{wholeSalerId}/{productId}/{itemCountToBuy}")
    public String allocateWholesaler(@PathVariable int wholeSalerId,@PathVariable int productId,@PathVariable int itemCountToBuy){
        pr.allocateWholesaler(wholeSalerId,productId,itemCountToBuy);
        return gwd.getDetails(wholeSalerId);
    }

    @PutMapping("/allocateRetailer/{retailerId}/{wholeSalerId}/{productId}/{itemCountToBuy}")
    public String allocateRetailer(@PathVariable int retailerId,@PathVariable int wholeSalerId,@PathVariable int productId,@PathVariable int itemCountToBuy){
        pr.allocateRetailer(retailerId,wholeSalerId,productId,itemCountToBuy);
        return grd.getDetails(retailerId);
    }




}
