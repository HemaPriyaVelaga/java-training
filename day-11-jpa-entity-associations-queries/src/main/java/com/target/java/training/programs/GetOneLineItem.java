package com.target.java.training.programs;

import com.target.java.training.entity.OrderDetail;
import com.target.java.training.utils.JpaUtil;

import javax.persistence.EntityManager;

public class GetOneLineItem {
    public static void main(String[] args) {
        Integer ordersId = 10249;
        Integer productId = 51;
        EntityManager em = JpaUtil.createEntityManager();
        OrderDetail li = em.find(OrderDetail.class, new OrderDetail(ordersId, productId));
        // Now, to find our desired line item, we need to give both productid and orderid
        // But em.find takes only 2 arguments, not 3
        // In order to pass both of them, make changes in OrderDetails.java
        System.out.println(li);
    }
}
