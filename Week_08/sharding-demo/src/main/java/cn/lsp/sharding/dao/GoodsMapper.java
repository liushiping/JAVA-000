package cn.lsp.sharding.dao;

import org.springframework.stereotype.Repository;

import cn.lsp.sharding.entity.Goods;
@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}