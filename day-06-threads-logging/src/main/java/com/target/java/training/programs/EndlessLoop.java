package com.target.java.training.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class EndlessLoop {
    public static void main(String[] args) {
        while(true)
        {
            log.debug("Loop going on forever - current time is" + new Date());
            break;
        }
    }
}
