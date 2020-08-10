package com.java.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.model.Employee;
import com.java.service.IEmpService;
import com.java.service.impl.EmpServiceImpl;
import com.java.utils.EmplObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProcessRequestManager {
    IEmpService iEmpService;

    public ProcessRequestManager(IEmpService iEmpService) {
        this.iEmpService = iEmpService;
    }
    public  void createEmp(ServletRequest request, ServletResponse response){
        HttpServletRequest req=(HttpServletRequest)request;
        Employee employee = null;
        try {
            employee = EmplObjectMapper.getObjectFromJson(req.getReader(), Employee.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        iEmpService.create(employee);
    }


}
