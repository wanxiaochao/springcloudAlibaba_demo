package com.realrainy.user.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.ctc.wstx.util.ExceptionUtil;
import com.realrainy.user.entity.WpUser;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private MongoTemplate mongoTemplate;

    //项目中配置加载流控降级规则
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

    @Override
    @SentinelResource(value = "findUser", blockHandler = "findUserBlockHandler")
    public List<WpUser> findUser() {

        Query query = new Query();
        query.limit(10);
        List<WpUser> wpUsers = mongoTemplate.find(query, WpUser.class);
        return wpUsers;
    }

    public List<WpUser> findUserBlockHandler(BlockException e) {
        List<WpUser> list = new ArrayList<>();
        WpUser user = new WpUser();
        user.setNickName("限流降级用户");
        list.add(user);
        return list;
    }

}


