package cn.lsp.sharding.dao;

import org.springframework.stereotype.Repository;

import cn.lsp.sharding.entity.TOrder;
@Repository
public interface TOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);
}