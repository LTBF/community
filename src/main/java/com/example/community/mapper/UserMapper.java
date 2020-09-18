package com.example.community.mapper;

import com.example.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shkstart
 * @create 2020-09-18 22:48
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(account, name, token, create_time, update_time) values(#{account}, #{name}, #{token}, #{createTime}, #{updateTime})")
    void insertUser(User user);
}
