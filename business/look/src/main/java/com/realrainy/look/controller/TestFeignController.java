package com.realrainy.look.controller;

import com.realrainy.look.feign.FeignClientService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class TestFeignController {

    @Resource
    private FeignClientService feignClientService;

    //下游服务限流测试
    @RequestMapping("/testFeign")
    public String testFeign(HttpServletRequest request) {
        return feignClientService.findUser();
    }

    //下游服务降级测试
    @RequestMapping("/testFeign2")
    public String testFeign2(HttpServletRequest request, Integer param) {
        return feignClientService.findUserByIdIn(param);
    }

    //下游服务限流降级测试
    @RequestMapping("/testFeign3")
    public String testFeign3(HttpServletRequest request, Integer param) {
        return feignClientService.findUserByIdIn2(param);
    }

    //feign降级测试
    @RequestMapping("/feignDegrade")
    public String feignDegrade(HttpServletRequest request, Integer param) {
        return feignClientService.feignDegrade(param);
    }

    @Resource
    private RestTemplate restTemplate;

    //ribbon限流测试
    @RequestMapping("/degradeRestTemplate")
    public String degradeRestTemplate(HttpServletRequest request) {
        String forObject = restTemplate.getForObject("http://user-service/findByUser", String.class);
        return forObject;
    }

}
