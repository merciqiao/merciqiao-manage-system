package com.carloan.service.admin.ycyscore.controller;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.common.utils.DateUtil;
import com.carloan.service.admin.ycyscore.entity.YcyscoreEntity;
import com.carloan.service.admin.ycyscore.entity.YcyscoretotalEntity;
import com.carloan.service.admin.ycyscore.service.YcyscoreService;
import com.carloan.service.admin.ycyscore.vo.YcyscoreVO;
import com.carloan.service.admin.ycyscore.vo.YcyscoretotalVO;
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
			//保存总分 start
			YcyscoretotalVO ycyscoretotalVO= ycyscoreService.queryObjectTotal(vo.getIp());
			YcyscoretotalEntity ycyscoretotalEntity=new YcyscoretotalEntity();
			ycyscoretotalEntity.setIp(vo.getIp());
			ycyscoretotalEntity.setScore(vo.getScore());
			ycyscoretotalEntity.setCity(vo.getCity());
			if(ycyscoretotalVO==null){
				ycyscoreService.saveTotal(ycyscoretotalEntity);
			}
			else{
				int score= ycyscoretotalVO.getScore()+vo.getScore();
				ycyscoretotalEntity.setScore(score);
				ycyscoreService.updateTotal(ycyscoretotalEntity);
			}
			//保存总分 end


			YcyscoreVO mayiVO= ycyscoreService.queryObject(vo.getIp());
			if(mayiVO!=null){

				String nowTime= DateUtil.GetDateDay(new Date());
				String todayTime= DateUtil.GetDateDay(mayiVO.getUpdatetime());
				if(nowTime.equals(todayTime)){
					//今天
					//就是今天的数据,且时间更短
                    if(vo.getMintime()!=null&&mayiVO.getMintime()!=null){
                            if(vo.getMintime()>=mayiVO.getMintime()){
                                vo.setMintime(null);
                            }
                    }
                    if(vo.getScore()> mayiVO.getTodayscore()){
						vo.setTodayscore(vo.getScore());
					}
				}
				else{
					//新的一天
					//没更新为今天,则更新为今天,同时更新用时
					if(vo.getMintime()==null){
						vo.setMintime(0);
					}
					vo.setTodaytime(new Date());
					vo.setTodayscore(vo.getScore());
				}
				//如果分数比历史分低,则不更新最高分
				if(vo.getScore()<mayiVO.getScore()){
					vo.setScore(null);
				}
				vo.setTimes(mayiVO.getTimes()+1);
				ycyscoreService.update(vo);
			}
			else{
				vo.setTodayscore(vo.getScore());
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
	 * 查询前30名总排名
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryListTotal",method = RequestMethod.POST)
	public ResponseResult<YcyscoretotalVO> queryListTotal(@RequestBody YcyscoretotalEntity vo)throws Exception{
		ResponseResult<YcyscoretotalVO> result=new ResponseResult<>();
		try{
			result= (ResponseResult<YcyscoretotalVO>)ycyscoreService.queryListTotal(vo);
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

	/**
	 * 查询今日排名
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryToday",method = RequestMethod.POST)
	public ResponseResult<YcyscoreVO> queryToday(@RequestBody YcyscoreEntity vo)throws Exception{
		ResponseResult<YcyscoreVO> result=new ResponseResult<>();
		try{
			result= (ResponseResult<YcyscoreVO>)ycyscoreService.queryToday(vo);
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
	 * 查询总分个人分数
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryScoreTotal",method = RequestMethod.POST)
	public ResponseResult<Integer> queryScoreTotal(@RequestBody YcyscoretotalEntity vo)throws Exception{
		ResponseResult<Integer> result=new ResponseResult<>();
		try{
			YcyscoretotalVO ycyscoreVO= ycyscoreService.queryObjectTotal(vo.getIp());
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
			YcyscoreVO ycyscoreVO= ycyscoreService.queryObjectToday(vo.getIp());
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
	@RequestMapping(value = "/queryTodayScore",method = RequestMethod.POST)
	public ResponseResult<Integer> queryTodayScore(@RequestBody YcyscoreEntity vo)throws Exception{
		ResponseResult<Integer> result=new ResponseResult<>();
		try{
			YcyscoreVO ycyscoreVO= ycyscoreService.queryObjectToday(vo.getIp());
			int score;
			if(ycyscoreVO==null){
				score=0;
			}
			else{
				score=ycyscoreVO.getTodayscore()==null?0:ycyscoreVO.getTodayscore();
			}
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
	 * 查询个人总分排名
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryRankTotal",method = RequestMethod.POST)
	public ResponseResult<Integer> queryRankTotal(@RequestBody YcyscoretotalEntity vo)throws Exception{
		ResponseResult<Integer> result=new ResponseResult<>();
		try{
			Integer rank=0;
			YcyscoretotalVO mayiVO= ycyscoreService.queryObjectTotal(vo.getIp());
			if(mayiVO==null){
				rank=ycyscoreService.queryTotalTotal();
			}
			else{
				rank= ycyscoreService.queryRankTotal(vo);
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
	 * 查询当日个人排名
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryRankToday",method = RequestMethod.POST)
	public ResponseResult<Integer> queryRankToday(@RequestBody YcyscoreEntity vo)throws Exception{
		ResponseResult<Integer> result=new ResponseResult<>();
		try{
			Integer rank=0;

			YcyscoreVO ycyscoreVO= ycyscoreService.queryRankToday(vo);
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
