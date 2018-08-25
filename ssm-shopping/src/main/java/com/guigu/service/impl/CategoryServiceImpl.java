package com.guigu.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.guigu.mapper.ChildCategoryMapper;
import com.guigu.mapper.HotSearchMapper;
import com.guigu.mapper.MainCategoryMapper;
import com.guigu.pojo.ChildCategory;
import com.guigu.pojo.ChildCategoryExample;
import com.guigu.pojo.HotSearch;
import com.guigu.pojo.HotSearchExample;
import com.guigu.pojo.MainCategory;
import com.guigu.pojo.MainCategoryExample;
import com.guigu.service.CategorySevice;
@Service
public class CategoryServiceImpl implements CategorySevice {

	@Resource
	private HotSearchMapper hotSearchMapper;
	@Resource
	private ChildCategoryMapper childCategoryMapper;
	@Resource
	private MainCategoryMapper  mainCattgoryMapper;
	private static final  Logger LOGGER = Logger.getLogger(CategoryServiceImpl.class);

	@Override
	public List<ChildCategory> getHostCategory() throws Exception {
		
		try {
			//获得所有的热门类别的id
			HotSearchExample hotExample = new HotSearchExample();
			hotExample.createCriteria().andDelEqualTo(0);
			List<HotSearch>  hotList = hotSearchMapper.selectByExample(hotExample);
			if(CollectionUtils.isEmpty(hotList)) {
				return null;
			}
			ChildCategoryExample childExample = new ChildCategoryExample();
			childExample.createCriteria().andIdIn(hotList.stream().map(HotSearch::getChildId).collect(Collectors.toList()));
			return childCategoryMapper.selectByExample(childExample);
		}catch (Exception e) {
			LOGGER.error("CategoryServiceImpl->getHostCategory,exception:"+e.getMessage());
			throw e;
		}
		
		
		
	}

	@Override
	public List<MainCategory> getAllCategory() throws Exception {
		 List<MainCategory> mainList = null;
		try {
			MainCategoryExample  mainExample = new MainCategoryExample();
			mainExample.createCriteria().andDelEqualTo(0);
			mainList = mainCattgoryMapper.selectByExample(mainExample);
			if(!CollectionUtils.isEmpty(mainList)) {
				mainList.forEach((m)->{
					ChildCategoryExample chilExample = new ChildCategoryExample();
					chilExample.createCriteria().andMainIdEqualTo(m.getId());
					m.setChildList(childCategoryMapper.selectByExample(chilExample));
				});
			}
			return mainList;
			
		} catch (Exception e) {
			LOGGER.error("CategoryServiceImpl->getAllCategory,exception:"+e.getMessage());
			throw e;
		}
	}

}
