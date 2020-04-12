package com.java.filter;


import com.java.oauth.OAuth2Provider;
import com.java.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/login")
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void destroy() {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        OAuth2Provider.requestAccessToken(servletRequest);
        CookieUtils.setCookieAndRedirect(servletResponse);
    }
}

