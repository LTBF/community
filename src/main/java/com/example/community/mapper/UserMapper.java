package com.example.community.mapper;

import com.example.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-18 22:48
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(account, name, token, avatar_url, create_time, update_time)" +
            " values(#{account}, #{name}, #{token}, #{avatarUrl}, #{createTime}, #{updateTime})")
    void insertUser(User user);

    @Select("select * from user where token=#{token} ")
    User selectByToken(@Param("token") String value);

    @Select("select * from user where account=#{account}")
    List<User> selectByCreator(@Param("account") String account);
}
