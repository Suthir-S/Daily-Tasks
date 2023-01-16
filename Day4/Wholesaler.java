package com.example.ProductManagement.interfaces;

import com.example.ProductManagement.models.Wholesalers;
import org.springframework.stereotype.Service;

@Service("WholesalerDetails")
public interface Wholesaler {
    Wholesalers DisWholesalers(int wid);
}
