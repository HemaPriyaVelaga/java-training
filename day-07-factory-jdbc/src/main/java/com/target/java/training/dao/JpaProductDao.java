package com.target.java.training.dao;

import com.target.java.training.entity.Product;

import java.util.List;

public class JpaProductDao implements ProductDao{
    @Override
    public void addProduct(Product product) throws DaoException {
     //   em.persist(product);
    }

    @Override
    public Product getById(Integer id) throws DaoException {
       // return em.find(Product.class, id);
        return null;
    }

    @Override
    public void updateProduct(Product product) throws DaoException {

    }

    @Override
    public List<Product> getAll() throws DaoException {
        return null;
    }

    @Override
    public List<Product> getPriceRange(Double min, Double max) throws DaoException {
        return null;
    }
}
