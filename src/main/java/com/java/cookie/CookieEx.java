package com.java.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cookie1")
public class CookieEx extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("myCookie", "testcookie");
        cookie.setComment("1st cookie");
        cookie.setVersion(90);
        cookie.setDomain("servletone-example");
        cookie.setPath("set path here");
        resp.getWriter().write("<br/>cookie name: "+cookie.getName());
        resp.getWriter().write("<br/>cookie value: "+cookie.getValue() );
        resp.getWriter().write("<br/>cookie name: "+cookie.getComment());
        resp.getWriter().write("<br/>cookie domain: "+cookie.getDomain() );
        resp.getWriter().write("<br/>cookie path: "+cookie.getPath() );
        resp.getWriter().write("<br/>cookie version: "+cookie.getVersion() );
        resp.addCookie(cookie);
        resp.getWriter().write("<br/>cookie added");
    }
}
