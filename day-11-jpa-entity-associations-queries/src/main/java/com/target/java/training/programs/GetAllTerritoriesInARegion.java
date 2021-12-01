package com.target.java.training.programs;

import com.target.java.training.entity.Region;
import com.target.java.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetAllTerritoriesInARegion {

    public static void main(String[] args) {

        EntityManager em=null;
        try{
            em= JpaUtil.createEntityManager();
            Region c = em.find(Region.class, 1);
            log.debug("Region Description = " + c.getRegionDescription());
            log.debug("Territories in this Region are: " + c.getTerritories().size());
            c.getTerritories().forEach(System.out::println);
        }
        finally{
            if(em!=null)
            {
                em.close();
            }
        }
    }
}
