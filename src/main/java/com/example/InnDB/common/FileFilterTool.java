package com.example.InnDB.common;

import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileFilter;

public class FileFilterTool implements FileFilter {
    @Value("${file_type}")
    private String fileType;

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().toLowerCase().endsWith(".csv");
    }

    //获取指定路径的文件夹下指定类型的文件
    public static File[] filterFile(){
        //文件夹指定为当前项目路径
        File file = new File("D:\\java\\develop\\shenzhou");
        //过滤获取文件
        File[] files = file.listFiles(new FileFilterTool());
        //System.out.println(Arrays.toString(files));
        return files;
    }

}
