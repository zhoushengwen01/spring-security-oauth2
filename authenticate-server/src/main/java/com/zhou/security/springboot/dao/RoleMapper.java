package com.zhou.security.springboot.dao;

import com.zhou.security.springboot.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
* Created by Mybatis Generator 2019/12/09
*/

@Repository
@Mapper
public interface RoleMapper {
    List<Role> pageQuery(int start, int pageSize);

    long queryTotal();

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}