package com.carloan.feign.master.feign;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.master.sysdict.SysDictDetailDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
 /*
                           _ooOoo_
                          o8888888o
                          88" . "88
                          (| -_- |)
                          O\  =  /O
                       ____/`---'\____
                     .'  \\|     |//  `.
                    /  \\|||  :  |||//  \
                   /  _||||| -:- |||||-  \
                   |   | \\\  -  /// |   |
                   | \_|  ''\---/''  |   |
                   \  .-\__  `-`  ___/-. /
                 ___`. .'  /--.--\  `. . __
              ."" '<  `.___\_<|>_/___.'  >'"".
             | | :  `- \`.;`\ _ /`;.`/ - ` : | |
             \  \ `-.   \_ __\ /__ _/   .-` /  /
        ======`-.____`-.___\_____/___.-`____.-'======
                           `=---='
        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                 佛祖保佑       永无BUG
 */

/**
 * @classname: SysDictDetailServicefeign
 * @description: 定义  sys_dict_detail,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-master",path = "/api/sysDictDetail" ,fallback = SysDictDetailServiceHystrix.class)
public interface SysDictDetailServicefeign {

	/**
	 * 取得单个业务对象
	 * @return
	 */
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	public ResponseResult<Object> querySysDictDetailByPrimaryKey(@PathVariable("ID") String ID);

	/**
	 * 取得List业务对象
	 * @return
	 */
	@RequestMapping(value = "/getSysDictDetailList", method = RequestMethod.POST)
	public ResponseResult<Object> querySysDictDetailList(@RequestBody SysDictDetailDTO obj);



	/**
	 * 根据对象查询信息返回单个实体
	 * @return
	 */
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	public ResponseResult<Object> queryLikeSysDictDetail(@RequestBody SysDictDetailDTO obj);


	/**
	 * 创建业务对象
	 * @return
	 */
	@RequestMapping(value="/create/v1",method=RequestMethod.POST)
	public ResponseResult insertSysDictDetail(@RequestBody SysDictDetailDTO obj);

	/**
	 * 修改业务对象
	 * @return
	 */
	@RequestMapping(value="/update/v1",method=RequestMethod.POST)
	public ResponseResult updateSysDictDetail(@RequestBody SysDictDetailDTO obj);


	@RequestMapping(value = "/searchCodeSysDictDetail", method = RequestMethod.POST)
	public ResponseResult<Object> searchCodeSysDictDetail(@RequestParam("code") String  code);




}
