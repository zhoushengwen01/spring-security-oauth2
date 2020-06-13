package com.zhou.security.springboot.handler;

import com.alibaba.fastjson.JSON;
import com.zhou.security.springboot.utils.resultUtil.ResultEnum;
import com.zhou.security.springboot.utils.resultUtil.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        ReturnResult returnResult = new ReturnResult(ResultEnum.LOGIN_SUCCESS);


        Object principal = authentication.getPrincipal();

        UserDetails userDetails = (UserDetails) principal;
        String username = userDetails.getUsername();

        Set<String> roles = new HashSet<>();
        userDetails.getAuthorities().stream().forEach(c -> roles.add(c.getAuthority()));

        HashMap<String, Object> userInfo = new HashMap<>();
        userInfo.put("userName", username);
        userInfo.put("authorities", roles);

        UUID userInfoId = UUID.randomUUID();




        returnResult.setData(userInfo);


//        String clientId = "c1";
//        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
//        TokenRequest tokenRequest = new TokenRequest(new HashMap<>(), clientId, clientDetails.getScope(), "all");
//        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
//        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
//        OAuth2AccessToken accessToken1 = tokenService.getAccessToken(oAuth2Authentication);

        String accessControlAllowOrigin = request.getHeader("Access-Control-Allow-Origin");
        response.addHeader("Access-Control-Allow-Origin", accessControlAllowOrigin);
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.setContentType("text/json;charset=UTF-8");

        response.getWriter().println(JSON.toJSON(returnResult));
        response.setStatus(HttpServletResponse.SC_OK);

        response.flushBuffer();
    }


}
