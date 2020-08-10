package com.java.servlet;

import com.java.manager.ProcessRequestManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/insert")
public class CreateRecordServlet extends HttpServlet {
    private ProcessRequestManager manager;

    public CreateRecordServlet(ProcessRequestManager manager) {
        this.manager = manager;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        manager.createEmp(req, resp);
    }
}
