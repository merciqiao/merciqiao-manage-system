package com.carloan.service.admin.ycyscore.controller;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.service.admin.ycyscore.entity.YcyscoreEntity;
import com.carloan.service.admin.ycyscore.service.YcyscoreService;
import com.carloan.service.admin.ycyscore.vo.YcyscoreVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2019-03-09 14:21:07
 */
@RestController
@RequestMapping(value="/ycyscore-api")
@Slf4j
public class YcyscoreController {
	@Autowired
	private YcyscoreService ycyscoreService;

	/**
	 * 写入分数
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Response add(@RequestBody YcyscoreEntity vo)throws Exception{
		Response result=new Response();
		try{
			YcyscoreVO mayiVO= ycyscoreService.queryObject(vo.getIp());
			if(mayiVO!=null){
				//如果分数比历史分低,则不更新分
				if(vo.getScore()<mayiVO.getScore()){
					vo.setScore(null);
				}
				vo.setTimes(mayiVO.getTimes()+1);
				ycyscoreService.update(vo);
			}
			else{
				ycyscoreService.save(vo);
			}
			return result;
		}catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}
	}

	/**
	 * 查询前30名排名
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryList",method = RequestMethod.POST)
	public ResponseResult<YcyscoreVO> queryList(@RequestBody YcyscoreEntity vo)throws Exception{
		ResponseResult<YcyscoreVO> result=new ResponseResult<>();
		try{
			result= (ResponseResult<YcyscoreVO>)ycyscoreService.queryList(vo);
			return result;
		}catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}
	}
	@RequestMapping(value = "/queryScore",method = RequestMethod.POST)
	public ResponseResult<Integer> queryOne(@RequestBody YcyscoreEntity vo)throws Exception{
		ResponseResult<Integer> result=new ResponseResult<>();
		try{
			YcyscoreVO ycyscoreVO= ycyscoreService.queryObject(vo.getIp());
			int score=ycyscoreVO==null?0:ycyscoreVO.getScore();
			result.setData(score);
			return result;
		}catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}
	}

	/**
	 * 查询个人排名
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryRank",method = RequestMethod.POST)
	public ResponseResult<Integer> queryRank(@RequestBody YcyscoreEntity vo)throws Exception{
		ResponseResult<Integer> result=new ResponseResult<>();
		try{
			Integer rank=0;
			YcyscoreVO mayiVO= ycyscoreService.queryObject(vo.getIp());
			if(mayiVO==null){
				rank=ycyscoreService.queryTotal();
			}
			else{
				rank= ycyscoreService.queryRank(vo);
			}
			result.setData(rank);
			return result;
		}catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}
	}
}
