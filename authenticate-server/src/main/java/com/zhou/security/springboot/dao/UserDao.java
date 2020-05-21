package com.zhou.security.springboot.dao;


import com.zhou.security.springboot.model.PermissionDto;
import com.zhou.security.springboot.model.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 **/
@Repository
@Mapper
public interface UserDao {
    UserDto getUserByUsername(@Param("username") String username);

    List<PermissionDto> findPermissionsByUserId(@Param("userId") String userId);
}
