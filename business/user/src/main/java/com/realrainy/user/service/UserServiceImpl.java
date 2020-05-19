package com.realrainy.user.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.ctc.wstx.util.ExceptionUtil;
import com.realrainy.user.entity.WpUser;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
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

    @Override
    public List<WpUser> findUser() {
        Query query = new Query();
        query.limit(10);
        List<WpUser> wpUsers = mongoTemplate.find(query, WpUser.class);
        return wpUsers;
    }

    @Override
    public List<WpUser> findUserByIdIn(List<String> ids) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").in(ids));
        List<WpUser> wpUsers = mongoTemplate.find(query, WpUser.class);
        return wpUsers;
    }
}


