package com.training.employeeservice.service;

import com.training.employeeservice.entity.Employee;

import java.util.Date;

public interface EmployeeService {

    //CRUD
    public Employee addNewEmployee(Employee employee);
    public Employee getEmployeeById(Integer id);
    public Employee updateEmployee(Employee employee);
    public Employee deleteEmployee (Integer id);


    //Queries
    public Iterable<Employee> getAllEmployees(Integer pagenum, Integer pagesize);
    public Iterable<Employee> getEmployeesByTitle(String title);
    public Iterable<Employee> getEmployeesByCountry(String country);
    public Iterable<Employee> getEmployeesBetweenHireDateRange(Date from, Date to);
    public Iterable<Employee> getEmployeesBetweenBirthDateRange(Date from, Date to);
    public Iterable<Employee> getEmployeesByReportsTo(Integer reportsTo);
}
