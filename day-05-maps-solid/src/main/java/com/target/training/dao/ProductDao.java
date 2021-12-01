package com.target.training.dao;

import com.target.training.entity.Product;

import java.util.List;

public interface ProductDao {
    // CRUD operations
    public void addProduct(Product product) throws DaoException;
    public Product getById(Integer id) throws DaoException;
    public void updateProduct(Product product) throws DaoException;

    // Queries
    public List<Product> getAll() throws DaoException;
    public  List<Product> getPriceRange(Double min, Double max) throws DaoException;


}
