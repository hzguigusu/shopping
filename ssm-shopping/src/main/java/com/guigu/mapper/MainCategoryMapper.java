package com.guigu.mapper;

import com.guigu.pojo.MainCategory;
import com.guigu.pojo.MainCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MainCategoryMapper {
    int countByExample(MainCategoryExample example);

    int deleteByExample(MainCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MainCategory record);

    int insertSelective(MainCategory record);

    List<MainCategory> selectByExample(MainCategoryExample example);

    MainCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MainCategory record, @Param("example") MainCategoryExample example);

    int updateByExample(@Param("record") MainCategory record, @Param("example") MainCategoryExample example);

    int updateByPrimaryKeySelective(MainCategory record);

    int updateByPrimaryKey(MainCategory record);
}