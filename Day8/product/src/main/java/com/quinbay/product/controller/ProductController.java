package com.quinbay.product.controller;

import com.quinbay.product.model.Product;
//import com.quinbay.product.service.ProductDetails;
import com.quinbay.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public String postData(@RequestBody ArrayList<Product> inputProduct)
    {
        return productService.addProduct(inputProduct);
    }

    @GetMapping("/findall")
    public ArrayList<Product> getAllProduct() {
        return productService.findAllProduct();
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Product> getProductUsingId(@PathVariable int id) {
        return productService.findAllProductByID(id);
    }

    @DeleteMapping("/deletebyid/{id}")
    public String deleteProductUsingId(@PathVariable(value = "id") Integer id){
        return productService.deleteProduct(id);
    }

    @DeleteMapping("/delete")
    public void delete() {
        productService.deleteAllData();
    }

    @PutMapping("/update/{id}/{price}")
    public String updateProduct( @PathVariable int id,@PathVariable int price) {
        return productService.updateProduct(id,price);
    }


//    @Autowired
//    ProductService productService;
//    @Autowired
//    ProductDetails productDetails;
//
//    @GetMapping("/loadData")
//    public String loadData(){
//        productService.Service();
//        return "Data loaded";
//    }
//
//    @GetMapping("/displayProduct/{productId}")
//    public String viewProduct(@PathVariable int productId)
//    {
//        //pr.Service();
//        return productDetails.getDetails(productId);
//    }
//    @GetMapping("/getProducts")
//    public ArrayList<Product> getProducts()
//    {
//        return productService.getProducts();
//    }
//    @PostMapping("/addProduct")
//    public String postData(@RequestBody ArrayList<Product> inputProduct)
//    {
//        return productService.addProduct(inputProduct);
//    }
//    @PostMapping("/updateProduct")
//    public String updateProduct(@RequestBody Product inputProduct)
//    {
//        return productService.updateProduct(inputProduct);
//    }
//    @DeleteMapping("/deleteProduct/{productId}")
//    public String deleteProduct(@PathVariable int productId)
//    {
//        return productService.deleteProduct(productId);
//    }

}
