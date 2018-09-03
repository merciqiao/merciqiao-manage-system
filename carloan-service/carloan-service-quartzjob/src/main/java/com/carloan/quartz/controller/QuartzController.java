package com.carloan.quartz.controller;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.quartzjob.JobInfoVO;
import com.carloan.apimodel.quartzjob.QuartzVO;
import com.carloan.apimodel.quartzjob.TriggerExtVO;
import com.carloan.apimodel.quartzjob.TriggerInfoVO;
import com.carloan.quartz.service.SchedulerService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by zhangyl on 2018/6/28
 */
@RestController
@Api(value = "定时任务")
@RequestMapping(value = "quartz")
public class QuartzController {
    @Autowired
    private SchedulerService schedulerService;

    @ApiOperation(value = "查看所有任务")
    @RequestMapping(value = "listTriggerInfo", method = RequestMethod.POST)
    public ResponseResult<PageInfo<TriggerInfoVO>> listTriggerInfo(@RequestBody TriggerExtVO triggerExtVO) {
        ResponseResult<PageInfo<TriggerInfoVO>> result = new ResponseResult<>();
        result.setData(schedulerService.listTriggerInfo(triggerExtVO));
        return result;
    }

    @ApiOperation(value = "查看单个任务")
    @RequestMapping(value = "{jobName}", method = RequestMethod.GET)
    public ResponseResult<JobInfoVO> selectJobInfoByJobName(@PathVariable(value = "jobName") String jobName) {
        ResponseResult<JobInfoVO> result = new ResponseResult<>();
        JobInfoVO jobInfoVO = schedulerService.selectJobInfoByJobName(jobName);
        result.setData(jobInfoVO);
        return result;
    }

    @ApiOperation(value = "添加任务")
    @RequestMapping(value = "addJob", method = RequestMethod.POST)
    public ResponseResult<Object> addJob(@Valid @RequestBody QuartzVO vo, BindingResult result) {
        schedulerService.addJob(vo);
        return new ResponseResult<>();
    }

    @ApiOperation(value = "删除任务")
    @RequestMapping(value = "/{jobName}", method = RequestMethod.DELETE)
    public ResponseResult<Object> delete(@PathVariable(value = "jobName") String jobName) {
        schedulerService.deleteJob(jobName);
        return new ResponseResult<>();
    }

    @ApiOperation(value = "修改任务")
    @RequestMapping(value = "updateJob",method = RequestMethod.POST)
    public ResponseResult<Object> updateJob(
            @RequestParam(value = "jobName") @Valid String jobName,
            @RequestParam(value = "cron") @Valid String cron,BindingResult result) {
        schedulerService.updateJob(jobName, cron);
        return new ResponseResult<>();
    }

    @ApiOperation(value = "暂停任务")
    @RequestMapping(value = "pauseJob/{jobName}", method = RequestMethod.PUT)
    public ResponseResult<Object> pauseJob(@PathVariable(value = "jobName") String jobName){
        schedulerService.pauseTrigger(jobName);
        return new ResponseResult<>();
    }

    @ApiOperation(value = "恢复任务")
    @RequestMapping(value = "resumeJob/{jobName}", method = RequestMethod.PUT)
    public ResponseResult<Object> resumeJob(@PathVariable(value = "jobName") String jobName){
        schedulerService.resumeTrigger(jobName);
        return new ResponseResult<>();
    }
}
