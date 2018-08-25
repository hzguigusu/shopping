package com.guigu.mapper;

import com.guigu.pojo.OrderProduct;
import com.guigu.pojo.OrderProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderProductMapper {
    int countByExample(OrderProductExample example);

    int deleteByExample(OrderProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderProduct record);

    int insertSelective(OrderProduct record);

    List<OrderProduct> selectByExample(OrderProductExample example);

    OrderProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderProduct record, @Param("example") OrderProductExample example);

    int updateByExample(@Param("record") OrderProduct record, @Param("example") OrderProductExample example);

    int updateByPrimaryKeySelective(OrderProduct record);

    int updateByPrimaryKey(OrderProduct record);
}