package com.java.login.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.login.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//you can not read the same request for twice..so you can not use the objectmapper again here to read the json
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        User user=objectMapper.readValue(req.getReader(), User.class);
//        String userNameparam = req.getParameter("username");
//        String passwordparam = req.getParameter("password");
        String userName=user.getUsername();
        String password=user.getPassword();
        resp.getWriter().write("user name is :" + userName);
        resp.getWriter().write("<br/>password is :" + password);
//        resp.getWriter().write("<br/>usernameparam is :" + userNameparam);
//        resp.getWriter().write("<br/>passwordparam is :" + passwordparam);
        req.setAttribute("username",userName);
        req.setAttribute("password",password);
        RequestDispatcher dispatcher=req.getRequestDispatcher("/validuser");
        dispatcher.include(req,resp);
        Cookie[] cookies=req.getCookies();
        if(cookies!=null){
            resp.getWriter().write("cookie name: "+cookies[0].toString());
        }
    }
}
