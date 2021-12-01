package com.target.java.training.programs;

import com.target.java.training.utils.DbUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.Statement;


@Slf4j
public class CreateTable {
    public static void main(String[] args) {
        String cmd = "Create table products(\n" +
                "id integer primary key,\n" +
                "name varchar(50) not null,\n" +
                "Price decimal\n" +
                ");";
// rename double to decimal
        try(
                Connection conn = DbUtil.createConnection(); // Just establishes connection
                Statement stmt = conn.createStatement(); // To run the command in the DB
        )
        {
            stmt.execute(cmd); // Executes the Program in H2 Server
            log.debug("The SQL command was successfully executed in H@ server.");
        }// resources like connections get closed here
        catch (Exception e)
        {
           log.error("There was an error", e);
        }

    }
}
