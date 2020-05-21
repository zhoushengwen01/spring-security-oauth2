package com.zhou.security.springboot.service;


import com.zhou.security.springboot.dao.UserDao;
import com.zhou.security.springboot.model.PermissionDto;
import com.zhou.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDto userDto = userDao.getUserByUsername(username);
        if (userDto == null) {
            return null;
        }
        List<PermissionDto> permissionDtos = userDao.findPermissionsByUserId(userDto.getId());
        List<String> permissions = new ArrayList<>();
        permissionDtos.forEach(c -> permissions.add(c.getCode()));
        //将permissions转成数组
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        UserDetails userDetails = User.withUsername(userDto.getUsername()).password(userDto.getPassword()).authorities(permissionArray).build();
        return userDetails;
    }
}
