package com.quinbay.product.service;

import com.quinbay.product.kafka.KafkaPublishingService;
import com.quinbay.product.model.Product;
import com.quinbay.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;



@Service
public class ProductService implements ProductInterface {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    KafkaPublishingService kafkaPublishingService;

//    @Autowired
//    Product product;

    @Override
    public ArrayList<Product> findAllProduct() {
        return (ArrayList<Product>) productRepository.findAll();
    }

    @Override
    public ResponseEntity<Product> findAllProductByID(int id) {
        Optional<Product> opt = productRepository.findById(id);
        kafkaPublishingService.productInfo(opt.get());
        if (opt.isPresent())
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);

        else
            return new ResponseEntity<>(opt.get(), HttpStatus.NOT_FOUND);

    }

    @Override
    public String addProduct(ArrayList<Product> inputProduct) {
        for (Product p : inputProduct) {
            Product products = new Product(p.getId(), p.getPcode(), p.getName(), p.getPrice(), p.getGst());
            productRepository.save(products);
        }
        return "Product added";
    }

    @Override
    public void deleteAllData() {
        productRepository.deleteAll();
    }



    @Override
    public String deleteProduct(int id)
    {
        Optional<Product> opt = productRepository.findById(id);
        if (opt.isPresent())
        {
            productRepository.deleteById(id);
            return "Product data deleted successfully";
        }
        return "Product data not deleted";
    }

    @Override
    public String updateProduct(int id, int price) {
        Optional<Product> opt = productRepository.findById(id);
        if (opt.isPresent()) {
            opt.get().setPrice(price);
            productRepository.save(opt.get());
            return "Product data updated successfully";
        }
        return "Product id doesn't exist";
    }
}