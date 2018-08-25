package com.guigu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.pojo.ChildCategory;
import com.guigu.pojo.MainCategory;
import com.guigu.service.CategorySevice;
import com.guigu.util.JsonUtil;

@Controller
@RequestMapping("/CategoryController")
public class CategoryController {
	private static final  Logger LOGGER = Logger.getLogger(CategoryController.class);
	@Resource
	private  CategorySevice   categoryService;
	
	@RequestMapping("/hotSearch.action")
	@ResponseBody
	public List<ChildCategory> hotSearch() throws Exception{
		List<ChildCategory>  list = null;
		try {
			list = categoryService.getHostCategory();
			LOGGER.info("CategoryController->hotSearch,return result:"+JsonUtil.toJson(list));//记录出参
			return list;
		}catch (Exception e) {
			LOGGER.error("UserController->hotSearch,exception:"+e.getMessage());
			throw e;
		}
	}
	
	
	@RequestMapping("/allCategory.action")
	@ResponseBody
	public List<MainCategory> allCategory() throws Exception{
		List<MainCategory>  list = null;
		try {
			list = categoryService.getAllCategory();
			LOGGER.info("CategoryController->allCategory,return result:"+JsonUtil.toJson(list));//记录出参
			return list;
		}catch (Exception e) {
			LOGGER.error("UserController->allCategory,exception:"+e.getMessage());
			throw e;
		}
	}
	

}
