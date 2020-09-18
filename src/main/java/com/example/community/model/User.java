package com.example.community.model;

import lombok.Data;

import java.util.Date;


/**
 * @author shkstart
 * @create 2020-09-18 22:49
 */
@Data
public class User {

    private int id;
    private String account;
    private String name;
    private String token;
    private Date createTime;
    private Date updateTime;
}
