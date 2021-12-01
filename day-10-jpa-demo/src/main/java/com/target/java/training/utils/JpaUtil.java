package com.target.java.training.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JpaUtil {
    private JpaUtil()
    {

    }
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRAINING");

    // each time this  method is called, a new EM instance (represents a DB connection)
    // is returned
    public static EntityManager createEntityManager()
    {
        return emf.createEntityManager();
    }
}
