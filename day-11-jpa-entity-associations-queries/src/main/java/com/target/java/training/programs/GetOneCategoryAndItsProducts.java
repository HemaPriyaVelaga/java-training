package com.target.java.training.programs;

import com.target.java.training.entity.Category;
import com.target.java.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
@Slf4j
public class GetOneCategoryAndItsProducts {


    public static void main(String[] args) {
        EntityManager em=null;

        try{
            em= JpaUtil.createEntityManager();
            Category c = em.find(Category.class, 8);
            log.debug("Category Name = " + c.getCategoryName());
            log.debug("Category Description = " + c.getDescription());
            log.debug("Products in this category are: ");
            c.getProductList().forEach(System.out::println);
            // System.out::println = Method Reference
            // We are printing all the products in the list
            // without using a for loop

        }
        finally{
            if(em!=null)
            {
                em.close();
            }
        }

    }
}
