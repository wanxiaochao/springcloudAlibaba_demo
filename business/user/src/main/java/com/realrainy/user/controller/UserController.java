package com.realrainy.user.controller;

import com.alibaba.fastjson.JSON;
import com.realrainy.user.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/findByUser")
    public String findByUser(HttpServletRequest request) {
        return JSON.toJSONString(userService.findUser());
    }

    @Value("${username:lily}")
    private String username;

    @RequestMapping("/username")
    public String get() {
        return username;
    }


}
