package com.example.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shkstart
 * @create 2020-09-17 22:13
 */
@Controller
public class TestController {

    @GetMapping("/test")
    public String test(@RequestParam(name = "name", defaultValue = "default")String name, Model model){
        model.addAttribute("name", name);
        return "index";
    }
}
