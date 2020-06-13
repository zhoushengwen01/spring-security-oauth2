package com.zhou.security.springboot.service;


import com.zhou.security.springboot.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> pageQuery(int currentPage, int pageSize, String role);

    Long queryTotal(String role);

    int deleteById(Integer id);

    int insert(Role record);

    Role selectById(Integer id);

    int update(Role record);

}
