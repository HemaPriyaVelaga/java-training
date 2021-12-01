package com.target.java.training.exceptions.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class employee {
    private String name;
    private int id;
    private double salary;
   // Press ctrl space and type set to get the following
    // When throwing exception, set the class as exception
    // or try catch
    // or Runtime exception
    public void setId(int id) {
        if(id<0){
              throw new InvalidIDException ("Invalid Value for ID");

        }
        this.id = id;
    }

    public void setName(String name) {
        if(name==null || name.trim().length()==0)
        {
            throw new EmptyNullNameException ("Name cant be empty or null");
        }

        this.name = name;
    }
}
