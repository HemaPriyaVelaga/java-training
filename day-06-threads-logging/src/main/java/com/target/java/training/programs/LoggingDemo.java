package com.target.java.training.programs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDemo {

   public static final Logger log = LoggerFactory.getLogger(LoggingDemo.class);

    public static void main(String[] args) {

        log.trace("This is a trace message");
        log.debug("Debug message");
        log.info("Info trace message");
        log.warn("Warn trace message");
        log.error("Error message");
        log.trace("Log trace set up.");

    }
}
