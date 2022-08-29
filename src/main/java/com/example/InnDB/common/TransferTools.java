package com.example.InnDB.common;

import com.example.InnDB.pojo.DoubanUser;
import com.example.InnDB.service.DoubanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Component
public class TransferTools {


    public static void InnDB_csv(File file,DoubanService doubanService){
        if(file==null){
            log.info("文件为空，请核对路径");
        }
        log.info("开始存入数据库");
        BufferedReader br = null;
        //用来存取文件记录
        List<DoubanUser> list = null;
        try {
            //记录程序开始时的系统时间
            long l1 = System.currentTimeMillis();
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            log.info("字符缓存读取流正常");
            //文件开头是一串空行，先把空串读出
            String line = br.readLine();
            list = new LinkedList<>();
            do {
                line = br.readLine();
                if(line!=null && line.length()>10){
                    //获取第一个”,“前的字符串
                    String userId = line.substring(0,line.indexOf(","));
                    //log.info("userId");
                    //获取第一个","后的字符串
                    String user_name = line.substring(line.indexOf(",")+1,line.length());
                    //封装为一个用户类
                    DoubanUser user = new DoubanUser(userId,user_name);
                    //存入集合
                    list.add(user);
                    //数据存入量到1000时执行存入操作
                    if (list.size()==1000){
                        log.info("集合长度到达1000，开始存入");
                        //用户类存入数据库
                        doubanService.insertObject(list);
                        //清空集合
                        list.clear();
                    }

                }
            }while (line!=null);
            if(list!=null){
                //将剩余记录数不到1000的数据存入
                doubanService.insertObject(list);
            }
            //记录程序结束时的系统时间
            long l2 = System.currentTimeMillis();
            log.info("存入数据库事务结束，耗时："+(l2-l1)/1000+"秒");
        } catch (RuntimeException e){
          log.info("空指针异常");
        } catch (Exception e){
            e.printStackTrace();
            log.error("存入数据库错误");
            log.info("集合存入的数据量："+String.valueOf(list.size()));
        } finally {
            try {
                if(br!=null){
                    br.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }

        }

    }



}
