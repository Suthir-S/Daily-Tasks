package com.quinbay.product.service;

import com.quinbay.product.api.ProductInterface;
import com.quinbay.product.model.Product;
import com.quinbay.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService implements ProductInterface{
    static ArrayList<Product> products = new ArrayList<>();
    //ArrayList<Product>  = new ArrayList<Product>();
        @Autowired
        ProductRepository productRepository;

        @Override
        public ArrayList<Product> findAllProduct() {
            return (ArrayList<Product>) productRepository.findAll();
    }
        @Override
        public Product findAllProductByID (int id) {
            Optional<Product> opt = productRepository.findById(id);
            if (opt.isPresent())
                return opt.get();
            else
                return null;
            }


    @Override
        public void addProduct(ArrayList<Product> inputProducts) {
        for (Product pro : inputProducts) {
            Product newProduct  = new Product(pro.getId(),pro.getName(),pro.getPrice(),pro.getGst());
            productRepository.save(newProduct);
        }
    }
        @Override
        public void deleteAllData() {
        productRepository.deleteAll();
    }
    }
//        try {
//            String line = "";
//            String splitBy = ",";
//            BufferedReader sc1 = new BufferedReader(new FileReader("/Users/suthir/Downloads/Product1.csv"));
//            while ((line = sc1.readLine()) != null) // returns a Boolean value
//            {
//                String[] productSplit = line.split(splitBy); // use comma as separator
//                products.add(new Product(Integer.parseInt(productSplit[0]), productSplit[1],
//                        Integer.parseInt(productSplit[2]), Integer.parseInt(productSplit[3])));
//            }
//            sc1.close();
//
//
//        } catch (Exception e) {
//
//        }
//    }
//
//    public static String addProduct(ArrayList<Product> inputProducts) {
//        for(Product input:inputProducts) {
//            Product newProduct = new Product(input.getId(), input.getName(), input.getPrice(), input.getStock());
//            products.add(newProduct);
//        }
//
//        String str = "";
//        for (Product p : products) {
//            str += p.getId() + " " + p.getName() + " " + p.getPrice() + " " + p.getStock() + "\n";
//        }
//        return str;
//    }
//    public static String updateProduct(Product inputProduct){
//            for (Product pr : products) {
//                if (inputProduct.getId() == pr.getId()) {
//                    pr.setStock(inputProduct.getStock());
//                }
//            }
//            return "Product updated";
//        }
//
//    public static String deleteProduct(int productId) {
//            int count = 0;
//            int delIndex =0;
//            boolean flag=false;
//            for (Product pr : products) {
//                if (productId == pr.getId()) {
//                    System.out.println(pr.getId());
//                    delIndex=count;
//                    flag=true;
//                }
//                count++;
//
//            }
//            if(flag==true) {
//                products.remove(delIndex);
//            }
//
//            String str = "";
//            for (Product p : products) {
//                str += p.getId() + " " + p.getName() + " " + p.getPrice() + " " + p.getStock() + "\n";
//            }
//
//            return str;
//
//
//    }
//    public static ArrayList<Product> getAllProducts()
//    {
//        return products;
//    }

