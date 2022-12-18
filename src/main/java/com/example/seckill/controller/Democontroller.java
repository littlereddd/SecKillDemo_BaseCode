package com.example.seckill.controller;

//测试

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class Democontroller {

//    测试页面跳转
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name", "xxxxx");
        return "hello";
    }
}
