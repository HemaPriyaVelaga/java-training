package com.target.java.training.programs;

import com.target.java.training.entity.Employee;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


@Slf4j
public class AddNewEmployee {
    public static void main(String[] args) {

        //Employee emp1 = new Employee(1122, "John Doe", new Date(), 3500.0);
        Employee emp1 = new Employee("John Doe", 3000.0, "johndoe@gmail.com"); // ID is auto added by the hibernate persistence provider
        // Since we specified in the employee object that email is unique, if we rerun the program with the same object
        // again, it will throw an error because email id is being repeated
        // and the object wont be added the second time

        EntityManager em = null; // EntityManager object is not yet created
        // Entity Manager represents a conncetion to the database

        // For entity manager object, we need entity manager factory
        // Someone should read the persistence.xml and to create the type of object needed

        // The following is a factory method to read persistence.xml
        // and create an instance of some class provided by the persistence provider, here the hibernate persistence provider
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRAINING");
        log.debug("emf is an instance of {}", emf.getClass().getName());

        em = emf.createEntityManager();
        log.debug("em is an instance of {}", em.getClass().getName());
        // If we run the above, we will get multiple debug logs from hibernate persistence provider
        // We can disable all and only enable to display our logs
        // TO DO THAT, we can go to log4j.properties file, and add the following
        //log4j.logger.org.hibernate=INFO
        //log4j.logger.org.jboss=INFO
        // Once done, we will get less logs, including ours
        // We can replace INFO with OFF

        // To add the above specified employee object into the Employees table in our specified table
        EntityTransaction tx = em.getTransaction();
        try {
            em.persist(emp1);

            // But the above doest work and table is empty
            // This is because the entity manager maintains 1st level cache, here, em
            // So everytime and object is added, that is being stored in the cache
            // and the actual sql statement is not fired here.
            // They will be executed when we say "commit"


            tx.begin(); // Once a transaction is started, a lock is acquired and all others will wait till its done
            em.persist(emp1);
            tx.commit(); // The actual sql statments are executed here
            log.debug("Employee data saved {}", emp1);
        } catch (Exception e) {
            tx.rollback();
            log.error("Error occurred " + e.getMessage());
        }
        em.close();
        emf.close();

        // NOTE: If we create different Entity Managers, we need to create different
        // transactions for each of them and commit them separately
    }
}
