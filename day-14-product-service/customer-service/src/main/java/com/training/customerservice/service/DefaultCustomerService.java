package com.training.customerservice.service;

import com.training.customerservice.dao.CustomerDao;
import com.training.customerservice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class DefaultCustomerService implements CustomerService{

    @Autowired
    private CustomerDao customerDao;


    @Override
    public Customer addNewCustomer(Customer customer) {
        // Override the defualt find by Id method which takes integer methods
        // In customer Dao
        if(customerDao.findCustomerById(customer.getCustomerId())!=null)
        {
            throw new RuntimeException("Customer of id " + customer.getCustomerId() + " already exists! " +
                    "Please give some other Id and try again.");
        }
        return customerDao.save(customer);
    }

    @Override
    public Customer getCustomerById(String id) {
        if(customerDao.findCustomerById(id)==null)
        {
            throw new RuntimeException("Customer of id " + id + " doesnt exist! ");
        }
        return  customerDao.findCustomerById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if(customer.getCustomerId()==null)
        {
            // throw a custom exception and not runtime exception
            throw new RuntimeException("Customer Id is necessary for updating details!");
        }
        if(customerDao.findCustomerById(customer.getCustomerId())==null)
        {
            throw new RuntimeException("Invalid Id, Couldn't update the product");
        }
        // Do all the other validations before saving
        return customerDao.save(customer);
    }

    @Override
    public Customer deleteCustomer(String id) {
        if(customerDao.findCustomerById(id)==null)
        {
            throw new RuntimeException("The specified Customer doesnt exist.");
        }

        //Hard Delete
        Customer c = customerDao.findCustomerById(id);
        customerDao.deleteCustomerById(id);
        return c; // To display the product that has been permanently deleted from the table

    }

    @Override
    public Iterable<Customer> getAllCustomers(Integer pageNum, Integer pagesize) {
        PageRequest p = PageRequest.of(pageNum - 1, pagesize);
        Page<Customer> result = customerDao.findAll(p);

        if(result.hasContent())
        {
            return result.getContent();
        }
        else
        {
            return new ArrayList<>();
        }
    }

//    @Override
//    public Iterable<Customer> getAllCustomers() {
//        return customerDao.findAll();
//    }

    @Override
    public Iterable<Customer> getCustomersByCountry(String country) {
        return customerDao.findCustomersByCountry(country);
    }

    @Override
    public Iterable<Customer> getCustomersByContactTitle(String contactTitle) {
        return customerDao.findCustomersByContactTitle(contactTitle);
    }
}
