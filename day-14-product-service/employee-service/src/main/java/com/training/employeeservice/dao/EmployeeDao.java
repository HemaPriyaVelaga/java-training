package com.training.employeeservice.dao;

import com.training.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EmployeeDao extends PagingAndSortingRepository<Employee, Integer> {

    @Query("from Employee where title = ?1")
    public Iterable<Employee> getEmployeesByTitle(String title);

    @Query("from Employee where country = ?1")
    public Iterable<Employee> getEmployeesByCountry(String country);

    @Query("from Employee where hireDate between ?1 and ?2")
    public Iterable<Employee> getEmployeesBetweenHireDateRange(Date from, Date to);

    @Query("from Employee where birthDate between ?1 and ?2")
    public Iterable<Employee> getEmployeesBetweenBirthDateRange(Date from, Date to);

    @Query("from Employee where reportsTo = ?1")
    public Iterable<Employee> getEmployeesByReportsTo(Integer reportsTo);

}
