package com.target.java.training.programs;

import com.target.java.training.entity.Product;
import com.target.java.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
@Slf4j
public class GetAllProducts {
    public static void main(String[] args) {

        EntityManager em = null;

        try{
            em = JpaUtil.createEntityManager();

            // We are building a query obj, that , once ready, can get
            // a list of products
            TypedQuery<Product> qry = em.createQuery("from Product", Product.class);
            // give the class name and NOT THE TABLE NAME
            List<Product> list = qry.getResultList();
            // fire the SQL SELECT statement now
            // and get the data in List<T> format

            list.forEach(System.out::println);
        }
        finally {
            if(em!=null)
            {
                em.close();
            }
        }

    }
}
