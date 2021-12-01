package com.target.java.training.programs;

import com.target.java.training.model.Animal;
import com.target.java.training.model.Cat;
import com.target.java.training.model.Dog;

public class animalInfo {
    public static void main(String[] args) {
        Animal a1;


        Cat c1 = new Cat();
        Dog d1 = new Dog();
        Dog d2 = new Dog();

        System.out.println("Dog Info: ");
        d1.info(); // In super class
        // Compiler just checks if there is .info() function is present or not
        // During runtime, whether to use Animal object .info() or to use Dog object .info() is checked
        // if the Dog class overrides the Animal function


        d1.talk(); // Super class function overridden in subclass
        System.out.println("\nCat Info: ");
        c1.info(); // In super class
        c1.talk(); // Super class function overridden in subclass

        System.out.println("\nCASTING: \n");
        // CASTING

        a1 = d1; // Upcasting subclass to superclass happens implicitly
        a1.info(); // Compiler checks availability of the function and Runtime invokes it
        a1.talk();

        ((Dog)a1).wagTail(); // downcast to subclass for using its function from super class

        System.out.println("\nUsing printAbout Function\n");
        printAbout(d1);
        printAbout(d2);
        printAbout(c1);

    }

    static void  printAbout(Animal a1){
        a1.info();
        a1.talk();

        if(a1 instanceof Cat){
            ((Cat)a1).phurr();

        }

        else if (a1 instanceof Dog){
            ((Dog) a1).wagTail();
        }

        else if (a1 instanceof Animal)
        {
            System.out.println("Its not a dog or cat");
        }
    }
}
