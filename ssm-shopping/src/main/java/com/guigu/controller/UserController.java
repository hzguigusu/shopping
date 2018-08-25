package com.guigu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.pojo.User;
import com.guigu.service.UserService;
import com.guigu.util.JsonUtil;
@Controller
@RequestMapping("/UserController")
public class UserController {
	private static final  Logger LOGGER = Logger.getLogger(UserController.class);
	@Resource
	private UserService userService ;
	
	@RequestMapping(value="/logIn.action",method=RequestMethod.POST)
	@ResponseBody
	public User logIn(User user,HttpServletRequest request) throws Exception {
		LOGGER.info("UserController->logIn,param:"+JsonUtil.toJson(user));//记录入参
		User  myUser = null;
		try {
			myUser = userService.logIn(user);
			request.getSession().setAttribute("user", myUser);
			LOGGER.info("UserController->logIn,return result:"+JsonUtil.toJson(myUser));//记录出参
			return myUser;
		}catch (Exception e) {
			LOGGER.error("UserController->logIn,exception:"+e.getMessage());
			throw e;
		}
	}

}
