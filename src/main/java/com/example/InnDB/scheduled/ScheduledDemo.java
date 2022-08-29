package com.example.InnDB.scheduled;


import com.example.InnDB.common.TransferTools;
import com.example.InnDB.service.DoubanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author jiangchengxing
 * 2022/08/29
 */
@Slf4j
@Component
public class ScheduledDemo {
    //定时器执行间隔
    @Value("${corn_task}")
    String corn_task;
    //文件路径
    @Value("${ftp_System1_filePath}")
    String filePath;

    @Autowired
    DoubanService doubanService;


    @Scheduled(cron = "${corn_task}")
    public void task(){
        File file = new File(filePath+"douban_user202208291135.csv");
        TransferTools.InnDB_csv(file,doubanService);
    }



}
