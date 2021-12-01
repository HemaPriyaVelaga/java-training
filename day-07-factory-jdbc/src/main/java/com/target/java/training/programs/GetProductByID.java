package com.target.java.training.programs;

import com.target.java.training.utils.DbUtil;
import com.target.java.training.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Slf4j
public class GetProductByID {
    public static void main(String[] args) {

        String sql = "select * from products where id = ?";
        try(
                Connection conn = DbUtil.createConnection(); // Just establishes connection
                PreparedStatement stmt = conn.prepareStatement(sql); // 1st round trip
                )
        {
            int id = KeyboardUtil.getInt("Enter product id to be searched for: ");
            stmt.setInt(1, id);
            stmt.execute(); // 2nd round trip

            try(ResultSet rs = stmt.getResultSet())
            {
                if(rs.next())
                {
                    log.debug("id = {}, name = {}, price = {}",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("price"));
                }
                else
                {
                    log.warn("No product found for id = {}!", id);
                }
            }

        }
        catch (Exception e)
        {
            log.error("Error while accessing data" + e.getMessage());
        }
    }
}
