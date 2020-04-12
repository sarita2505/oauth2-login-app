package com.java.filter;

import com.java.oauth.OAuth2Provider;
import com.java.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(urlPatterns = "/*")
public class OAuth2Filter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("==========init");

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (CookieUtils.isCookiePresent(servletRequest)) {
            System.out.println("cookie found");
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            OAuth2Provider.requestCode(servletResponse);
        }
    }

    public void destroy() {
        System.out.println("destroied");
    }
}
