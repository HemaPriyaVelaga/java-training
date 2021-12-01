package com.target.java.training.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Slf4j


public class ReadFromFileUsingThreadDemo {

    static class FileProcessor
    {
        public void process(String filename, FileReader reader)
        {
            try (BufferedReader in = new BufferedReader(reader)) {
                String line;
                while((line = in.readLine() )!= null)
                {
                    log.debug("Filename = {}, line = {}", filename, line.toUpperCase());
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        String filename1 = "src/main/java/com/target/java/training/programs/EndlessLoop.java";
        String filename2 = "src/main/java/com/target/java/training/programs/ThreadDemo.java";
        String filename3 = "src/main/java/com/target/java/training/programs/LoggingDemo.java";

        Thread t1, t2, t3;
        try (FileReader file3 = new FileReader(filename3);
             FileReader file1= new FileReader(filename1);
             FileReader file2= new FileReader(filename2);) {

            FileProcessor fp = new FileProcessor();

            t1 = new Thread(() -> fp.process(filename1, file1));
            t2 = new Thread(() -> fp.process(filename2, file2));
            t3 = new Thread(() -> fp.process(filename3, file3));


            t1.start();
            t2.start();
            t3.start();

            // We are saying the file close till all the threads are done executing
            // i.e., exit the try block only when the tasks are done
            t1.join();
            t2.join();
            t3.join();
        } // files are automatically close here without the need for giving the
        // functions file.close()

            // We may get exception because the files are started but after sometime,
            // file1.close() got executed and the thread can no longer read the file
            // The same happens with all the files and threads
            // So, remove the following lines and surround the FileReader class object with try with resources

//            file1.close();
//            file2.close();
//            file3.close();
    }
}

