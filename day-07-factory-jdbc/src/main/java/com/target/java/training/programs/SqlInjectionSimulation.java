package com.target.java.training.programs;

import com.target.java.training.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SqlInjectionSimulation {

    public static void main(String[] args) {
        String username;
        String password;

        username = KeyboardUtil.getString("Enter Username: ");
        password = KeyboardUtil.getString("Enter Password: ");

        String sql = String.format("select * from users where username = '%s' and password = '%s'", username, password);

        // Select * from users where username = ‘Vinod’ or 1=1 -- and password=‘topsecret'
        //1=1 is evaluated to true so the password is not matched but the work will be done even if we give a wrong password
        log.debug(sql);
    }
}
