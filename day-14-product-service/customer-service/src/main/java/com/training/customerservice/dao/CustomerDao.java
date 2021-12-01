package com.training.customerservice.dao;

import com.training.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerDao extends PagingAndSortingRepository<Customer, Integer> {
    // We dont need to write anything here, its taken care of by the Repository

    @Query("from Customer where customer_id = ?1")
    public Customer findCustomerById(String id);

    @Transactional
    @Modifying
    @Query("delete from Customer where customer_id = ?1")
    public void deleteCustomerById(String id);

    @Query("from Customer where country = ?1")
    public Iterable<Customer> findCustomersByCountry(String str);

    @Query("from Customer where contact_title = ?1")
    public Iterable<Customer> findCustomersByContactTitle(String str);


}
