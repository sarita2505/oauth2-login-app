package com.java.oauth;

import com.java.utils.HttpUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OAuth2Provider {


    public static void requestCode(ServletResponse response){

        String url=Oauth2GitConfig.REQUEST_CODE_URL;
        String stateValue= UUID.randomUUID().toString();
        url=String.format(url,stateValue);
        System.out.println("calling "+url);
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;
        try {
            httpServletResponse.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    public static int requestAccessToken(ServletRequest request){
        HttpServletRequest httpServletRequest=(HttpServletRequest) request;
        String state=httpServletRequest.getParameter("state");
        String code=httpServletRequest.getParameter("code");

        Map<String,String> postDataMap = new HashMap<>();
        postDataMap.put("client_id", Oauth2GitConfig.CLIENT_ID);
        postDataMap.put("client_secret", Oauth2GitConfig.CLIENT_SECRET);
        postDataMap.put("code",code);
        postDataMap.put("redirect_uri",Oauth2GitConfig.CALLBACK_URL);
        postDataMap.put("state",state);
        try {
           HttpUtils.sendPost(Oauth2GitConfig.ACCESS_TOKEN_URL,postDataMap);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return 0;
    }
}
