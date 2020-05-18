package com.realrainy.look.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "user-service")
public interface FeignClientService {

    @GetMapping("/findByUser")
    String findUser();


}
