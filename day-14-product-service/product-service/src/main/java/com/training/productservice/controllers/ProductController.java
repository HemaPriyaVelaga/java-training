package com.training.productservice.controllers;

import com.training.productservice.entity.ApiError;
import com.training.productservice.entity.Product;
import com.training.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@RestController // Instructs spring to create and load an instance of this class into the spring container
@RequestMapping("/api/products") // Instructs handler-mapping to make a note of all handler methods
public class ProductController {

    // dependency
    @Autowired // Instructs spring to find a suitable object of type ProductService and assign the same
    ProductService service;

//    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
//    public Product handleGetProductById(@PathVariable Integer id)
//    {
//        return service.getProductById(id);
//    }

    @GetMapping(value = "/{id}", produces = "text/plain")
    public String handleGetProductByIdAsString(@PathVariable Integer id)
    {
        return service.getProductById(id).toString();
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<Object> handleGetProductById(@PathVariable Integer id)
    {
        Product p = service.getProductById(id);
        if(p!=null)
        {
            return ResponseEntity.ok(p);
        }
        else
        {
           // return ResponseEntity.notFound().build();
            ApiError err = new ApiError(HttpStatus.NOT_FOUND, new Date(), "Product not found for id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
        }
    }


    @GetMapping(produces = {"application/json", "application/xml"})
    public Iterable<Product> handleGetAllProducts(
            @RequestParam(value = "_page" , required = false, defaultValue = "1")  Integer pageNum,
            @RequestParam(value = "_limit", required = false, defaultValue = "8") Integer pagesize)
    {
        return service.getAllProducts(pageNum, pagesize);
    }

    // api/products?discontinued=true
    @GetMapping(path = "/filter", params = {"discontinued"})
    public Iterable<Product> handleGetDiscontinuedProducts(@RequestParam Boolean discontinued) {
        return discontinued ? service.getDiscontinuedProducts() : service.getNotDiscontinuedProducts();
    }

    @GetMapping(path = "/filter", params = {"min", "max"})
    public Iterable<Product> handleGetProductsInPriceRange(@RequestParam Double min, @RequestParam Double max) {
        return service.getProductsBetween(min, max);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> handleAddNewProduct(@RequestBody Product product)
    {
        // How does spring know and construct a product based on user input??
        // Add @RequestBody. The Spring then takes help of jackson to convert it
        // from json to java object
        // Use DTO instead of Entity class, transform that to the required format and return it

        try {
            Product p = service.addNewProduct(product);
            return  ResponseEntity.ok(p);
        }
        catch (Exception e)
        {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);
        }

        // Hibernate is internally maintaining the last product_Id
        // From the next time, it uses its internally maintained ID when updating or doing something
        // So, in docker, if we change something in the related database or table,
        // Rerun the ProductServiceApplication
    }


    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> handleUpdateProduct(@PathVariable Integer id, @RequestBody Product product)
    {

        try{
            product.setProductId(id);
            Product p = service.updateProduct(product);
            return ResponseEntity.ok(p);
        }
        catch (Exception e)
        {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);

        }
    }

    @DeleteMapping(path = "/{id}", produces = "application/json") // doesnt have consumes field
    public  ResponseEntity<Object> handleDeleteProduct(@PathVariable Integer id)
    {
        try{
            //Hard or soft delete : Check in DefaultProductServie.java
            Product p = service.deleteProduct(id);
            return ResponseEntity.ok(p);
        }
        catch (Exception e)
        {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);

        }
    }
}

