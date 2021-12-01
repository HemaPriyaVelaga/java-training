package com.target.training.programs;

import com.target.training.dao.ArrayListProductDao;
import com.target.training.dao.DaoException;
import com.target.training.dao.ProductDao;
import com.target.training.entity.Product;
import com.target.training.utils.KeyboardUtil;
import java.util.List;

public class Application {

    ProductDao dao;

    public static void main(String[] args) {
        new Application().start();

        // NOTE: Keep main as small as possible

    }

    void start(){
        dao = new ArrayListProductDao();
        int choice;
        while ((choice = menu())!=0){

            switch (choice)
            {
                case 1:
                    System.out.println("Adding new Product..... ");
                    acceptAndAddProduct();
                    break;
                case 2:
                {

                    System.out.println("Listing all Products...");
                    listProducts();
                    break;
                }
                case 3:
                    System.out.println("Searching by id: TBD");
                    break;
                case 4:
                    System.out.println("Search by price range: TBD");
                    break;
                case 5:
                    System.out.println("Updating record....");
                    break;
                default: break;
            }
        }

        System.out.println("Bye!");
    }

    static void line(char pattern)
    {
        for(int i=1;i<=80;i++)
        {
            System.out.print(pattern);
        }
        System.out.println();
    }

    private void acceptAndAddProduct(){
        try
        {
            Integer id = KeyboardUtil.getInt("Enter id: ");
            String name = KeyboardUtil.getString("Enter Name: ");
            Double price = KeyboardUtil.getDouble("Enter Price: ");
            Product p = new Product(id, name, price);
            dao.addProduct(p);
            System.out.println("Product Added successfully......!");

        }
        catch (Exception ex)
        {
            System.out.println("Problem occurred!! ");
        }
    }
    private void listProducts(){

        try {
            List<Product> list = dao.getAll();
            line('=');
            System.out.printf("%10s %40s %12s\n", "ID", "Name", "Price");
            line('=');
        for(Product p:list)
        {
            System.out.printf("%10s %40s %12s\n", p.getId(), p.getName(), p.getPrice());
        }
            line('=');
        }
        catch (DaoException ex)
        {
            System.out.println("There was a problem :(");
        }
    }
    int menu(){

        int choice = -1;

        do{
            System.out.println("0. Exit");
            System.out.println("1. Add new Product");
            System.out.println("2. List all products");
            System.out.println("3. Search by id");
            try {
                choice = KeyboardUtil.getInt("Enter your choice: ");
                if(choice<0 || choice>5)
                {
                    System.out.println("Invalid choice. Retry!");
                }
            }
            catch (Exception ex)
            {
                System.out.println("Invalid choice. Retry!");
            }

        }while (choice <0 || choice >6);

        return choice;
    }

}
