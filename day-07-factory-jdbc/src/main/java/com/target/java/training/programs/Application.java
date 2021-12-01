package com.target.java.training.programs;

import com.target.java.training.dao.DaoException;
import com.target.java.training.dao.DaoFactory;
import com.target.java.training.dao.ProductDao;
import com.target.java.training.entity.Product;
import com.target.java.training.utils.KeyboardUtil;
import lombok.SneakyThrows;

import java.util.List;

public class Application {

    ProductDao dao;

    public static void main(String[] args) {
        new Application().start();

        // NOTE: Keep main as small as possible

    }

    void start(){
        //dao = new ArrayListProductDao(); // Tight coupling
        try {
            dao = DaoFactory.getProductDao(); // Loose coupling
        } catch (DaoException e) {
            e.printStackTrace();
            return;
        }
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
                    searchAndUpdate();
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

    @SneakyThrows
    private void searchAndUpdate()
    {
        try {
            int id = KeyboardUtil.getInt("Enter id of the contact to be edited: ");
            Product p = dao.getById(id);

            if(p==null)
            {
                System.out.println("No product data found for id " + id);
                return;
            }
            String input;
            boolean changed = false;
            System.out.println("Enter product details. Hit ENTER to keep the previous value");

            input = KeyboardUtil.getString("Enter Product Name: (" + p.getName() + ") ");
            if(!input.trim().equals(""))
            {
                p.setName(input);
                changed = true;
            }

            input = KeyboardUtil.getString("Enter Product price: (" + p.getPrice() + ") ");
            if(!input.trim().equals(""))
            {
                p.setPrice(Double.parseDouble(input));
                changed = true;
            }

            if(!changed)
            {
                System.out.println("No changes made. So not updating the contact!");
            }

            dao.updateProduct(p);
        }

        catch (Exception e) {
            throw new DaoException(e);
        }

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
            System.out.printf("%10s %40s %12s%n", "ID", "Name", "Price");
            line('=');
        for(Product p:list)
        {
            System.out.printf("%10s %40s %12s%n", p.getId(), p.getName(), p.getPrice());
        }
            line('=');
        }
        catch (DaoException ex)
        {
            System.out.println("There was a problem!" + ex.getMessage());
        }
    }
    int menu(){

        int choice = -1;

        do{
            System.out.println("0. Exit");
            System.out.println("1. Add new Product");
            System.out.println("2. List all products");
            System.out.println("3. Search by id");
            System.out.println("4. Search by Price Range");
            System.out.println("5. Update Product");
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
