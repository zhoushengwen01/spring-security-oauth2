package com.zhou.security.springboot.service.impl;


import com.zhou.security.springboot.dao.RoleMapper;
import com.zhou.security.springboot.model.Role;
import com.zhou.security.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> pageQuery(int currentPage, int pageSize) {
        int start = 0;
        if (currentPage > 0) {
            start = (currentPage - 1) * pageSize;
        }
        return roleMapper.pageQuery(start, pageSize);
    }

    @Override
    public Long queryTotal() {
        return roleMapper.queryTotal();
    }

    @Override
    public int deleteById(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public Role selectById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

}
