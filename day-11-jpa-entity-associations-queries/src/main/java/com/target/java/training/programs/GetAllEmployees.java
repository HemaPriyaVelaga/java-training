package com.target.java.training.programs;

import com.target.java.training.entity.Employee;
import com.target.java.training.entity.OrderDetail;
import com.target.java.training.entity.Product;
import com.target.java.training.utils.DateUtil;
import com.target.java.training.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class GetAllEmployees {
    public static void main(String[] args) {

        EntityManager em = null;

        try{
            em = JpaUtil.createEntityManager();
            TypedQuery<Employee> qry = em.createQuery("from Employee", Employee.class);
            List<Employee> list = qry.getResultList();
            printEmployees(list);
            // To write byte[] related files
        }
        finally {
            if(em!=null)
            {
                em.close();
            }
        }

    }

    private static void printEmployees(List<Employee> employees) {
        System.out.println("All the employees are: ");
        line();
        System.out.printf("%-20s %-20s %-35s %-15s %-15s %-30s %-20s %-20s %-20s %-20s %-35s%n",
                "First name", "Last Name", "Title", "Birth date", "Hire Date", "Address", "City", "Region"
        , "Postal Code", "Country","Reports To" );
        for(Employee li: employees )
        {
            System.out.printf("%-20s %-20s %-35s %-15s %-15s %-30s %-20s %-20s %-20s %-20s %-35s%n",
                    li.getFirstName(), li.getLastName(), li.getTitle()
                    , DateUtil.toString(li.getBirthDate()), DateUtil.toString(li.getBirthDate()),
                    li.getAddress().trim(), li.getCity().trim(), li.getRegion(), li.getPostalCode(),li.getCountry()
                    , li.getReportsTo());
          /*  FileOutputStream file = null;
            try {
                file = new FileOutputStream(li.getFirstName() + "_" + System.currentTimeMillis() + ".png");
                file.write(li.getPhoto());
                file.close();

            } catch (Exception e) {
                e.printStackTrace();
            }*/

        }
        line();


    }


    private static void line() {
        for (int i = 0; i < 95; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
