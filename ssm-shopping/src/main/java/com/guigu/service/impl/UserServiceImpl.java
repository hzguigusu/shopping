package com.guigu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.guigu.mapper.UserMapper;
import com.guigu.pojo.User;
import com.guigu.pojo.UserExample;
import com.guigu.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final  Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	
	//注入
	@Resource
	private UserMapper userMapper;
	
	
	@Override
	public User logIn(User user) throws Exception {
		try {
			UserExample example = new UserExample();
			example.createCriteria().andLogNameEqualTo(user.getLogName()).andPassEqualTo(user.getPass());
			List<User> list = userMapper.selectByExample(example);
			return list.size() > 0?list.get(0):null;
		}catch (Exception e) {
			LOGGER.error("UserServiceImpl->logIn,exception:"+e.getMessage());
			throw e;
		}
	}
	
	

}
