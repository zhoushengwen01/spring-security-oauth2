package com.zhou.security.springboot.controller;


import com.zhou.security.springboot.model.Role;
import com.zhou.security.springboot.service.RoleService;
import com.zhou.security.springboot.utils.resultUtil.ResultEnum;
import com.zhou.security.springboot.utils.resultUtil.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @GetMapping("/pageQuery")
    ReturnResult pageQuery(int currentPage, int pageSize, String role) {
        List<Role> roles = roleService.pageQuery(currentPage, pageSize, role);
        Long total = roleService.queryTotal(role);
        return new ReturnResult(total, roles, ResultEnum.SUCCESS);
    }


    @DeleteMapping("/deleteById/{id}")
    ReturnResult deleteById(@PathVariable Integer id) {
        int i = roleService.deleteById(id);
        if (i == 1) {
            return ReturnResult.success();
        } else {
            return ReturnResult.fail();
        }


    }

    @PostMapping("/insert")
    ReturnResult insert(@RequestBody Role role) {
        int insert = roleService.insert(role);
        if (insert == 1) {
            return ReturnResult.success();
        } else {
            return ReturnResult.fail();
        }
    }

    @GetMapping("/selectById/{id}")
    Role selectById(@PathVariable Integer id) {
        return roleService.selectById(id);
    }

    @PutMapping("/update")
    ReturnResult update(@RequestBody Role record) {
        int update = roleService.update(record);
        if (update == 1) {
            return ReturnResult.success();
        } else {
            return ReturnResult.fail();
        }
    }


}
