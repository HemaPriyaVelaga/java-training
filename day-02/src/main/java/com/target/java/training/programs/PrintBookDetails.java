package com.target.java.training.programs;

import com.target.java.training.model.book;

public class PrintBookDetails {
    //static book b1;
    public static void main(String[] args) {
        book b1; // Reference - occupies 8 Bytes in stack
        // The book class is not loaded into JVM yet

        //args and b1 are local and stack variables
        //System.out.println("Book is " + b1);
        // if book b1 is commented and static book is uncommented, we dont get CE
        // as the default value stores in heap for class static var is NULL
        // In main default val is nothing in stack so CE

        b1 = new book(); // Object in heap - 36 Bytes (see class variables)
        // If the class is not yet loaded, JVM searches for it and loads it onto heap



        System.out.println("Book is " + b1); //b1.toString()
        System.out.println("args is " + args);
        //  if not mentioned public - package level access var
        // We will get CE when we try to print class variables if not declared public

        b1.title = "Let us see";
        System.out.println("Book title is " + b1.title);

        System.gc();
        // Writing this just means that we recommend the garbage collection
        // This does not guarantee that garbage collection will be happening after this code

        /*
        String s1 = "Vinod";
        String s2 = "Vinod";
        //Here, 2 references are created but a single string object is created

        //Internally, string class maintains static cache
        //So when s1 is assigned a string, that string object is stored in cache
        //Now, when s2 is assigned the same string value, the string class checks if a same
        //String object already exists or not. If it exists, then both s1 and s2 are mapped to same string object

        String n3 = new String("Vinod")
        // Here, a different string object is created and s3 does NOT refer to
        // the object referred to by s1 and s2
         */
    }
}
