package com.training.employeeservice.controllers;

import com.training.employeeservice.entity.ApiError;
import com.training.employeeservice.entity.Employee;
import com.training.employeeservice.service.EmployeeService;
import com.training.employeeservice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping(value = "/{id}", produces = "text/plain")
    public String handleGetEmployeeByIdAsString(@PathVariable Integer id) {
        return service.getEmployeeById(id).toString();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> handleGetEmployeeById(@PathVariable Integer id) {
        Employee em = service.getEmployeeById(id);

        if (em != null) {
            return ResponseEntity.ok(em);
        } else {
            ApiError err = new ApiError(HttpStatus.NOT_FOUND, new Date(), "Employee not found for id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
        }
    }

    @GetMapping(produces = {"application/json"})
    public Iterable<Employee> handleGetAllEmployees(
            @RequestParam(value = "_page", required = false, defaultValue = "1") Integer pagenum,
            @RequestParam(value = "_limit", required = false, defaultValue = "8") Integer pagesize
    ) {
        return service.getAllEmployees(pagenum, pagesize);
    }

    @GetMapping(path = "/filter", params = {"title"})
    public Iterable<Employee> handleGetEmployeesByTitle(@RequestParam String title) {
        return service.getEmployeesByTitle(title);
    }

    @GetMapping(path="/{id}/manager", produces = "application/json")
    public Employee handleGetManagerFor(@PathVariable Integer id){
        return null;
    }


    @GetMapping(path = "/filter", params = {"country"})
    public Iterable<Employee> handleGetEmployeesByCountry(@RequestParam String country) {
        return service.getEmployeesByCountry(country);
    }


    @GetMapping(path = "/{id}/subordinates", produces = {"application/json"})
    public Iterable<Employee> handleGetEmployeesByReportsTo(@PathVariable Integer id) {
        return service.getEmployeesByReportsTo(id);
    }



    @GetMapping(path = "/filter", params = {"hireFrom", "hireTo"})
    public Iterable<Employee> handleGetEmployeesBetweenHireDateRange(@RequestParam String hireFrom, @RequestParam String hireTo) {
        return service.getEmployeesBetweenHireDateRange(DateUtil.toDate(hireFrom), DateUtil.toDate(hireTo));
    }

    @GetMapping(path = "/filter", params = {"from", "to"})
    public Iterable<Employee> handleGetEmployeesBetweenBirthDateRange(@RequestParam String from, @RequestParam String to) {
        return service.getEmployeesBetweenBirthDateRange(DateUtil.toDate(from), DateUtil.toDate(to));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> handleAddNewEmployee(@RequestBody Employee employee) {
        try {
            Employee emp = service.addNewEmployee(employee);
            return ResponseEntity.ok(emp);
        } catch (Exception e) {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);
        }
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> handleUpdateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        try {
            employee.setEmployeeId(id);
            Employee p = service.updateEmployee(employee);
            return ResponseEntity.ok(p);
        } catch (Exception e) {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);

        }
    }

    @DeleteMapping(path = "/{id}", produces = "application/json") // doesnt have consumes field
    public ResponseEntity<Object> handleDeleteProduct(@PathVariable Integer id) {
        try {
            //Hard or soft delete : Check in DefaultProductServie.java
            Employee p = service.deleteEmployee(id);
            return ResponseEntity.ok(p);
        } catch (Exception e) {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);

        }
    }


}
