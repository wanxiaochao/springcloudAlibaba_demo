package com.realrainy.look.controller;

import com.realrainy.look.feign.FeignClientService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class TestFeignController {

    @Resource
    private FeignClientService feignClientService;

    @RequestMapping("/testFeign")
    public String testFeign(HttpServletRequest request) {
        return feignClientService.findUser();
    }


}
