package com.training.springBasicsUdemy.programs;

import com.training.springBasicsUdemy.cfg.AppConfig1;
import com.training.springBasicsUdemy.dao.ProductDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PO1_GetProductCount {
    public static void main(String[] args) {

        // Our app dependency
        ProductDao dao;

        // To provide the dependency, we want spring container
        // Spring container is represented by an interface called as
        // 'Application Context'

        // A variable representing the spring container
        AnnotationConfigApplicationContext ctx;

        // Object of Spring Container that is defined based on a Configuration
        // Opens some resources, so close it
        ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
        System.out.println("++++++++++++++++++++++++++++");
        // Spring instantiates AppConfig1 class and
        // calls the functions within it annotated by @Beans
        // Collects the return values of the function (here, key = fn name, value = return val)
        // in container


        // Here, it simply returns the object stored in the container earlier, instead of calling it again
        dao = ctx.getBean("jdbcDao", ProductDao.class);

        ProductDao dao2 = ctx.getBean("jdbcDao", ProductDao.class);
        // Spring wont maintain the lifecycle of "prototype" scope Beans

        ProductDao dao3 = ctx.getBean("dummyDao", ProductDao.class);
        ProductDao dao4 = ctx.getBean("dummyDao", ProductDao.class);
        // Singleton will maintain the copy of bean object even if the object is null
        // @Lazy instantiation will let the Spring know that it has to be called only
        // When instantiated once
        // That is, the bean wont be created when the ctx.getBean is performed

        System.out.println("________________________________________________");
        System.out.println("jdbc Product Dao has been declared as @Scope(prototype) So, dao==dao2: " + (dao==dao2));
        System.out.println("Dummy Product Dao has NOT been declared as @Scope(prototype), So dao3==dao4 : " + (dao3==dao4) );
        System.out.println("dao is an instance of : " + dao.getClass().getName());
        System.out.println("There are " + dao.count() + " products!");
        System.out.println("________________________________________________");

        // This helped us achieve loose coupling with help of Spring Container
        // Spring container acts as factory, to which we supply discriminator string
        // which is the name of the required dao implementation
        ctx.close();

    }
}
