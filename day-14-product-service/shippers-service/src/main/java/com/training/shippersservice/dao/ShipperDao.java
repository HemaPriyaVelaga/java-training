package com.training.shippersservice.dao;

import com.training.shippersservice.entities.Shipper;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperDao extends PagingAndSortingRepository <Shipper, Integer>{

    // @Query("from Shipper where companyName = ?1")
    // The above query is not needed as long as findByXXX has XXX as the name of
    // a variable in the Shipper class

    public Shipper findByCompanyName(String companyName);

}
