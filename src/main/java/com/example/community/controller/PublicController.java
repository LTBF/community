package com.example.community.controller;

import com.example.community.mapper.QuestionMapper;
import com.example.community.model.Question;
import com.example.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author shkstart
 * @create 2020-09-19 11:44
 */
@Controller
public class PublicController {

    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String publish(){

        return "publish";
    }

    // @RequestParam是根据name接收的
    @PostMapping("/publish")
    public String publishDetail(@RequestParam("title")String title,
                                @RequestParam("text")String text,
                                @RequestParam("tag")String tag,
                                HttpServletRequest request,
                                Model model){
        model.addAttribute("title", title);
        model.addAttribute("text", text);
        model.addAttribute("tag", tag);

        // 登录验证
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }

        User user = (User)session.getAttribute("user");
        Question question = new Question();
        question.setTitle(title);
        question.setText(text);
        question.setCommentCount(0);
        question.setLikeCount(0);
        question.setViewCount(0);
        question.setCreateTime(new Date());
        question.setAccount(user.getAccount());
        question.setUpdateTime(question.getCreateTime());
        questionMapper.insertQuestion(question);

        return "redirect:/";
    }
}
