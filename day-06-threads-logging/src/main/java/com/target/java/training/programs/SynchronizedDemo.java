package com.target.java.training.programs;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SynchronizedDemo {

    @AllArgsConstructor
    static class  FileProcessor
    {
        String filename;

        // Read file and store in list
        @SneakyThrows
        public void readAndStore(List<String > list){
            try(FileReader reader = new FileReader(filename);
                BufferedReader in = new BufferedReader(reader);){
                String line;
                while((line = in.readLine())!= null)
                {
                   // list.add(line); // list is a shared resource so, we might not get all data of all files

                    // to prevent the above issue
                    synchronized (list)
                    {
                        list.add(line); // Now, we wont get any loss of data
                    }

                    // If list and line are both shared resources

                   /* synchronized (list)
                    {
                        synchronized (line)
                            list.add(line);
                    }*/
                    // Or, we can type the function as synchronised
                    // Instead of the above code
                    // But in that case, the threads will execute sequentially
                }
            }
        }
    }

    @SneakyThrows
    static void waitForThreadToFinish(Thread t)
    {
        t.join();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(1000);
        String [] filenames = { "f1.txt",
                        "f2.txt",
                        "f3.txt"};


        List<Thread> threads = new ArrayList<>();

        for (String filename: filenames)
        {
            Thread t = new Thread(()->new FileProcessor(filename).readAndStore(list));
            t.start();
            threads.add(t);
        }

        // to join all the threads so that we can execute the next for loop after all threads stop
        // Take a list of threads and join them

        threads.forEach(SynchronizedDemo::waitForThreadToFinish);

        for(String line: list)
        {
            System.out.println(line);
        }
    }
}
