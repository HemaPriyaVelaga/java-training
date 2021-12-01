package com.target.java.training.programs;

import com.target.java.training.entity.Employee;
import com.target.java.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetEmployeeById {
    public static void main(String[] args) {
        Integer id = 3;

        EntityManager em = JpaUtil.createEntityManager();

        Employee emp = em.find(Employee.class, id);
        // The above fires a query "SELECT * FROM EMPLOYEES WHERE ID = ?"

        // Transactions are needed only for DML statements like update and add
        // The above does not require Transaction

        if(emp==null)
        {
            log.debug("No data found for employee with id " + id);
        }
        else
        {
            log.debug("The Employee is: " + emp);
        }
        em.close();

        // To stop showing SQL statements in console when the program is run, go to
        // persistence.xml and set hibernate.show_sql=false
    }
}
