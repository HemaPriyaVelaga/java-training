package com.target.java.training.programs;

import com.target.java.training.utils.DbUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
@Slf4j
public class GetAllProducts {
    @SneakyThrows
    public static void main(String[] args) {

        String sql = "select * from products";
        // MySQL table names on linux is case sensitive

        try(
                Connection conn = DbUtil.createConnection(); // Just establishes connection
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        )
        {
            while ( rs.next()) {

                // Now, rs points to 'beforeFirst' pointer on the table
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price =  rs.getDouble("price");

                log.debug("id = {}, name = {}, price = {}", id, name, price);
            }
            // If we dont use rs.next() without the while loop, the above will give an error because beforeStart doesnt have any data
            // rs.next makes the ptr go to the first record of the table
        }
        catch (Exception ex)
        {
            log.debug("Problem occurred!" + ex.getMessage());
        }

    }
}
