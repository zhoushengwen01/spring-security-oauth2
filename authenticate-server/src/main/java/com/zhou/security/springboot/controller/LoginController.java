package com.zhou.security.springboot.controller;

import com.zhou.security.springboot.utils.resultUtil.ReturnResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 * @version 1.0
 **/
@Controller
public class LoginController {

    @RequestMapping("/success")
    @ResponseBody
    public ReturnResult loginSuccess() {
        String username = getUsername();
        return ReturnResult.success();
    }


    @RequestMapping("/test")
    public String test() {
        return "test";
    }


    @RequestMapping("/oauthTest")
    @ResponseBody
    public String oauthTest(String code) {
        //提示具体用户名称登录成功
        return "授权码：" + code;
    }

    /**
     * 测试资源1
     *
     * @return
     */
    @GetMapping(value = "/r/r1", produces = {"text/plain;charset=UTF-8"})
    @PreAuthorize("hasAuthority('p1')")//拥有p1权限才可以访问
    @ResponseBody
    public String r1() {
        return getUsername() + " 访问资源1";
    }

    /**
     * 测试资源2
     *
     * @return
     */
    @GetMapping(value = "/r/r2", produces = {"text/plain;charset=UTF-8"})
    @PreAuthorize("hasAuthority('p2')")//拥有p2权限才可以访问
    @ResponseBody
    public String r2() {
        return getUsername() + " 访问资源2";
    }

    //获取当前用户信息
    private String getUsername() {
        String username = null;
        //当前认证通过的用户身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //用户身份
        Object principal = authentication.getPrincipal();
        if (principal == null) {
            username = "匿名";
        }
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
}
