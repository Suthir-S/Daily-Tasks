package com.quinbay.product.controller;

import com.quinbay.product.model.Product;
import com.quinbay.product.repository.ProductRepository;
import com.quinbay.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class ProductMain {
    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/")
    public void add(@RequestBody ArrayList<Product> inputProducts) {
        productService.addProduct( inputProducts);
    }

//    @PutMapping("update/{id}")
//    public String updateProduct(@PathVariable int id , @RequestBody Product pro) {
//        return productService.updateProduct(id);
//    }

    @GetMapping("/findall")
    public ArrayList<Product> getAllProduct() {
        return productService.findAllProduct();
    }

    @GetMapping("/findbyid/{id}")
    public Product getProductUsingId(@PathVariable int id) {
        return productService.findAllProductByID(id);
    }

    @DeleteMapping("/delete")
    public void delete() {
        productService.deleteAllData();
    }
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
//    @GetMapping("/getAllProducts")
//    public ArrayList<Product> getAllProducts()
//    {
//        return productService.getAllProducts();
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
//

//    public static void main( String args[] ) {
//        Connection c = null;
//        Statement stmt = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            c = DriverManager
//                    .getConnection("jdbc:postgresql://localhost:5432/employee",
//                            "postgres", "123");
//            System.out.println("Opened database successfully");
//
//            stmt = c.createStatement();
//            String sql = "insert into sample (id,name,role) "+
//                    "values (1,'Suthir','Intern')," +
//                    "(2,'Mahin','Intern')," +
//                    "(3,'Kishor','Dev');" ;
//            stmt.executeUpdate(sql);
//
//            ResultSet rs = stmt.executeQuery( "select * from sample;" );
//            while ( rs.next() ) {
//                int id = rs.getInt("id");
//                String  name = rs.getString("name");
//                String role = rs.getString("role");
//                System.out.println( "Id = " + id );
//                System.out.println( "Name = " + name );
//                System.out.println( "Role = " + role );
//                System.out.println();
//            }
//
//            stmt.close();
//            c.close();
//        } catch ( Exception e ) {
//            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//            System.exit(0);
//        }
//        System.out.println("Table created successfully");
//    }

}

