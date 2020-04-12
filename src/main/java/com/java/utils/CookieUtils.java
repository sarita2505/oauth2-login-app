package com.java.utils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class CookieUtils {
    private static final String COOKIE_NAME = "auth_cookie";

    public static Boolean isCookiePresent(ServletRequest request) {
        Boolean flag = false;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies==null)
        {
            return flag;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(COOKIE_NAME) && cookie.getValue() != null) {
                flag = true;
            }
        }
        return flag;
    }

    public static void setCookieAndRedirect(ServletResponse servletResponse) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        Cookie cookie = new Cookie(COOKIE_NAME, UUID.randomUUID().toString());
        httpServletResponse.addCookie(cookie);
        try {
            httpServletResponse.sendRedirect("http://localhost:8081/oauth2-login-app/hello");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
