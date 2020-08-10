package com.java.login.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.login.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/validuser")
public class ValidateUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ObjectMapper objectMapper=new ObjectMapper();
//        User user=objectMapper.readValue(req.getReader(),User.class);
//        String username=user.getUsername();
//        String password=user.getPassword();
      String username=  (String) req.getAttribute("username");
      String password=  (String) req.getAttribute("password");

        if (username!=null && password!=null){
            if (username.equals("scott")&&password.equals("tiger")){
                Cookie cookie=new Cookie("logincookie","login");
                resp.addCookie(cookie);
            }
        }
        resp.getWriter().write("<br/>you are a valid user");
    }
}
