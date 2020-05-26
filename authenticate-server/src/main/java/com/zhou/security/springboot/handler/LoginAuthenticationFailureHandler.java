package com.zhou.security.springboot.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        Map<String, Object> map = new HashMap<>(4);
        Map<String, Object> data = new HashMap<>(4);
        map.put("data", data);

        map.put("code", 1);
        map.put("msg", "登录失败");

        String accessControlAllowOrigin = request.getHeader("Access-Control-Allow-Origin");

        response.addHeader("Access-Control-Allow-Origin", accessControlAllowOrigin);
        response.addHeader("Access-Control-Allow-Credentials", "true");

        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().println(JSON.toJSON(map));
        response.setStatus(HttpServletResponse.SC_OK);

        response.flushBuffer();
    }
}
