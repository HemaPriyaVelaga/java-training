package com.target.java.training.assignment.entities;

import lombok.SneakyThrows;

import java.util.ResourceBundle;

public final class ContactsDaoFactory {

        private ContactsDaoFactory()
        {

        }

        private static ContactsDao dao = null;

        @SneakyThrows
        public static ContactsDao getContactsDao() throws DaoException
        {
            if(dao!=null) return dao;

            ResourceBundle rb = ResourceBundle.getBundle("contacts-dao");
            String discriminator = rb.getString("discriminator");
            // Just change the string in the properties file
            // To use the desired implementation

            switch ((discriminator.toLowerCase()))
            {
                case "arraylist":
                    dao = new ArrayListContactsDao();
                    break;

                case "linkedhashmap":
                    dao = new LinkedHashMapDao();
                    break;

                case "jdbc":
                    dao = new JdbcContactsDao();
                    break;

                case "csv":
                    // dao = new CsvProductDao();
                    // break;
                case "jpa":
                     dao = new JpaContactsDao();
                     break;
                default: throw new DaoException("Request for Unknown Implementation for Contacts.");
            }

            return dao;
        }
    }

