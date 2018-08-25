package com.guigu.mapper;

import com.guigu.pojo.ChildCategory;
import com.guigu.pojo.ChildCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChildCategoryMapper {
    int countByExample(ChildCategoryExample example);

    int deleteByExample(ChildCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChildCategory record);

    int insertSelective(ChildCategory record);

    List<ChildCategory> selectByExample(ChildCategoryExample example);

    ChildCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChildCategory record, @Param("example") ChildCategoryExample example);

    int updateByExample(@Param("record") ChildCategory record, @Param("example") ChildCategoryExample example);

    int updateByPrimaryKeySelective(ChildCategory record);

    int updateByPrimaryKey(ChildCategory record);
}