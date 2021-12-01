package com.target.java.training.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j

public class DaemonThreadDemo {

    @SneakyThrows
    static void myWait(long duration){
       Thread.sleep(duration);
   }

   static void startThread()
   {
       Runnable r = ()->{
           while (true)
           {
               log.debug("THe time now is {}", new Date().toString());
               myWait(1000);
           }
       };

       Thread t1 = new Thread(r);
       t1.setDaemon(true); // This says that the thread should be killed after all
       // non-daemon threads are killed
       t1.start();
   }

    public static void main(String[] args) {

     /*   Runnable r = ()->{
            while (true)
            {
                log.debug("THe time now is {}", new Date().toString());
                myWait(1000);
            }
        };

        Thread t1 = new Thread(r);
                t1.start(); // This thread will run endlessly.

*/

        for(int i=1;i<=10;i++)
        {
            log.debug("Inside main, value of i is {}", i);
            myWait(500);
        }

        log.debug("End of main()");

        // To stop the thread after main,
        //t1.stop();
        // But this method is deprecated as it is unsafe

        // What if the entire thread is written in another function?
        // In this case, t1,stop() wont work!




    }
}
