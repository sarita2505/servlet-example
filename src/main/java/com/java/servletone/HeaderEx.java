package com.java.servletone;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/header")
public class HeaderEx extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> stringEnumeration = req.getHeaderNames();
        while (stringEnumeration.hasMoreElements()) {
            String paramName = stringEnumeration.nextElement();
            System.out.println("paramName :" + paramName);
            String paramValue = req.getHeader(paramName);
            System.out.println("param value: " + paramValue);
            resp.getWriter().write("show logs in git bash");
        }
    }
}
