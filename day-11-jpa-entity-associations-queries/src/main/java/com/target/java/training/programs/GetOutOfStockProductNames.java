package com.target.java.training.programs;

import com.target.java.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
@Slf4j
public class GetOutOfStockProductNames {
    public static void main(String[] args) {
        String jpql = "select productName from Product where unitsInStock=0";

        EntityManager em=null;

        try{
            em= JpaUtil.createEntityManager();
            // Since the output will be only one column values, that too string, we can use String class
            // Else, if it is multiple columns or Not string values, we cant use the class
            TypedQuery<String> qry = em.createQuery(jpql, String.class);
            List<String> list = qry.getResultList();
            list.forEach(log::debug);
        }
        finally{
            if(em!=null)
            {
                em.close();
            }
        }

    }
}
