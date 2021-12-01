package com.target.java.training.programs;

import com.target.java.training.entity.*;
import com.target.java.training.utils.DateUtil;
import com.target.java.training.utils.JpaUtil;
import com.target.java.training.utils.KeyboardUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class GetOrderDetails {
    public static void main(String[] args) {
        Integer orderId = KeyboardUtil.getInt("Enter Order Id to get details for: ");
        EntityManager em  = JpaUtil.createEntityManager();
        Order order = em.find(Order.class, orderId);

        printOrderInformation(order);
        line();
        printCustomerDetails(order.getCustomer());
        line();
        printLineItems(order.getLineItems());
        line();
        printShipperDetails(order.getShipper());
        line();
        printEmployeeDetails(order.getEmployee());
        em.close();
    }

    private static void printEmployeeDetails(Employee employee)
    {

        System.out.println("This Employee dealing with this order is " );
        System.out.println("Employee Name       : " + employee.getTitleOfCourtesy()+" "+ employee.getFirstName() + " " + employee.getLastName());
        System.out.println("Employee Title      : " + employee.getTitle());
        System.out.println("Employee Phone      : " + employee.getHomePhone());

    }

    private static void printShipperDetails(Shipper shipper)
    {
        System.out.println("This order is shipped via: " );
        System.out.println("Shipper Id                     : " + shipper.getShipperId());
        System.out.println("Shipper Company                : " + shipper.getCompanyName());
        System.out.println("Shipper Phone                  : " + shipper.getPhone());

    }

    private static void printLineItems(List<OrderDetail> lineItems) {
        System.out.println("Products In this order are: ");
        line();
        System.out.printf("%-45s %10s %10s %10s %10s%n",
                "Product name", "Unit price", "Quantity", "Discount", "Amount");
        line();
        double total = 0;
        for(OrderDetail li: lineItems)
        {
            System.out.printf("%-45s %10s %10s %10s %10.2f%n",
                    li.getProduct().getProductName() + " (" + li.getProduct().getCategory().getCategoryName() + ")",
                    li.getUnitPrice(),
                    li.getQuantity(),
                    li.getDiscount()*100 + "%",
                    (1-li.getDiscount())*(li.getUnitPrice() * li.getQuantity()));
            total += (1-li.getDiscount())*(li.getUnitPrice() * li.getQuantity());
        }
        line();
        System.out.printf("%78s %10.2f%n", "Total", total);
        line();

    }

    private static void printCustomerDetails(Customer customer) {
        System.out.println("Company name                  : " + customer.getCompanyName());
        System.out.println("Contact person                : " + customer.getContactName());
        System.out.println("Job title                     : " + customer.getContactTitle());
        System.out.println("Address                       : " + customer.getAddress() + ", "+ customer.getCity() + ", "+
                customer.getRegion() + ", "+customer.getCountry() + ", "+ customer.getPostalCode());

    }

    private static void line() {
        for (int i = 0; i < 95; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    private static void printOrderInformation(Order order) {
        System.out.println("Order id                      : " + order.getOrderId());
        System.out.println("Order date                    : " + DateUtil.toString(order.getOrderDate()));
        System.out.println("Required date                 : " + DateUtil.toString(order.getRequiredDate()));
        if (order.getShippedDate() != null) {
            System.out.println("Shipped date                  : " + DateUtil.toString(order.getShippedDate()));
        }
        System.out.println("Shipped to                    : " + order.getShipName());
        System.out.println("                                " + order.getShipAddress());
        System.out.println("                                " + order.getShipCity());
        if (order.getShipRegion() != null) {
            System.out.println("                                " + order.getShipRegion());
        }
        System.out.println("                                " + order.getShipCountry() + " " + order.getShipPostalCode());

    }
}
