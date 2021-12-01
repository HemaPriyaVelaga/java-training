package com.training.productservice.service;

import com.training.productservice.dao.ProductDao;
import com.training.productservice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
// Instructs Spring to create and load an instance of this class into the spring container
public class DefaultProductService implements  ProductService{

    // Depends on product Dao (The following aids Dependency Injection by Spring)
    @Autowired
    private ProductDao dao;

    @Override
    public Product addNewProduct(Product product) {
        // In order to ensure that save() does INSERT, we have to set product_id to null
        product.setProductId(null);

        // perform validations about product members before saving
        return dao.save(product);
    }

    @Override
    public Product getProductById(Integer id) {

        Optional<Product> op = dao.findById(id);
        return op.isPresent()?op.get():null;
    }

    @Override
    public Product updateProduct(Product product) {
        if(product.getProductId()==null)
        {
            // throw a custom exception and not runtime exception
            throw new RuntimeException("Product Must have Id for updating!");
        }
        if(!dao.existsById(product.getProductId()))
        {
            throw new RuntimeException("Invalid Id, Couldnt update the product");
        }
        // Do all the other validations before saving
        return dao.save(product);
    }

    @Override
    public Product deleteProduct(Integer id) {
        if(!dao.existsById(id))
        {
            throw new RuntimeException("Product doesnt exist.");
        }

        //Hard Delete
        //dao.deleteById(id);
        // return p; // To display the product that has been permanently deleted from the table

        // Soft delete
        Product p = dao.findById(id).get();
        p.setDiscontinued(1);
        return dao.save(p);

        /* OTHER WAY

        Optional <Product> op = dao.findById(id);
        if(!op.isPresent())
        {
            throw new RuntimeException("Product has invalid Id. Could not delete.");
        }
        Product p = op.get();

        // Perform delete here

        return op.get();

         */
    }

    @Override
    public Iterable<Product> getAllProducts(Integer pageNum, Integer pagesize) {
        PageRequest p = PageRequest.of(pageNum - 1, pagesize);
        Page<Product> result = dao.findAll(p);

        if(result.hasContent())
        {
            return result.getContent();
        }
        else
        {
            return new ArrayList<>()
;        }
        //
        // Since the class ArrayList is not having the XML authorization, we cant print it in xml
        // until we create a wrapper class
    }

    @Override
    public Iterable<Product> getDiscontinuedProducts() {
        return dao.findByDiscontinued(1);
    }

    @Override
    public Iterable<Product> getNotDiscontinuedProducts() {
        return dao.findByDiscontinued(0);
    }

    @Override
    public Iterable<Product> getProductsBetween(Double min, Double max) {
        return dao.findProductsByPriceRange(min, max);
    }

}
