package com.example.community.model;

import lombok.Data;

import java.util.Date;

/**
 * @author shkstart
 * @create 2020-09-19 19:51
 */
@Data
public class Question {

    private int id;
    private String title;
    private String text;
    private String account;
    private int commentCount;
    private int viewCount;
    private int likeCount;
    private Date createTime;
    private Date updateTime;
}
