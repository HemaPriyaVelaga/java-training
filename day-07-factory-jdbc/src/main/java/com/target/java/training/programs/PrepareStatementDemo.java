package com.target.java.training.programs;

import com.target.java.training.utils.DbUtil;
import com.target.java.training.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Slf4j
public class PrepareStatementDemo {
    public static void main(String[] args) {
        String sql = "insert into products values (?,?,?)";
        // ? is an invalid symbol in SQL
        // It prevents SQL injection
        // As it doesnt use String concatenation as in the other example
        // pass name as  vinod or 1 = 1 and check the output

        // If we dont use the above way to send details,
        // the "or" in the above name will be treated as a separate operator

        String choice;
        int id;
        String name;
        double price;

        try(
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
                // Here, SQL command is directly send to DB server from
                // And tells it to compile it and keep it ready for execution
                // THe server will check only syntax errors and not for other errors
                )
        {
            do {

                try {
                    id = KeyboardUtil.getInt("Enter id: ");
                    name = KeyboardUtil.getString("Enter Name: ");
                    price = KeyboardUtil.getDouble("Enter Price: ");

                    //String sql = String.format("insert into products values('%d', '%s', '%f')", id, name, price);

                    stmt.setInt(1, id);
                    stmt.setString(2, name);
                    stmt.setDouble(3, price);

                    stmt.execute();
                    // Visit to DB server carrying the values to be assigned to the
                    // Precompiled SQL command
                    log.debug("New Product added with id = {}, name = {} and price = {}", id, name, price);

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
            log.debug("There was an error - " + e.getMessage());
        }
    }

}
