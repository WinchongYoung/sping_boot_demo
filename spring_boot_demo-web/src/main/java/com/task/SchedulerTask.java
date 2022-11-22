package com.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 */
@Component
public class SchedulerTask {

    private int count = 0;

    @Scheduled(cron = "0 1 10 * * ?")
    private void process() {
        System.out.println("this is scheduler task runing  " + (count++));
    }

}