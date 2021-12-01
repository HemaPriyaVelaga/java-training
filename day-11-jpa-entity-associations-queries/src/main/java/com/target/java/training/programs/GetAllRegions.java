package com.target.java.training.programs;

import com.target.java.training.entity.Product;
import com.target.java.training.entity.Region;
import com.target.java.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
public class GetAllRegions {

    public static void main(String[] args) {

        EntityManager em = null;

        try{
            em = JpaUtil.createEntityManager();
            TypedQuery<Region> qry = em.createQuery("from Region", Region.class);
            // give the class name and NOT THE TABLE NAME
            List<Region> list = qry.getResultList();
            // fire the SQL SELECT statement now
            // and get the data in List<T> format

            list.forEach(
                    region->{
                        log.debug("Region Id: " + region.getRegionId() + " and Description: " + region.getRegionDescription());
                    }
            );
        }
        finally {
            if(em!=null)
            {
                em.close();
            }
        }

    }
}
