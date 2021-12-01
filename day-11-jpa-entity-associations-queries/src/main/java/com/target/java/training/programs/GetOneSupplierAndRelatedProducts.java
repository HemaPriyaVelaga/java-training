package com.target.java.training.programs;

import com.target.java.training.entity.Category;
import com.target.java.training.entity.Supplier;
import com.target.java.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetOneSupplierAndRelatedProducts {
    public static void main(String[] args) {
        EntityManager em=null;

        try{

            em= JpaUtil.createEntityManager();
            Supplier s = em.find(Supplier.class, 8);
            log.debug("Supplier Company Name = " + s.getCompanyName());
            log.debug("Supplier Contact Name = " + s.getContactName());
            log.debug("Supplier Phone = " + s.getPhone());
            log.debug("Supplier home page = " + s.getHomePage());
            log.debug("Products dealt by this supplier are: ");
            s.getProductList().forEach(System.out::println);

        }

        finally{
            if(em!=null)
            {
                em.close();
            }
        }

    }
}
