package com.target.training.java.programs;

public class Assgn10 {

    public static String reverseByWords(String sentence) {
        // do stuff here

        String newStr = "";
        int end = sentence.length();

        for(int i=sentence.length()-1;i>=0; i--)
        {
            if(sentence.charAt(i)== ' ')
            {
                int j = i+1;
                while(j!=end) {
                    newStr += sentence.charAt(j);
                    j++;
                }
                newStr+=" ";
                end = i;
            }

        }

        int i = 0;
        while(i!=end)
        {
            newStr += sentence.charAt(i);
            i++;
        }
        return newStr;
    }

    public static void main(String[] args) {

        String str = "my name is vinod and i live in bangalore";
        System.out.println(reverseByWords(str));
    }

}

