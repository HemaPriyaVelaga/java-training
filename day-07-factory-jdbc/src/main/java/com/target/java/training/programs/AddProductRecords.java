package com.target.java.training.programs;

import com.target.java.training.utils.DbUtil;
import com.target.java.training.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class AddProductRecords {
    public static void main(String[] args) {
        String choice;
        int id;
        String name;
        double price;

        try(Connection conn = DbUtil.createConnection();
            Statement stmt = conn.createStatement())
        {
            do {

                try {
                    id = KeyboardUtil.getInt("Enter id: ");
                    name = KeyboardUtil.getString("Enter Name: ");
                    price = KeyboardUtil.getDouble("Enter Price: ");

                    String sql = String.format("insert into products values('%d', '%s', '%f')", id, name, price);

                    stmt.execute(sql);
                } catch (Exception e) {
                    log.warn("There was an error - {}", e.getMessage() );
                }

                choice = KeyboardUtil.getString("Want to add another (yes/no): [yes is the default]: ");
                if (choice.trim().equals(""))
                {
                    choice = "yes";
                }
            }
            while (choice.equalsIgnoreCase("yes"));
        }
        catch (Exception e)
        {
            log.error("Error while acquiring DB resources", e);
        }
    }

    // The issue with this code - SQL injection
    // give name input as "mi sound bar', 200) --"
    // The price, instead of that given in the price field, 200 will be made the price

}
