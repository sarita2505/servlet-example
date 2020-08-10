package com.java.urlrewritting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/servlet1url")
public class servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInfo = req.getParameter("userInfo");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
       // writer.write(userInfo);
        writer.print("userinf0 is: "+userInfo);
        writer.print("<a href='servlet2url'>visit</a>");
    }
}
