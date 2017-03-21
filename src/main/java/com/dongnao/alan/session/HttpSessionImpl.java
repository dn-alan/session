package com.dongnao.alan.session;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import redis.RedisApi;

public class HttpSessionImpl implements HttpSession {
    
    private HttpServletRequest request;
    
    private HttpServletResponse response;
    
    ThreadLocal<String> local = new ThreadLocal<String>();
    
    ThreadLocal<Map<String, Object>> maplocal = new ThreadLocal<Map<String, Object>>();
    
    public HttpSessionImpl(HttpServletRequest request,
            HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
    
    @Override
    public long getCreationTime() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public long getLastAccessedTime() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public ServletContext getServletContext() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void setMaxInactiveInterval(int paramInt) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public int getMaxInactiveInterval() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public HttpSessionContext getSessionContext() {
        // TODO Auto-generated method stub
        return null;
    }
    
    /* 
     * @see 从缓存中拿session信息
     */
    @Override
    public Object getAttribute(String paramString) {
        
        String sessionId = getSessionIdFromCookie();
        
        List<String> lists = RedisApi.hmget(sessionId, paramString);
        
        return lists.get(0);
    }
    
    private String getSessionIdFromCookie() {
        
        Cookie[] cookies = request.getCookies();
        
        if (cookies != null && cookies.length > 0) {
            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    if ("sessionId".equals(cookie.getName())) {
                        return cookie.getValue();
                    }
                }
            }
        }
        
        return null;
    }
    
    @Override
    public Object getValue(String paramString) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Enumeration<String> getAttributeNames() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String[] getValueNames() {
        // TODO Auto-generated method stub
        return null;
    }
    
    /* 
     * @see 操作我们的缓存，把信息存到缓存里面去
     */
    @Override
    public void setAttribute(String paramString, Object paramObject) {
        
        String sessionId = getSessionIdFromCookie();
        
        if (sessionId == null) {
            if (local.get() != null) {
                sessionId = local.get();
            } else {
                sessionId = ThreadLocalRandom.current().nextInt() + "--" + "userInfo";
                local.set(sessionId);
            }
        }
        
        if (maplocal.get() != null) {
            maplocal.get().put(paramString, paramObject);
        }
        else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(paramString, paramObject);
            maplocal.set(map);
        }
        
        RedisApi.del(sessionId);
        RedisApi.hmset(sessionId, maplocal.get());
        setCookie(sessionId);
    }
    
    private void setCookie(String sessionId) {
        Cookie cookie = new Cookie("sessionId", sessionId);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    
    @Override
    public void putValue(String paramString, Object paramObject) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void removeAttribute(String paramString) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void removeValue(String paramString) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void invalidate() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public boolean isNew() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
