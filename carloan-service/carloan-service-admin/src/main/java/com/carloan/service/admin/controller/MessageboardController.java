//package com.carloan.service.admin.controller;
//
//import com.carloan.service.admin.messageboard.entity.MessageboardEntity;
//import com.carloan.service.admin.messageboard.entity.MessageboardListEntity;
//import com.carloan.service.admin.messageboard.groups.MessageboardAddGroup;
//import com.carloan.service.admin.messageboard.groups.MessageboardUpdateGroup;
//import com.carloan.service.admin.messageboard.service.MessageboardService;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
///**
// *
// *
// * @author qlx
// * @email qiaolixue@yingu.com
// * @date 2018-11-04 16:20:40
// */
//@RestController
//@RequestMapping("/messageboard/messageboard")
//public class MessageboardController {
//	@Autowired
//	private MessageboardService messageboardService;
//
//	/**
//	 * 列表
//	 */
//	@RequestMapping("/list")
//	@RequiresPermissions("messageboard:messageboard:list")
//	public Result list(MessageboardListEntity messageboard){
//		return messageboardService.queryList(messageboard);
//	}
//
//
//	/**
//	 * 信息
//	 */
//	@RequestMapping("/info")
//	@RequiresPermissions("messageboard:messageboard:info")
//	public Result info(Integer id){
//		return messageboardService.queryObject(id);
//	}
//
//	/**
//	 * 保存
//	 */
//	@RequestMapping("/save")
//	@RequiresPermissions("messageboard:messageboard:save")
//	public Result save(@Validated({MessageboardAddGroup.class}) MessageboardEntity messageboard,BindingResult bindingResult){
//		return messageboardService.save(messageboard);
//	}
//
//	/**
//	 * 修改
//	 */
//	@RequestMapping("/update")
//	public Result update(@Validated({MessageboardUpdateGroup.class}) MessageboardEntity messageboard,BindingResult bindingResult){
//		return messageboardService.update(messageboard);
//	}
//
//	/**
//	 * 删除
//	 */
//	@RequestMapping("/delete")
//	public Result delete(Integer[] ids){
//		return messageboardService.deleteBatch(ids);
//	}
//
//}
