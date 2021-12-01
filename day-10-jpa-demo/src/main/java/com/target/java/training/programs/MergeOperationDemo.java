package com.target.java.training.programs;

import com.target.java.training.entity.Employee;
import com.target.java.training.utils.DateUtil;
import com.target.java.training.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MergeOperationDemo {
    public static void main(String[] args) {
        Employee emp = new Employee(4, "Allen", DateUtil.toDate("2009-10-12"), 4500.0, "allen@gmail.com" );

        EntityManager em = JpaUtil.createEntityManager();
        em.merge(emp);
        // The above executes a SELECT query to check if id 5 exists already or not.
        // If not found, emo --> new managed object
        // IF found, emp --> dirty managed object

        // during commit --> SQL INSERT or UPDATE is fired based on the above

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        tx.commit();

        em.close();
    }
}
