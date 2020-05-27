package com.zhou.security.springboot.handler;

import com.alibaba.fastjson.JSON;
import com.zhou.security.springboot.utils.resultUtil.ResultEnum;
import com.zhou.security.springboot.utils.resultUtil.ReturnResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        ReturnResult returnResult = new ReturnResult(ResultEnum.LOGIN_SUCCESS);
        String accessControlAllowOrigin = request.getHeader("Access-Control-Allow-Origin");

        response.addHeader("Access-Control-Allow-Origin", accessControlAllowOrigin);
        response.addHeader("Access-Control-Allow-Credentials", "true");

        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().println(JSON.toJSON(returnResult));
        response.setStatus(HttpServletResponse.SC_OK);

        response.flushBuffer();
    }


}
