package com.target.java.training.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableAsThread {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i=1;i<=100;i++)
            {
               log.debug("Inside thread{}. Value of i is {}", Thread.currentThread().getName(), i);
            }
        }, "My-Runnable-Thread");

        // () -> {} is an object of runnable type
        t1.start();
        //t1.run();
        // if we directly give t1.run()
        // the thread is not created separately, but in main stack that is run
        // and then other functions of main are run
        // Multithreading is not happening in this case

        for (int i=1;i<=10;i++)
        {
            log.debug("Inside thread{}. Value of i is {}", Thread.currentThread().getName(), i);
        }

        log.debug("End of Main Method");
    }
}
