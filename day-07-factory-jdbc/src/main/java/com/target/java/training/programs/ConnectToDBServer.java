package com.target.java.training.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
@Slf4j

public class ConnectToDBServer {

    @SneakyThrows
    public static void main(String[] args) {

        // 1. Declare Variable
        // 2. In H2 console, change from generic to server

        String driverClassName = "org.h2.Driver"; // in H2 server when launched
        // for mysql: //com.mysql.jdbc.cj.Driver
        String url = "jdbc:h2:tcp://localhost/~/target_training_db"; //:tcp is for server mode, no tcp for embedded mode
        // the above is location of our DB file
        // for mysql: jdbc:mysql://localhost/target_training_db
        String username = "hema";
        String password = "hemapriya";

        // 3. Load Driver Class to jvm (latest jdbc automatically does this)

        log.debug("These are the registered JDBC drivers in DriverManager");


        DriverManager.drivers().forEach(d->log.debug("{}", d));
        // d.getClass().getName()

        // 4. Use rhe getConnection factory method of DriverManager to get a connection to the db
        try(
        Connection conn = DriverManager.getConnection(url, username, password);) {

            log.debug("Got an object of {}", conn.getClass().getName());

        }
        catch (Exception ex)
        {
            log.error("Issue occurred while connecting to the database!" + ex.getMessage());
        }
        // TIll here, we established the connection to the H2 server


        // 5. Use this connection and send SQL command so that the data
        // will be stored in the DB

        // This connection is a costly resource, so the connections have to be closed
        // as soon as the work is done
        // Connection interface is an auto closable one

        // 6. Create a DB Util which allows us to get connection straight away





    }
}
