package com.system.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.pojo.Staff;

@Controller
public class LoginController {

    //登录跳转
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginUI() throws Exception {
        return "/login";
    }

    //登出
    @RequestMapping(value="/logout",method = {RequestMethod.GET})
    public String logout() throws Exception{
        return "/login";
    }


    //登录表单处理
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String login(Model model,Staff staff) throws Exception {

        //Shiro实现登录
        UsernamePasswordToken token = new UsernamePasswordToken(staff.getStaffId(),staff.getPassword());
        Subject subject = SecurityUtils.getSubject();

        //获取用户名
        subject.login(token);


        if (subject.hasRole("admin")) {
            return "redirect:/admin/showStaff";
        } else if (subject.hasRole("manager")) {
            return "redirect:/managers/showMassage";
        } else if (subject.hasRole("staff")) {
            return "redirect:/staff/sign";
        }

        return "/login";
    }

}
