package com.java.servletone;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebServlet(urlPatterns = "/hello")
public class Hello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("test/html");
        resp.getWriter().write("hello"+"<br/>");
        Object o=req.getAttribute("helloworld");
        System.out.println(o);
        resp.getWriter().write(o.toString());
        resp.getWriter().write("<br/>headers send by client");


    }
}
