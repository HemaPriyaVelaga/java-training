package com.target.java.training.programs;

import com.target.java.training.entity.Employee;
import com.target.java.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
@Slf4j
public class FindEmployeesBySalary {
    public static void main(String[] args) {
        String jpql = "from com.target.java.training.entity.Employee where salary > ?0 ";
        // JPA Query Landuage

        EntityManager em = JpaUtil.createEntityManager();

        TypedQuery<Employee> qru = em.createQuery(jpql, Employee.class);
        qru.setParameter(0, 4975.0);
        List<Employee> list = qru.getResultList();

        for(Employee e: list)
        {
            log.debug("Name = {}, Salary = {}, email = {}", e.getName(), e.getSalary(), e.getEmail());
        }

    }
}
