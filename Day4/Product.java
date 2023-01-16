package com.example.ProductManagement.interfaces;

import com.example.ProductManagement.models.Products;
import org.springframework.stereotype.Service;


@Service("ProductDetails")

public interface Product {
    Products DisProducts(int pid);

    //public void allocateToRetaier(int id);
}

//interface no service and for implements class interfaceName className
//else give Service(Name)

//postmapping eid pid
//

//add, disp ,allocate(wid,pid)