package com.java.training.programs;

import com.java.training.entity.Hello;

public class ArrowFunctionDemo {

    static void greet(Hello h, String name)
    {
        h.sayHello(name);
        h.sayHello(name, "World");
    }
    static void printUpper(String str){
        System.out.println(str.toUpperCase());
    }
    public static void main(String[] args) {
        greet( (name) -> System.out.println("Hello " + name + "!"), "Hema");

        greet( System.out::println, "Shyam");

       greet(ArrowFunctionDemo::printUpper, "Hima");
        // Arrow functions are not allowed when there are two or more functions
        // in an interface having the same name

        // greet(new ArrowFunctionDemo()::printUpper, "Hima"); Will work if you make the fn non static


    }
}
