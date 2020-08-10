package com.java.login.requestwrapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.mapper.MapperClass;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/servlet1")
public class servlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestWrapper requestWrapper=new RequestWrapper(req);

        //Data data=MapperClass.getObjectFromJson( req,Data.class);
        ObjectMapper objectMapper=new ObjectMapper();
        //Data data=objectMapper.readValue(req.getReader(),Data.class);
        Data data=objectMapper.readValue(requestWrapper.getReader(),Data.class);

        String s1=data.getData();
        resp.getWriter().write(s1);
        RequestDispatcher dispatcher=req.getRequestDispatcher("/servlet2");
        dispatcher.forward(requestWrapper,resp);
    }
}
