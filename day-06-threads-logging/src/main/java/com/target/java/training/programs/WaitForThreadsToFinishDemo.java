package com.target.java.training.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class WaitForThreadsToFinishDemo {

    static void print(String msg, int limit)
    {
        for (int i=1;i<=limit;i++)
        {
            log.debug("Message = {}, i = {}", msg, i);
        }
    }
    @SneakyThrows
    public static void main(String[] args) {

        Thread t1, t2;
        t1 = new Thread(() -> print("Hello!", 10));
        t2 = new Thread(() -> print("Welcome", 20));

        t1.start();
        t2.start();

        // 3 stacks, one each for t1, t2 and main threads


        print("Vinod", 3);

       // log.debug("End of main");


        // To kill main only after all the other threads are completed

        t1.join(); // Waits for t1 to finish executing its run function
        t2.join(); // Waits for t2 to finish executing its run function

        log.debug("End of main");
        // Main ends only after both t1 and t2 end
        // Use this concept if there are any cleanup activities to be done
        // On some common resources such as database resources used by
        // threads t1 and t2, and then do the cleanup and exit the main thread




    }
}
