package com.target.java.training.programs;

import com.target.java.training.entity.Category;
import com.target.java.training.entity.OrderDetail;
import com.target.java.training.entity.Product;
import com.target.java.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
public class GetAllProductsWithSameOrderId {
    public static void main(String[] args) {
        EntityManager em=null;

        try{
            String jpql = "Product from com.target.java.training.entity.OrderDetail where ORDER_ID = ?0 ";
            em = JpaUtil.createEntityManager();

            TypedQuery<Product> qru = em.createQuery(jpql, Product.class);
            qru.setParameter(0,10294);
            List<Product> orders = qru.getResultList();
            orders.forEach(or -> {
                //System.out.println(or);
                System.out.println("The Products in this order are: " + or);
            });
        }
        finally{
            if(em!=null)
            {
                em.close();
            }
        }

    }
}
