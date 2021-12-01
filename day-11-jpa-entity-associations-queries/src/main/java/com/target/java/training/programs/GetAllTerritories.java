package com.target.java.training.programs;

import com.target.java.training.entity.Region;
import com.target.java.training.entity.Territory;
import com.target.java.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
public class GetAllTerritories {
    public static void main(String[] args) {

        EntityManager em = null;

        try{
            em = JpaUtil.createEntityManager();
            TypedQuery<Territory> qry = em.createQuery("from Territory", Territory.class);
            List<Territory> list = qry.getResultList();
            log.debug("There are total " + list.size() + " territories. They are: ");
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
