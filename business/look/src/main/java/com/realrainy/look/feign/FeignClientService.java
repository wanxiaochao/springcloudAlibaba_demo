package com.realrainy.look.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//  这里规则就不动态配置到nacos了  注意sentinel和feign使用必须在配置文件开启feign.sentinel.enable=true
@FeignClient(value = "user-service", fallback = EchoServiceFallback.class, configuration = FeignConfiguration.class)
public interface FeignClientService {

    @GetMapping("/findByUser")
    String findUser();

    @PostMapping("/findUserByIdIn")
    String findUserByIdIn(@RequestParam(value = "param") Integer param);

    @PostMapping("/findUserByIdIn2")
    String findUserByIdIn2(@RequestParam(value = "param") Integer param);

    @PostMapping("/feignDegrade")
    String feignDegrade(@RequestParam(value = "param") Integer param);

}

class FeignConfiguration {
    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }
}

class EchoServiceFallback implements FeignClientService {
    @Override
    public String findUser() {
        return null;
    }

    @Override
    public String findUserByIdIn(Integer param) {
        return null;
    }

    @Override
    public String findUserByIdIn2(Integer param) {
        return null;
    }

    @Override
    public String feignDegrade(Integer param) {
        return "feignDegrade{降级用户}";
    }
}

