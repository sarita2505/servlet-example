package com.java.dao;

import com.java.model.Employee;

import javax.servlet.ServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IEmpDao {
    public Integer insert(Connection connection, Employee employee) throws SQLException;

    public Integer update(Connection connection, Employee employee)throws SQLException;

    public List<Employee> findAll(Connection connection) throws SQLException;

    public Employee findByEmail(Connection connection, String email) throws SQLException;

    public Boolean delete(Connection connection, String email) throws SQLException;
}
