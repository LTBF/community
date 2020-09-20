package com.example.community.dto;

import com.example.community.model.User;
import lombok.Data;

import java.util.Date;

/**
 * @author shkstart
 * @create 2020-09-20 17:24
 */
@Data
public class QuestionDTO {
    private int id;
    private String title;
    private String text;
    private String account;
    private int commentCount;
    private int viewCount;
    private int likeCount;
    private Date createTime;
    private Date updateTime;
    private User user;
}
