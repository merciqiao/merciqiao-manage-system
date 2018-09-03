package com.car.modules.test;

import com.InfoApplication;
import com.car.modules.workflow.dispatch.rule.entity.ConfVO;
import com.car.modules.workflow.dispatch.rule.DispatchService;
import com.car.modules.workflow.jbpm.service.JbpmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhangyl on 2018/7/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = InfoApplication.class)
public class ServiceTest {
    @Autowired
    private DispatchService dispatchService;
    @Autowired
    private JbpmService jbpmService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void dispatch(){
        ConfVO confVO=new ConfVO();
        confVO.setRuleCode("price_rule");
        confVO.setArefId("1");
        confVO.setBizType("3001");
        String userId= dispatchService.dispatch(confVO);
        System.out.println(userId);
    }
    @Test
    public void dispatchJob(){
        jbpmService.dispatchJob("3001","定价");
    }
    @Test
    public void del(){
        redisTemplate.delete("DISPATCH:price_rule");
    }
}
