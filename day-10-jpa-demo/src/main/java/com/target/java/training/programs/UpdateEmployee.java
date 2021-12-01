package com.target.java.training.programs;

import com.target.java.training.entity.Employee;
import com.target.java.training.utils.DateUtil;
import com.target.java.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Slf4j
public class UpdateEmployee {
    public static void main(String[] args) {

        // Transient object according to hibernate implementation of JPA
        Employee emp1 = new Employee("Jane", 5000.0, "jane2@gmail.com");

        EntityManager em = JpaUtil.createEntityManager();
        Employee emp = em.find(Employee.class,1);

        log.debug("Employee = " + emp);

        emp.setHireDate(DateUtil.toDate("2015-04-21"));
        // These changes are made to the emp object already retrieved from the table
        // So the employee object is considered unclean after the above statement
        // As its value got changed

        EntityTransaction tx = em.getTransaction();

        em.persist(emp1);
        // Now, emp1 is a persistent object according to hibernate
        // emp1 is a new object in em

        tx.begin();
        tx.commit();
        // All the unclean/dirty objects will be updated on to the table
        // using the SQL UPDATE command and will be fired to the DB



        em.close();
    }
}
