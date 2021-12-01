package com.target.java.training.dao;

import com.target.java.training.assignment.entities.Contact;
import com.target.java.training.entity.Product;
import com.target.java.training.utils.DbUtil;
import lombok.extern.slf4j.Slf4j;

import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Slf4j

public class JdbcProductDao implements ProductDao {
    @Override
    public void addProduct(Product product) throws DaoException {

        String sql = "insert into products values (?,?,?)";

        try(
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
                ){
            stmt.setInt(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setDouble(3, product.getPrice());

            stmt.execute();

        }
        catch (Exception ex)
        {
            throw new DaoException(ex);
        }
    }

    @Override
    public Product getById(Integer id) throws DaoException {

        String sql = "SELECT * FROM products WHERE id = ?";
        try(
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {

            stmt.setInt(1, id);

            try {

                ResultSet rs = stmt.executeQuery();
                if(rs.next())
                {
                    Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
                    return p;
                }

            }

            catch (Exception ex)
            {
                log.debug("Error while displaying contacts!" + ex.getMessage());
            }
        }
        catch (Exception ex)
        {
            log.debug("Problem occurred! " + ex.getMessage());
        }

       return null;
    }

    @Override
    public void updateProduct(Product product) throws DaoException {
        String sql = "UPDATE products SET Name=?, Price=? WHERE id=?";
        try(
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ) {

            stmt.setInt(3, product.getId());
            stmt.setDouble(2, product.getPrice());
            stmt.setString(1, product.getName());
            stmt.execute();

        }
        catch (Exception ex)
        {
            throw new DaoException(ex);
        }

    }

    @Override
    public List<Product> getAll() throws DaoException {
        List<Product> list = new ArrayList<>();
        String sql = "select * from products";
        try(Connection conn = DbUtil.createConnection(); // Just establishes connection
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while ( rs.next()) {

                // Now, rs points to 'beforeFirst' pointer on the table

               Product prod = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
               list.add(prod);

            }

        }
        catch (Exception ex)
        {
            throw new DaoException(ex);
        }
        return list;
    }

    @Override
    public List<Product> getPriceRange(Double min, Double max) throws DaoException {
        throw new DaoException("Method not implemented in JDBC yet");
    }
}
