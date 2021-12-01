package com.target.training.programs;

import lombok.Setter;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {

        Map<String , String> friends = new HashMap<>();

        // If we use LinkedHashMap, the order of keys will be maintained
        // as it uses a linked list and maintains the sequence of insertion

        // If we use Tree Map, the keys will be returned in a sorted order
        // i.e., here, in an alphabetical order


        friends.put("Shyam", "Hyderabad");
        friends.put("Hema", "Jammu");
        friends.put("Hima", "Mumbai");
        friends.put("Arun", "Gorakhpur");
        friends.put("Venu", "Tenali");
        friends.put("Venu", "Vizag");

        // HashMap Uses HashCode and equals of string object to find
        // if key is already present
        // So, the first occurrence is replaced by latest key repetition occurrence
        // Key must be unique

        // Sequence is not maintained here

        System.out.println(friends);

        friends.put("Vinay", "Hassan");

        System.out.println(friends);

        // HashTable also gives a similar output as HashMap

        String name = "Hema";

        System.out.println(name + " lives in " + friends.get(name));

        // If key doesnt exist, it returns Null or sometimes exception

        // TO prevent this
        name = "Naresh";

        if(friends.containsKey(name))
        {
            System.out.println(name + " lives in " + friends.get(name) );
        }

        else
        {
            System.out.println(name + " is not found in your friend list!");
        }


        Set<String > keys = friends.keySet();
        System.out.print("Keys are: ");
        for(String k:keys)
        {
            System.out.print(k + " ");
        }
        System.out.println();

        Collection<String > values = friends.values();
        System.out.print("Values are: ");
        for(String k:values)
        {
            System.out.print(k + " ");
        }
        System.out.println();


        Set<Map.Entry<String , String >> entries = friends.entrySet();

        System.out.println("Entries are: ");
        for(Map.Entry<String , String> e:entries)
        {
            System.out.println(e.getKey() + " --> " + e.getValue());
        }
    }
}
