package com.target.java.training.exceptions.programs;

import java.io.BufferedReader;
import java.io.FileReader;

public class tryWithResourcesDemo {
    public static void main(String[] args) {
        String filename = "src/main/java/com/target/java/training/exceptions/programs/finallyDemo.java";

        try(
                //dummyResource dr;
            FileReader reader = new FileReader(filename); // says the possible exception
            BufferedReader in = new BufferedReader(reader);
        ){
            String line;
            //int n = 12/0; // uncomment to check what happens;
            while((line = in.readLine()) != null){
                System.out.println(line);
            }
        } // both reader and in are closed here with try() i.e., in.close(); and reader.close();
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
