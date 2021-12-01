package com.training.customerservice.service;

import com.training.customerservice.entity.Customer;

public interface CustomerService {

    // CRUD
    public Customer addNewCustomer(Customer customer);
    public Customer getCustomerById(String id);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(String id);


    // Queries
    public Iterable<Customer> getAllCustomers(Integer pageNum, Integer pagesize);
    //public Iterable<Customer> getAllCustomers();
    public Iterable<Customer> getCustomersByCountry(String country);
    public Iterable<Customer> getCustomersByContactTitle(String contactTitle);

}
