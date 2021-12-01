package com.training.customerservice.controllers;

import com.training.customerservice.entity.ApiError;
import com.training.customerservice.entity.Customer;
import com.training.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping(value = "/{id}", produces = "text/plain")
    public String handleGetCustomerByIdAsString(@PathVariable String id){

        Customer c = service.getCustomerById(id);
        if(c!=null)
        {
            return service.getCustomerById(id).toString();
        }
        else
        {
            ApiError err = new ApiError(HttpStatus.NOT_FOUND, new Date(), "Customer not found for id " + id);
            return service.getCustomerById(id).toString();
        }
    }


    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> handleGetCustomerById( @PathVariable  String id){

        Customer c = service.getCustomerById(id);
        if(c!=null)
        {
            return ResponseEntity.ok(c);
        }
        else
        {
            throw new CustomerNotFoundException("No CUstomer Found for id" + id);
        }
    }


    @GetMapping(produces = "application/json")
    public Iterable<Customer> handleGetAllCustomersWithPageSizeNum(
            @RequestParam(value = "_page" , required = false, defaultValue = "1")  Integer pageNum,
            @RequestParam(value = "_limit", required = false, defaultValue = "8") Integer pagesize
    )
    {
        return service.getAllCustomers(pageNum, pagesize);
    }
//
//    @GetMapping(produces = "application/json")
//    public Iterable<Customer> handleGetAllCustomers()
//    {
//        return service.getAllCustomers();
//    }

    @GetMapping(path = "/filter", params = {"country"})
    public Iterable<Customer> handleGetCustomerByCountry(@RequestParam String country)
    {
        return service.getCustomersByCountry(country);
    }

    @GetMapping(path = "/filter", params = {"contactTitle"})
    public Iterable<Customer> handleGetCustomerByContactTitle(@RequestParam String contactTitle)
    {
        return service.getCustomersByContactTitle(contactTitle);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> handleAddNewCustomer(@RequestBody Customer customer)
    {
        try {
            Customer p = service.addNewCustomer(customer);
            return  ResponseEntity.ok(p);
        }
        catch (Exception e)
        {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);
        }
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> handleUpdateCustomer(@PathVariable String id, @RequestBody Customer customer)
    {
        try{
            customer.setCustomerId(id);
            Customer p = service.updateCustomer(customer);
            return ResponseEntity.ok(p);
        }
        catch (Exception e)
        {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);

        }
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Object> handleDeleteCustomer(@PathVariable String id)
    {
        try{
            //Hard or soft delete : Check in DefaultProductServie.java
            Customer p = service.deleteCustomer(id);
            return ResponseEntity.ok(p);
        }
        catch (Exception e)
        {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);

        }
    }
}
