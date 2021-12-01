package com.target.java.training.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadDemo {
    @SneakyThrows
    // surrounds method with try catch
    // after converting it into unchecked exception
    static void print(int i)
    {
        log.debug("Inside print, the value of i is " + i);
        Thread.sleep(100);
    }
    public static void main(String[] args) {
        Thread t1 = new Thread("My-custom-thread"){
            @Override
            public void run() {
                for(int i = 100; i<=110;i++)
                {
                    print(i);
                }
            } // new class that extends thread class
        };
        t1.start();
        // 1. Instructs the scheduler to create a new stack
        // 2. Scheduler creates a new stack and puts t1.run() function as the first stack function
        // 3. Thread t1 goes to "Runnable" state and only one thread will be running at any time
        // 4. t1 has to wait for its turn, and when the time comes, the current running thread
        //    becomes or changes its state from running to runnable and t1 changes from runnable to running
        // 5. once the run() method of t1 is completely finished, its state is changed to dead


        // When start is initiated, a new stack is created for the
        // thread and puts the t1.run function in the stack as stack frame


        for(int i=1;i<=10;i++)
        {
            print(i);
        }

        // log will print both the outputs of the thread run function and
        // the main function
    }
}
