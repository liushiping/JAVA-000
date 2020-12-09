package cn.lsp.sharding.dao;

import org.springframework.stereotype.Repository;

import cn.lsp.sharding.entity.TestOrder;

@Repository
public interface TestOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(TestOrder record);

    int insertSelective(TestOrder record);

    TestOrder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(TestOrder record);

    int updateByPrimaryKey(TestOrder record);
}