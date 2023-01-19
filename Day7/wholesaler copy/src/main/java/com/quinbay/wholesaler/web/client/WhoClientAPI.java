//package com.quinbay.wholesaler.web.client;
//
//import com.quinbay.wholesaler.model.Product;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//import java.lang.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//@Component
//public class WhoClientAPI {
//    @Autowired
//    RestTemplate restTemplate;
//
//    public Product[] getAllProducts(){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<Product> entity = new HttpEntity<Product>(headers);
//       return  restTemplate.exchange("http://localhost:8080/getAllProducts",HttpMethod.GET,entity,Product[].class).getBody();
//
//    }
//
//    public String updateProduct(Product products){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<Product> entity = new HttpEntity<Product>(products,headers);
//        return restTemplate.exchange("http://localhost:8080/updateProduct",HttpMethod.POST,entity,String.class).getBody();
//
//    }
//
//    public String getProductDetails(@PathVariable int productId){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/")
//                .queryParam("productId",productId)
//                .toUriString();
//        HttpEntity<String> entity =new HttpEntity<String>(headers);
//        return restTemplate.exchange(url,HttpMethod.GET,entity,String.class).getBody();
//    }
//}
