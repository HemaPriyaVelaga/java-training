package com.target.java.training.programs;

import com.target.java.training.model.person;

public class printPersonData {
    public static void main(String[] args) {
        person p1;

        p1 = new person("Hema", 23, 5.0);
        //p1.name = "Vinod";
        //p1.age = 47;
        //p1.age = 56.2; Error.
        // The declaration of datatype itself is a kind of abstraction
        //p1.age = -500 --> No error here!
        // So, we can restrict access (privatise them) to class variables to prevent such inputs

        //p1.height = 5.8;

        p1.setAge(300); // Due to encapsulation and certain conditions, the age doesnt get assigned
        p1.setHeight(5.0);
        p1.setName("Hema");
        p1.print();



        p1.setAge(23); // Due to encapsulation and certain conditions, the age doesnt get assigned
        p1.setHeight(5.0);
        p1.setName("Hema");
        p1.print();

        System.out.println("Printing p1" + p1);

        person p2 = new person();
    }
}
