package com.zhou.security.springboot.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DateTask {

    @Scheduled(cron = "*/1 * * * * ?")
    public void printTime() {
        System.out.println(System.currentTimeMillis());
    }
}
