package com.training.springBasicsUdemy.cfg;

import com.training.springBasicsUdemy.dao.DummyProductDao;
import com.training.springBasicsUdemy.dao.JdbcProductDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
// Aspect Oriented Prog/ Transaction management and related tasks need the Configuration
public class AppConfig2 {

    public AppConfig2()
    {
        System.out.println("AppConfig1 Instantiated successfully!");
    }

    @Lazy
    @Bean
    // This is needed for Spring to use this.
    public DummyProductDao dummyDao()
    {
        System.out.println("AppConfig1.DummyDao called.....");

        return new DummyProductDao();
    }

    @Scope("prototype") // Also, "singleton
    // If we define the scope this way,
    // The jdbcDao Object is not stored in the container before executing the
    //  dao = ctx.getBean("jdbcDao", ProductDao.class); code
    // And each time the line is encountered, it corresponds to a different object

    // If the above scope is not declared, multiple calls all correspond
    // To the same object that has already been created and stored in Spring Container
    @Bean
    public JdbcProductDao jdbcDao()
    {
        System.out.println("AppConfig1.JdbcDao called.....");
        JdbcProductDao dao = new JdbcProductDao();
        dao.setDriverClassName("org.h2.Driver");
        dao.setUrl("jdbc:h2:./spring_basics_db");
        dao.setUrl("hemu");
        dao.setPassword("hemu");
        return dao;
    }

    //We supply this class information to Spring
    // It automatically calls all the classes preceeded by @Bean
    // Concept - Inversion of Control
    // We dont call the functions but Spring does that whenever it feels
    // that they are needed
}
