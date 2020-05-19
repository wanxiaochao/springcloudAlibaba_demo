package com.realrainy.user.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.realrainy.user.entity.WpUser;
import com.realrainy.user.service.FindUserBlockHandlerClass;
import com.realrainy.user.service.FindUserByIdInFallbackClass;
import com.realrainy.user.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    //项目中配置加载流控规则
/*    @PostConstruct//这个注解就是项目启动的时候会执行一些操作
    private void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("findUser");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置QPS为1
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }*/
    /** --------------------------------限流测试---------------------------------- */
    @RequestMapping("/findByUser")
    //使用blockHandlerClass blockHandler也需要指定方法名且方法参数也需要保持一致且多加一个BlockException参数
    @SentinelResource(value = "findUser", blockHandler = "findUserBlockHandler", blockHandlerClass = FindUserBlockHandlerClass.class)
    public String findByUser(HttpServletRequest request) {
        return JSON.toJSONString(userService.findUser());
    }

/*    public String findUserBlockHandler(HttpServletRequest request, BlockException e) {
        List<WpUser> list = new ArrayList<>();
        WpUser user = new WpUser();
        user.setId("方法限流降级");
        user.setNickName("限流降级用户");
        user.setName("非抛出异常处理");
        list.add(user);
        return JSON.toJSONString(list);
    }*/

    /** --------------------------------降级测试---------------------------------- */
    @RequestMapping("/findUserByIdIn")
    @SentinelResource(value = "findUserByIdIn", fallback = "findUserByIdInFallback", fallbackClass = FindUserByIdInFallbackClass.class)
    public String findUser(HttpServletRequest request, Integer param) {

        List<String> list = new ArrayList<>();
        list.add("5c626f9162d9f92d6c336308");
        list.add("5c626fcc62d9f92bc21f0a78");
        list.add("5c6270f662d9f92c6eaa97fb");
        list.add("5c62712b62d9f92bc21f0a84");
        list.add("5c62714862d9f92bc21f0a91");
        if (1 == param) {
            throw new RuntimeException();
        }
        return JSON.toJSONString(userService.findUserByIdIn(list));
    }

    //这里的Throwable非必须
    /*public String findUserByIdInFallback(HttpServletRequest request, Integer param, Throwable e) {
        System.out.println(e);
        List<WpUser> list = new ArrayList<>();
        WpUser user = new WpUser();
        user.setId("方法限流降级");
        user.setNickName("限流降级用户");
        user.setName("抛出异常处理");
        list.add(user);
        return JSON.toJSONString(list);
    }*/

    /** --------------------------------限流降级测试 这里现在即使发生异常也会走blockHandler处理---------------------------------- */

    @RequestMapping("/findUserByIdIn2")
    @SentinelResource(value = "findUserByIdIn2",blockHandler = "findUserBlockHandler",blockHandlerClass = FindUserBlockHandlerClass.class,
            fallback = "findUserByIdInFallback", fallbackClass = FindUserByIdInFallbackClass.class)
    public String findUser2(HttpServletRequest request, Integer param) {

        List<String> list = new ArrayList<>();
        list.add("5c626f9162d9f92d6c336308");
        list.add("5c626fcc62d9f92bc21f0a78");
        list.add("5c6270f662d9f92c6eaa97fb");
        list.add("5c62712b62d9f92bc21f0a84");
        list.add("5c62714862d9f92bc21f0a91");
        if (1 == param) {
            throw new RuntimeException();
        }
        return JSON.toJSONString(userService.findUserByIdIn(list));
    }

    /** --------------------------------feign降级测试 再feign调用断处理---------------------------------- */
    @RequestMapping("/feignDegrade")
    public String feignDegrade(HttpServletRequest request, Integer param) {

        List<String> list = new ArrayList<>();
        list.add("5c626f9162d9f92d6c336308");
        list.add("5c626fcc62d9f92bc21f0a78");
        list.add("5c6270f662d9f92c6eaa97fb");
        list.add("5c62712b62d9f92bc21f0a84");
        list.add("5c62714862d9f92bc21f0a91");
        if (1 == param) {
            throw new RuntimeException();
        }
        return JSON.toJSONString(userService.findUserByIdIn(list));
    }

    /** --------------------------------动态配置测试---------------------------------- */
    @Value("${username:lily}")
    private String username;

    @RequestMapping("/username")
    public String get() {
        return username;
    }


}
