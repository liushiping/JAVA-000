package cn.lsp.sharding.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.lsp.sharding.entity.Account;

@Mapper
public interface AccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}