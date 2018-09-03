package com.car.modules.workflow.dispatch.rule;

import com.car.modules.loan.biz.ruleconf.service.BizRuleConfService;
import com.car.modules.workflow.dispatch.rule.entity.ConfVO;
import com.car.modules.workflow.dispatch.rule.entity.UserOrder;
import com.car.modules.workflow.dispatch.rule.enums.ConfTypeEnum;
import com.carloan.common.redisTemplate.service.RedisService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangyl on 2018/7/26
 */
public abstract class AbstractRuleConf implements IRuleConf {
    public final Logger logger = LoggerFactory.getLogger(getClass());
    public static final String KEY = "DISPATCH";
    @Autowired
    private RedisService redisService;
    @Autowired
    protected BizRuleConfService bizRuleConfService;

    @Override
    public String getUserId(ConfVO confVO) {
        String key = confVO.getRuleCode();
        String field=getField(confVO.getArefId());
        String userId = "-1";
        /**
         * 优先从缓存中获取，缓存中没有从db获取
         */
        List<UserOrder> userOrderList = getByCache(key, field);
        if (CollectionUtils.isEmpty(userOrderList)) {
            userOrderList = this.getUserOrder(confVO);
        }
        if (logger.isInfoEnabled()) {
            logger.info("规则:{}下的用户代办数量size:{}", key, userOrderList.size());
        }
        for (UserOrder temp : userOrderList) {
            int maxCount = this.getMaxCount(temp.getUserId(), confVO.getProductId());
            if (temp.getNum() >= maxCount) {
                continue;
            } else {
                temp.setNum(temp.getNum() + 1);
                //重新排序,插入缓存
                Collections.sort(userOrderList, (o1, o2) -> {
                    UserOrder u1 = o1;
                    UserOrder u2 = o2;
                    if (u1.getNum() >= (u2.getNum())) {
                        return 1;
                    } else {
                        return -1;
                    }
                });
                setCache(key, field, userOrderList);
                userId = temp.getUserId().toString();
                return userId;
            }
        }
        return userId;
    }

    private List<UserOrder> getByCache(String key, String field) {
        return redisService.hmGetWithJson(KEY + ":" + key, field, List.class,UserOrder.class);
    }

    private void setCache(String key, String field, List<UserOrder> userOrderList) {
        redisService.hmSetWithJson(KEY + ":" + key, field, userOrderList, 200, TimeUnit.SECONDS);
    }
    /**
     * 获取缓存的field，子类实现
     * @param arefId
     * @return
     */
    private String getField(String arefId){
        StringBuffer buffer=new StringBuffer();
        return buffer.append(arefId).append(":").append(getType()).toString();
    }

    @Override
    public ConfTypeEnum getType() {
        return null;
    }

    /**
     * 获取最大数量，子类去实现
     *
     * @param userId
     * @param productId
     * @return
     */
    protected abstract int getMaxCount(Long userId, String productId);

    /**
     * 获取最大数量，子类去实现
     *
     * @param confVO
     * @return
     */
    protected abstract List<UserOrder> getUserOrder(ConfVO confVO);




}
