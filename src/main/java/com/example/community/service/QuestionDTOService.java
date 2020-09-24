package com.example.community.service;

import com.example.community.dto.QuestionDTO;
import com.example.community.mapper.QuestionMapper;
import com.example.community.mapper.UserMapper;
import com.example.community.model.Question;
import com.example.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-20 17:26
 */
@Service
public class QuestionDTOService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;


    public List<QuestionDTO> list(Integer offset, Integer num) {

        List<Question> questionList = questionMapper.list(offset, num);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questionList) {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            List<User> userList = userMapper.selectByCreator(question.getAccount());
            questionDTO.setUser(userList.get(0));
            questionDTOList.add(questionDTO);
        }

        return questionDTOList;
    }
}
