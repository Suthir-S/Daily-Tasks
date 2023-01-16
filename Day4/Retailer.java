package com.example.ProductManagement.interfaces;


import com.example.ProductManagement.models.Retailers;
import org.springframework.stereotype.Service;

@Service("RetailerDetails")
public interface Retailer {
    Retailers DisRetailers(int rid);
}
