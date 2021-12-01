package com.training.productservice.service;

import com.training.productservice.entity.Product;

public interface ProductService {

    // CRUD
    public Product addNewProduct(Product product);
    public Product getProductById(Integer id);
    public Product updateProduct(Product product);
    public Product deleteProduct(Integer id); // hard delete or soft delete


    // Queries
    public Iterable<Product> getAllProducts(Integer pageNum, Integer pagesize);
    public Iterable<Product> getDiscontinuedProducts();
    public Iterable<Product> getNotDiscontinuedProducts();
    public Iterable<Product> getProductsBetween(Double min, Double max);

}
