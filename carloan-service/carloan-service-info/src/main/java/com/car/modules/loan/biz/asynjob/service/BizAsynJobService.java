package com.car.modules.loan.biz.asynjob.service;

import com.car.modules.loan.biz.asynjob.dao.BizAsynJobMapper;
import com.car.modules.loan.biz.asynjob.dto.BizAsynJobDO;
import com.carloan.apimodel.biz.enums.AsynJobEnum;
import com.carloan.apimodel.biz.BizAsynJobVO;
import com.carloan.common.utils.DateUtil;
import com.carloan.common.utils.SpringUtil;
import com.carloan.common.utils.ThreadPoolUtil;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;


/**
 * Created by zhangyl on 2018/8/8
 */
@Service
public class BizAsynJobService {
    public static final Logger logger = LoggerFactory.getLogger(BizAsynJobService.class);
    @Autowired
    private BizAsynJobMapper bizAsynJobMapper;
    @Autowired
    private SpringUtil springUtil;

    private IBizAsynJobService bizAsynJobService;

    public int insert(BizAsynJobVO bizAsynJobVO) {
        /**
         * 判断asynJobStatus状态是否正确
         */
        AsynJobEnum asynJobEnum = AsynJobEnum.acquire(bizAsynJobVO.getJobState());
        if (asynJobEnum == null) {
            logger.error("没有这个类型的异步处理类", bizAsynJobVO.toString());
            throw new RuntimeException("没有这个类型的异步处理类");
        }
        BizAsynJobDO bizAsynJobDO = new BizAsynJobDO();
        BeanUtils.copyProperties(bizAsynJobVO, bizAsynJobDO);
        return bizAsynJobMapper.insertSelective(bizAsynJobDO);
    }
    public int insertBizAsynJobDO(BizAsynJobDO bizAsynJobDO) {
        /**
         * 判断asynJobStatus状态是否正确
         */
        AsynJobEnum asynJobEnum = AsynJobEnum.acquire(bizAsynJobDO.getJobState());
        if (asynJobEnum == null) {
            logger.error("没有这个类型的异步处理类", bizAsynJobDO.toString());
            throw new RuntimeException("没有这个类型的异步处理类");
        }
        bizAsynJobDO.setCreateTime(new Date());
        return bizAsynJobMapper.insertSelective(bizAsynJobDO);
    }
    public int executeAsynJob(int jobState) {
        Map<String, Long> map = null;
        ThreadPoolExecutor executor = null;
        int complete = 0;
        PageHelper.startPage(0, 400, false);
        List<BizAsynJobDO> list = bizAsynJobMapper.listByJobState(jobState);
        if (list.size() > 0) {
            map = new ConcurrentHashMap<>();
            executor = ThreadPoolUtil.getInstance().getThreadPool(10, 20, 5, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
        }
        for (BizAsynJobDO asynJobDO : list) {
            Long key = asynJobDO.getId();
            if (map.containsKey(key)) {
                continue;
            }
            map.put(key.toString(), key);
            asynJobDO.setStartTime(new Date());
            try {
                Future<Boolean> future = executor.submit(() -> {
                    Object object = springUtil.getBean(asynJobDO.getBeanClass());
                    if (object instanceof IBizAsynJobService) {
                        bizAsynJobService = (IBizAsynJobService) object;
                        return bizAsynJobService.executeAsynJob(asynJobDO.getBizKeyId());
                    }

                    return Boolean.FALSE;
                });
                boolean flag = future.get();
                if (flag) {
                    complete++;
                    asynJobDO.setJobState(AsynJobEnum.COMPLETE.getStatus());
                }
            } catch (InterruptedException e) {
                logger.error("线程中断", e);
                asynJobDO.setErrorRemark(DateUtil.dateToStr(new Date())+":"+e.getMessage());
            } catch (ExecutionException e) {
                logger.error("任务异常", e);
                asynJobDO.setErrorRemark(DateUtil.dateToStr(new Date())+":"+e.getMessage());
            } finally {
                map.remove(key);
                //更新bizAysnJob
                asynJobDO.setJobRun(asynJobDO.getJobRun() + 1);
                asynJobDO.setEndTime(new Date());
                bizAsynJobMapper.updateByPrimaryKeySelective(asynJobDO);
            }
        }
        return complete;
    }
}
