package com.example.community.mapper;

import com.example.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-19 19:53
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title, text, account, comment_count, view_count, like_count, create_time, update_time)" +
            " values(#{title}, #{text}, #{account}, #{commentCount}, #{viewCount}, #{likeCount}, #{createTime}, #{updateTime})")
    void insertQuestion(Question question);

    @Select("select * from question limit #{offset},#{num}")
    List<Question> list(@Param("offset") Integer offset, @Param("num") Integer num);

    @Select("select count(1) from question")
    int count();
}
