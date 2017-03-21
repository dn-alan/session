package com.dongnao.alan.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetSessionServlet
 */
public class GetSessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private Cookie[] cookies;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        request.getSession();
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        
        System.out.println("userName : " + session.getAttribute("userName"));
        System.out.println("age : " + session.getAttribute("age"));
        System.out.println("session 获取成功！");
        
        //        Cookie[] cookies = request.getCookies();
        //        
        //        String value = null;
        //        
        //        if (cookies != null && cookies.length > 0) {
        //            for (Cookie cookie : cookies) {
        //                if ("sessionId".equals(cookie.getName())) {
        //                    value = cookie.getValue();
        //                }
        //            }
        //        }
        //        
        //        String sessionStr = RedisApi.get(value);
        //        
        //        System.out.println(sessionStr);
        //        
        PrintWriter pw = response.getWriter();
        pw.println("userName : " + session.getAttribute("userName"));
        pw.println("age : " + session.getAttribute("age"));
        pw.println(InetAddress.getLocalHost().getHostAddress() + ":"
                + InetAddress.getLocalHost().getHostName());
        //        pw.println(sessionStr);
    }
    
}
