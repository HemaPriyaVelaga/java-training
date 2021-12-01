package com.target.java.training.programs;

import com.target.java.training.entity.Shipper;
import com.target.java.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;


@Slf4j
public class GetAllOrdersWithSameShipper {
    public static void main(String[] args) {
        EntityManager em = null;

        try {
            em = JpaUtil.createEntityManager();
            Shipper shipper = em.find(Shipper.class, 2);
            log.debug("Shipper Id                     : " + shipper.getShipperId());
            log.debug("Shipper Company                : " + shipper.getCompanyName());
            log.debug("Shipper Phone                  : " + shipper.getPhone());
            log.debug("Orders shipped by this shipper are: " + shipper.getOrderList().size());
            shipper.getOrderList().forEach(System.out::println);
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }


}
