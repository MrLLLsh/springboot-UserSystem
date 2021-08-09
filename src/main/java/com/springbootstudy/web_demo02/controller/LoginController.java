package com.springbootstudy.web_demo02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    //@RequestParam 请求参数，下面注解为请求参数名为"username"的参数
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session)
    {
        //具体的业务
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //将username对象命名为loginUser
            session.setAttribute("loginUser", username);
            return "redirect:http://localhost:8080/main.html";
        }
        else{
            //告诉登录失败
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }
}
