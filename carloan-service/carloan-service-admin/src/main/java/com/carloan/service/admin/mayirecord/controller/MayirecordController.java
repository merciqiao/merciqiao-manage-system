package com.carloan.service.admin.mayirecord.controller;

import com.carloan.service.admin.mayirecord.service.MayirecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-08 18:37:38
 */
@RestController
@RequestMapping("/mayirecord/mayirecord")
public class MayirecordController {
	@Autowired
	private MayirecordService mayirecordService;
	

	
}
