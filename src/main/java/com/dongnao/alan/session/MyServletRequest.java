package com.dongnao.alan.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServletRequest extends HttpServletRequestWrapper {
    
    private HttpServletRequest request;
    
    private HttpServletResponse response;
    
    public MyServletRequest(HttpServletRequest request,
            HttpServletResponse response) {
        super(request);
        this.request = request;
        this.response = response;
    }
    
    @Override
    public HttpSession getSession() {
        return new HttpSessionImpl(request, response);
    }
    
}
