package com.guigu.mapper;

import com.guigu.pojo.HotSearch;
import com.guigu.pojo.HotSearchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotSearchMapper {
    int countByExample(HotSearchExample example);

    int deleteByExample(HotSearchExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HotSearch record);

    int insertSelective(HotSearch record);

    List<HotSearch> selectByExample(HotSearchExample example);

    HotSearch selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HotSearch record, @Param("example") HotSearchExample example);

    int updateByExample(@Param("record") HotSearch record, @Param("example") HotSearchExample example);

    int updateByPrimaryKeySelective(HotSearch record);

    int updateByPrimaryKey(HotSearch record);
}