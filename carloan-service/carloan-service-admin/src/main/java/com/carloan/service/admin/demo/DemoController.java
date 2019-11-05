package com.carloan.service.admin.demo;


import com.carloan.apimodel.common.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping(value="/demo-api")
@Slf4j
public class DemoController {
    /**
     * POST:RequestBody传参
     * @param demo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/post_body",method = RequestMethod.POST)
    public ResponseResult<DemoVo> post_body(@RequestBody DemoEntity demo)throws Exception {
        ResponseResult<DemoVo> result=new ResponseResult<DemoVo>();
        DemoVo demoVo=new DemoVo();
        demoVo.setName(demo.getName());
        demoVo.setCity(demo.getCity());
        demoVo.setCreatetime(new Date());
        result.setData(demoVo);
        result.setMessage("这是POST:RequestBody传参");
        return result;
    }
    /**
     * POST:RequestParam传参
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/post_form",method = RequestMethod.POST)
    public ResponseResult<DemoVo> post_form(@RequestParam String name,@RequestParam(value="city") String city)throws Exception {
        ResponseResult<DemoVo> result=new ResponseResult<DemoVo>();
        DemoVo demoVo=new DemoVo();
        demoVo.setName(name);
        demoVo.setCity(city);
        demoVo.setCreatetime(new Date());
        result.setData(demoVo);
        result.setMessage("这是POST:RequestParam传参");
        return result;
    }
    /**
     * GET:RequestParam传参
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/get_form",method = RequestMethod.GET)
    public ResponseResult<DemoVo> get_form(@RequestParam String name,@RequestParam(value="city") String city)throws Exception {
        ResponseResult<DemoVo> result=new ResponseResult<DemoVo>();
        DemoVo demoVo=new DemoVo();
        demoVo.setName(name);
        demoVo.setCity(city);
        demoVo.setCreatetime(new Date());
        result.setData(demoVo);
        result.setMessage("这是GET:RequestParam传参");
        return result;
    }

}
