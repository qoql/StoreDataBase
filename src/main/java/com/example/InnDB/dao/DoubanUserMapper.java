package com.example.InnDB.dao;



import com.example.InnDB.pojo.DoubanUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoubanUserMapper {
    public int insertObject(List<DoubanUser> list);

}
