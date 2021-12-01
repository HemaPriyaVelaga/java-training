package com.training.employeeservice.service;

import com.training.employeeservice.dao.EmployeeDao;
import com.training.employeeservice.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class DefaultEmployeeService implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee addNewEmployee(Employee employee) {
        employee.setEmployeeId(null);
        return employeeDao.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> oe = employeeDao.findById(id);
        return oe.isPresent()?oe.get():null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        if(employee.getEmployeeId()==null)
        {
            throw new RuntimeException("Employee ID can not be null for updating an employee.");
        }
        if(!employeeDao.existsById(employee.getEmployeeId()))
        {
            throw new RuntimeException("Invalid employee ID.");
        }

        return employeeDao.save(employee);
    }

    @Override
    public Employee deleteEmployee(Integer id) {

        if(!employeeDao.existsById(id))
        {
            throw new RuntimeException("Employee of ID " + id + " doesnt exist!");
        }

        Employee p = employeeDao.findById(id).get();
        employeeDao.deleteById(id);
        return p;
    }

    @Override
    public Iterable<Employee> getAllEmployees(Integer pagenum, Integer pagesize) {
        PageRequest p = PageRequest.of(pagenum - 1, pagesize);
        Page<Employee> result = employeeDao.findAll(p);

        if(result.hasContent())
        {
            return result.getContent();
        }
        else
        {
            return new ArrayList<>();
        }
    }

    @Override
    public Iterable<Employee> getEmployeesByTitle(String title) {
        return employeeDao.getEmployeesByTitle(title);
    }

    @Override
    public Iterable<Employee> getEmployeesByCountry(String country) {
        return employeeDao.getEmployeesByCountry(country);
    }

    @Override
    public Iterable<Employee> getEmployeesBetweenHireDateRange(Date from, Date to) {
        return employeeDao.getEmployeesBetweenHireDateRange(from, to);
    }

    @Override
    public Iterable<Employee> getEmployeesBetweenBirthDateRange(Date from, Date to) {
        return employeeDao.getEmployeesBetweenBirthDateRange(from, to);
    }

    @Override
    public Iterable<Employee> getEmployeesByReportsTo(Integer reportsTo) {
        return employeeDao.getEmployeesByReportsTo(reportsTo);
    }
}
