package com.target.java.training.exceptions.programs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class finallyDemo {
    public static void main(String[] args) {
        FileReader reader = null;
        BufferedReader in = null;

        String filename = "pom.xml";


        try{
            reader = new FileReader(filename); // says the possible exception
            in = new BufferedReader(reader);
            String line;
            while((line = in.readLine()) != null){
                System.out.println(line);
            }
            // System.exit(1);
            // if we dont close the file after reading, it leads to a possibility
            // of memory leak

            in.close();
            reader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        finally {
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println("END OF THE PROGRAM");
    }
}
