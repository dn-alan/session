package com.dongnao.alan.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionFilter implements Filter {
    
    @Override
    public void init(FilterConfig paramFilterConfig) throws ServletException {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void doFilter(ServletRequest paramServletRequest,
            ServletResponse paramServletResponse, FilterChain paramFilterChain)
            throws IOException, ServletException {
        
        paramFilterChain.doFilter(new MyServletRequest(
                (HttpServletRequest)paramServletRequest,
                (HttpServletResponse)paramServletResponse),
                paramServletResponse);
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }
    
}
