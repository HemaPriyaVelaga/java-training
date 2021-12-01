package com.target.java.training.programs;

import com.target.java.training.entity.Employee;
import com.target.java.training.entity.EmployeeTerritory;
import com.target.java.training.utils.DateUtil;
import com.target.java.training.utils.JpaUtil;
import com.target.java.training.utils.KeyboardUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class GetEmployeeTerritoryLineItems {

    public static void main(String[] args) {
        Integer employeeId = KeyboardUtil.getInt("Enter Employee Id to get details for: ");
        EntityManager em = JpaUtil.createEntityManager();
        Employee employee = em.find(Employee.class, employeeId);
        printEmployeeTerritoryList(employee);
        em.close();
    }

    private static void printEmployeeTerritoryList(Employee employee) {
        List<EmployeeTerritory> employeeTerritoryList = employee.getEmployeeTerritoryList();
        System.out.println("Employee Details are: ");
        System.out.println("Name : " + employee.getTitleOfCourtesy() + " " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("Title: " + employee.getTitle());
        System.out.println("DOJ  : " + DateUtil.toString(employee.getHireDate()));
        System.out.println("Phone: " + employee.getHomePhone());
        line();
        employeeTerritoryList.forEach(GetEmployeeTerritoryLineItems::printEmployeeTerritoryAndRegionInfo);
        line();
    }

    static void printEmployeeTerritoryAndRegionInfo(EmployeeTerritory et) {
        System.out.println(et.getTerritory().getTerritoryDescription() + " " +
                et.getTerritory().getRegionId().getRegionDescription());
    }

    private static void line() {
        for (int i = 0; i < 150; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

}
