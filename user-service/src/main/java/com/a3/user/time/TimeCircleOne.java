package com.a3.user.time;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务执行
 * 
 * @author Donald 2019-01-17 13:00
 *
 */
@Component
public class TimeCircleOne {

    // 定时任务单位毫秒
    @Scheduled(fixedRate = 1000)
    public void timeMarke() {};

    @Scheduled(cron = "0/1 * * * * MON-FRI *")
    public void timeMarke2() {};

}
