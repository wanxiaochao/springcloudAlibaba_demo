package com.ctc.wstx.util;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

import java.util.HashMap;
import java.util.Map;

public class ExceptionUtil {

    public static ClientHttpResponse handleException(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException exception) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "这是一个限流用户");
        ClientHttpResponse clientHttpResponse = new SentinelClientHttpResponse(JSON.toJSONString(map));
        return clientHttpResponse;
    }

}
