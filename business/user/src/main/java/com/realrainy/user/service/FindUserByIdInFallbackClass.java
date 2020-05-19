package com.realrainy.user.service;

import com.alibaba.fastjson.JSON;
import com.realrainy.user.entity.WpUser;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class FindUserByIdInFallbackClass {

    public static String findUserByIdInFallback(HttpServletRequest request, Integer param, Throwable e) {
        List<WpUser> list = new ArrayList<>();
        WpUser user = new WpUser();
        user.setId("类限流降级");
        user.setNickName("限流降级用户");
        user.setName("非抛出异常处理");
        list.add(user);
        return JSON.toJSONString(list);
    }
}
