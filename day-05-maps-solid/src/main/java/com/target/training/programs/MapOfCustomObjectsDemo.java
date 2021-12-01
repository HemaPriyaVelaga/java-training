package com.target.training.programs;

import com.target.training.entity.Product;
import com.target.training.utils.KeyboardUtil;

import java.util.HashMap;
import java.util.Map;

public class MapOfCustomObjectsDemo {
    public static void main(String[] args) {
        Map<Integer, Product> products= new HashMap<>();

        Product p;
        p = new Product(1, "Apple Iphone", 300.0);
        products.put(p.getId(), p);

        p = new Product(2, "Apple ", 300.0);
        products.put(p.getId(), p);

        p = new Product(3, "Iphone", 300.0);
        products.put(p.getId(), p);

        p = new Product(4, "phone", 300.0);
        products.put(p.getId(), p);

        int id = KeyboardUtil.getInt("Enter ID to search. ");
        if(products.containsKey(id))
        {
            p = products.get(id);
            System.out.println(p);
        }

        else{
            System.out.println("No product found!");
        }
    }
}
