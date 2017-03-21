package com.dongnao.alan.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SaveSessionServlet
 */
public class SaveSessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveSessionServlet() {
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
        // TODO Auto-generated method stub
        
        HttpSession session = request.getSession();
        
        session.setAttribute("userName", request.getParameter("userName"));
        session.setAttribute("age", request.getParameter("age"));
        //        HttpSession session = request.getSession();
        //        session.setAttribute("userName", request.getParameter("userName"));
        //        session.setAttribute("age", request.getParameter("age"));
        
        System.out.println("userName : " + request.getParameter("userName"));
        System.out.println("age : " + request.getParameter("age"));
        System.out.println("session±£´æ£¡");
        System.out.println(InetAddress.getLocalHost().getHostAddress() + ":"
                + InetAddress.getLocalHost().getHostName());
        //        
        //        String key = Math.random() + "--" + "userInfo";
        //        
        //        RedisApi.set(key, "userName : " + request.getParameter("userName")
        //                + "==" + "age : " + request.getParameter("age"));
        //        
        //        Cookie cookie = new Cookie("sessionId", key);
        //        cookie.setPath("/");
        //        response.addCookie(cookie);
        //        
        PrintWriter pw = response.getWriter();
        pw.println(InetAddress.getLocalHost().getHostAddress() + ":"
                + InetAddress.getLocalHost().getHostName());
        
    }
    
}
