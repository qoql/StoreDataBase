package com.example.InnDB.service;

import com.example.InnDB.dao.DoubanUserMapper;
import com.example.InnDB.pojo.DoubanUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DoubanServiceImpl implements DoubanService {

    @Autowired
    DoubanUserMapper doubanMapper;

    @Override
    public void insertObject(List<DoubanUser> list) {
        doubanMapper.insertObject(list);
    }


}
