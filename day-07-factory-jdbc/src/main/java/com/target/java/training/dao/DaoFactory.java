package com.target.java.training.dao;

import lombok.SneakyThrows;

import java.util.ResourceBundle;

public final class DaoFactory {
    private DaoFactory()
    {

    }

    private static ProductDao dao = null;

    @SneakyThrows
    public static ProductDao getProductDao() throws DaoException
    {
        if(dao!=null) return dao;

        ResourceBundle rb = ResourceBundle.getBundle("product-dao");
        String discriminator = rb.getString("discriminator");
        // Just change the string in the properties file
        // To use the desired implementation

        switch ((discriminator.toLowerCase()))
        {
            case "arraylist":
                dao = new ArrayListProductDao();
                break;

            case "jdbc":
                 dao = new JdbcProductDao();
                 break;

            case "csv":
                // dao = new CsvProductDao();
                // break;
            case "jpa":
                // dao = new JpaProductDao();
                // break;
            default: throw new DaoException("Request for Unknown Implementation for ProductDao.");
        }

        return dao;
    }
}
