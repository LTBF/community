package com.example.community.controller;

import com.example.community.dto.QuestionAndPageDTO;
import com.example.community.mapper.UserMapper;
import com.example.community.model.User;
import com.example.community.service.QuestionAndPageDTOService;
import com.example.community.service.QuestionDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author shkstart
 * @create 2020-09-17 22:13
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionDTOService questionDTOService;

    @Autowired
    private QuestionAndPageDTOService questionAndPageDTOService;

    @GetMapping("/")
    public String index(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "3")Integer pageSize,
                        HttpServletRequest request,
                        Model model){

        Cookie[] cookies = request.getCookies();
        // token免登录
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("token")){
                    User user = userMapper.selectByToken(cookie.getValue());
                    if(user != null){
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        // 获取问题列表
        /*List<QuestionDTO> questionDTOList = questionDTOService.list(pageNum, pageSize);
        model.addAttribute("questions", questionDTOList);*/
        QuestionAndPageDTO questionAndPageDTO = questionAndPageDTOService.getList(pageNum, pageSize);
        model.addAttribute("questions", questionAndPageDTO);

        return "index";
    }
}
