package com.example.InnDB.pojo;

import lombok.Data;

@Data
public class DoubanUser {
    private String userId;
    private String userName;

    public DoubanUser(String userId,String userName){
        this.userId=userId;
        this.userName=userName;
    }


}
