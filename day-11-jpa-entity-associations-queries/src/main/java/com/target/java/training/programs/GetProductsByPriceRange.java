package com.target.java.training.programs;

import com.target.java.training.entity.Product;
import com.target.java.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j

public class GetProductsByPriceRange {
    public static void main(String[] args) {
        Double min = 50.0;
        Double max = 100.0;

        EntityManager em=null;

        try{
            em= JpaUtil.createEntityManager();

            String jpql = "from Product where unitPrice between ?0 and ?1 order by unitPrice";
            // Can be written in the following way also
            //String jpql = "from Product where unitPrice between :MIN_PRICE and :MAX_PRICE order by unitPrice";
            TypedQuery<Product> qry = em.createQuery(jpql, Product.class);
            qry.setParameter(0, min);
            qry.setParameter(1, max);

//            qry.setParameter(MIN_PRICE, min);
//            qry.setParameter(MAX_PRICE, max);
            List<Product> list = qry.getResultList();
            list.forEach(p -> log.debug("Name = {}, Price = {}", p.getProductName(), p.getUnitPrice()));
        }
        finally{
            if(em!=null)
            {
                em.close();
            }
        }

    }
}
