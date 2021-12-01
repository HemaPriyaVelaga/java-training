package com.target.java.training.programs;

import com.target.java.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
public class GetOutOfStockProductNamesAndPrices {
    public static void main(String[] args) {
        String jpql = "select productName, unitPrice from Product where unitsInStock=0";

        EntityManager em=null;

        try{
            em= JpaUtil.createEntityManager();
            TypedQuery<Object[]> qry = em.createQuery(jpql, Object[].class);
            List<Object[]> list = qry.getResultList();
            list.forEach(arr -> log.debug("Name = {}, Price = {}", arr[0], arr[1]));
        }
        finally{
            if(em!=null)
            {
                em.close();
            }
        }

    }
}
