package com.java.service;

import com.java.model.Employee;

import java.util.List;

public interface IEmpService {
    public Integer create(Employee employee);

    public Integer update(Employee employee);

    public Boolean delete(Employee employee,String email);

    public List<Employee> select();

    public Employee selectByEmail(String email);
}
