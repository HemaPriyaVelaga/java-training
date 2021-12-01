package com.target.java.training.programs;

import com.target.java.training.entity.Product;
import com.target.java.training.utils.JpaUtil;
import com.target.java.training.utils.KeyboardUtil;

import javax.persistence.EntityManager;

public class GetCustomerWhoOrderedProduct {
    public static void main(String[] args) {
        int productId = KeyboardUtil.getInt("Enter Product Id: ");
        EntityManager em = JpaUtil.createEntityManager();

        Product product = em.find(Product.class, productId);

        product.getLineItems()
                .stream()
                .map(li -> li.getOrder())
                .map(ord -> ord.getCustomer())
                .distinct()
                .map(cust -> cust.getCompanyName())
                .forEach(System.out::println);
    }
}
