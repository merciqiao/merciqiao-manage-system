package com.carloan.service.admin.ycyscore.controller;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.common.utils.DateUtil;
import com.carloan.service.admin.ycyscore.entity.YcyscoreEntity;
import com.carloan.service.admin.ycyscore.service.YcyscoreService;
import com.carloan.service.admin.ycyscore.vo.YcyscoreVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


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
				String nowTime= DateUtil.GetDateDay(new Date());
				String todayTime= DateUtil.GetDateDay(mayiVO.getUpdatetime());
				if(nowTime.equals(todayTime)){
					//就是今天的数据,且时间更短
                    if(vo.getMintime()!=null&&mayiVO.getMintime()!=null){
                            if(vo.getMintime()>=mayiVO.getMintime()){
                                vo.setMintime(null);
                            }
                    }

				}
				else{
					//没更新为今天,则更新为今天,同时更新用时
					vo.setTodaytime(new Date());
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
	/**
	 * 查询速度排名
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/querySpeedList",method = RequestMethod.POST)
	public ResponseResult<YcyscoreVO> querySpeedList(@RequestBody YcyscoreEntity vo)throws Exception{
		ResponseResult<YcyscoreVO> result=new ResponseResult<>();
		try{
			result= (ResponseResult<YcyscoreVO>)ycyscoreService.querySpeedList(vo);
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
	@RequestMapping(value = "/queryMinTime",method = RequestMethod.POST)
	public ResponseResult<Integer> queryMinTime(@RequestBody YcyscoreEntity vo)throws Exception{
		ResponseResult<Integer> result=new ResponseResult<>();
		try{
			YcyscoreVO ycyscoreVO= ycyscoreService.queryObject(vo.getIp());
			int score=ycyscoreVO==null?0:(ycyscoreVO.getMintime()==null?0:ycyscoreVO.getMintime());
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
	/**
	 * 查询个人排名
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/querySpeedRank",method = RequestMethod.POST)
	public ResponseResult<Integer> querySpeedRank(@RequestBody YcyscoreEntity vo)throws Exception{
		ResponseResult<Integer> result=new ResponseResult<>();
		try{
			Integer rank=0;

			YcyscoreVO ycyscoreVO= ycyscoreService.querySpeedRank(vo);
			if(ycyscoreVO!=null){
				rank=ycyscoreVO.getRank();
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
