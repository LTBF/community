package com.example.community.service;

import com.example.community.dto.QuestionAndPageDTO;
import com.example.community.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shkstart
 * @create 2020-09-24 20:41
 */

@Service
public class QuestionAndPageDTOService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired QuestionDTOService questionDTOService;

    public QuestionAndPageDTO getList(int pageNum, int pageSize){

        int total = questionMapper.count();
        QuestionAndPageDTO questionAndPageDTO = new QuestionAndPageDTO(pageNum, pageSize, total);
        questionAndPageDTO.setQuestionDTOList(questionDTOService.list((questionAndPageDTO.getPageNum() - 1) * pageSize, questionAndPageDTO.getPageSize()));

        return questionAndPageDTO;
    }

}
