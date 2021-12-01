package com.target.training.programs;

import java.io.FileReader;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFileDemo {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("hema.properties"))
        {
            Properties props = new Properties();
            props.load(reader);

            System.out.println(props);

            Set<Map.Entry<Object , Object >> entries = props.entrySet();
            for(Map.Entry<Object , Object  > entry: entries){
                System.out.println(entry.getKey() + " --> " + entry.getValue());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

