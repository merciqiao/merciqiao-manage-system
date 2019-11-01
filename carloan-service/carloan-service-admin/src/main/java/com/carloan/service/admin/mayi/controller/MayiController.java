package com.carloan.service.admin.mayi.controller;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.service.admin.mayi.entity.MayiEntity;
import com.carloan.service.admin.mayi.service.MayiService;
import com.carloan.service.admin.mayi.vo.MayiVO;
import com.carloan.service.admin.mayi.vo.ZanzhuVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-08 18:35:17
 */
@RestController
@Slf4j
@RequestMapping(value="/mayi-api")
public class MayiController {
	@Autowired
	private MayiService mayiService;
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Response add(@RequestBody MayiEntity vo)throws Exception{
		Response result=new Response();
		try{
			MayiVO mayiVO= mayiService.queryObject(vo.getIp());
			if(mayiVO!=null){
				vo.setWeight(mayiVO.getWeight()+1);//每添加一次,权重加一,排名靠前
				vo.setUpdatecount(mayiVO.getUpdatecount()+1);
				vo.setId(mayiVO.getId());
				mayiService.update(vo);
			}
			else{
				mayiService.save(vo);
			}
			return result;
		}catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}
	}
	@RequestMapping(value = "/queryList",method = RequestMethod.POST)
	public ResponseResult<MayiVO> queryList(@RequestBody MayiEntity vo)throws Exception{
		ResponseResult<MayiVO> result=new ResponseResult<>();
		try{
			result= (ResponseResult<MayiVO>)mayiService.queryList(vo);

			return result;
		}catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}
	}
	@RequestMapping(value = "/queryZanZhu",method = RequestMethod.POST)
	public ResponseResult<ZanzhuVo> queryZanZhu()throws Exception{
		ResponseResult<ZanzhuVo> result=new ResponseResult<>();
		try{
			List<ZanzhuVo> list= mayiService.queryZanZhu();
			result.setDataList(list);
			return result;
		}catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}
	}
}
