package com.target.java.training.dao;

import com.target.java.training.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class ArrayListProductDao implements ProductDao {

    private List<Product> list = new ArrayList<>();

    public  ArrayListProductDao(){
        list.add(new Product(1, "Apple Iphone", 300.0));
        list.add(new Product(2, "Macbook", 2300.0));
        list.add(new Product(3, "Oppo F11", 100.0));
        list.add(new Product(4, "Poco M3 pro", 90.0));


    }


    @Override
    public void addProduct(Product product) throws DaoException {
        if (product==null)
        {
            throw new DaoException("Cant be null product.");
        }

        if(product.getId()==null || product.getId()<=0)
        {
            throw new DaoException("Id cant be null or 0 or negative.");
        }
        // do more validations

        list.add(product);
    }

    @Override
    public Product getById(Integer id) throws DaoException {
        throw new DaoException("Method not implemented Yet");
    }

    @Override
    public void updateProduct(Product product) throws DaoException {
        throw new DaoException("Method not implemented Yet");
    }

    @Override
    public List<Product> getAll() throws DaoException {
        return  this.list;
    }

    @Override
    public List<Product> getPriceRange(Double min, Double max) throws DaoException {


       List<Product> emptyList = new ArrayList<>();
       return  emptyList;
    }
}
