package com.java.login.requestwrapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.mapper.MapperClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/servlet2")
public class servlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // Data data= MapperClass.getObjectFromJson( req,Data.class);
        RequestWrapper requestWrapper = (RequestWrapper) req;
        ObjectMapper objectMapper=new ObjectMapper();
        //Data data=objectMapper.readValue(req.getReader(),Data.class);
        Data data=objectMapper.readValue(requestWrapper.getReader(),Data.class);
        String s1=data.getData();
        resp.getWriter().write(s1);
    }
}
