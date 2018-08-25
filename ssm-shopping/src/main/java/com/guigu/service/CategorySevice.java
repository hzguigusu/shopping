package com.guigu.service;

import java.util.List;

import com.guigu.pojo.ChildCategory;
import com.guigu.pojo.MainCategory;

public interface CategorySevice {

	List<ChildCategory> getHostCategory() throws Exception;

	List<MainCategory> getAllCategory() throws Exception;

}
