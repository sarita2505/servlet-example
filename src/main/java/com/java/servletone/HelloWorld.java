package com.java.servletone;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = "/helloworld")
public class HelloWorld implements Servlet {
    ServletConfig config=null;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("helloworld servletone init");
        System.out.println(servletConfig.getInitParameter("servletconfig"));
        this.config=servletConfig;
        System.out.println("servletone name: "+servletConfig.getServletName());
        System.out.println("servletone context:"+servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter writer=servletResponse.getWriter();
        writer.write("hello world");
        writer.write("<br/>content length: "+servletRequest.getContentLength());
        writer.write("<br/>content type: "+servletRequest.getContentType());
        writer.write("<br/>localaddress: "+servletRequest.getLocalAddr());
        writer.write("</br>"+servletRequest.getRemoteAddr()+":get remote address");
        writer.write("</br>"+servletRequest.getRemoteHost()+":get remote host");
        writer.write("</br>"+servletRequest.getRemotePort()+":get rempte port");
        writer.write("<br/>localname: "+servletRequest.getLocalName());
        writer.write("</br>"+servletRequest.getLocalPort()+":localport");
        writer.write("</br>"+servletRequest.getParameter("param")+":get parameter");
       String[] s= servletRequest.getParameterValues("param");
        for (String s1: s) {
            writer.write(s1+":param value");
        }
        writer.write("</br>"+servletRequest.getProtocol()+":get protocal");
        writer.write("</br>"+servletRequest.getScheme()+":get scheme");
        writer.write("</br>"+servletRequest.getServerName()+":get server name");
        writer.write("</br>"+servletRequest.getServerPort()+":get server port");

        writer.write("</br>"+servletRequest.getServletContext().getContextPath()+":servletone context path");
        writer.write("</br>"+servletRequest.getServletContext().getInitParameter("servletcontext")+":servletone context");
        servletRequest.setAttribute("helloworld","attribute of hello world");
        RequestDispatcher dispatcher=servletRequest.getRequestDispatcher("/hello");
       dispatcher.forward(servletRequest,servletResponse);


    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("helloworld servletone destroied");
    }
}
