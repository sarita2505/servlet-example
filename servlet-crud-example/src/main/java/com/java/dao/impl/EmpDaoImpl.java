package com.java.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dao.IEmpDao;
import com.java.manager.MySqlConnection;
import com.java.model.Employee;
import com.java.utils.EmplObjectMapper;
import com.java.utils.EmplRowMapper;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class EmpDaoImpl implements IEmpDao {

    private String insert = "INSERT INTO EMP(email,name,password) values(?,?,?)";
    private String update = "UPDATE EMP SET NAME=?,PASSWORD=? WHERE EMAIL=?";
    private String selectall = "SELECT * FROM EMP";
    private String selectByEmail = "SELECT * FROM EMP WHERE EMAIL=?";
    private String delete = "DELETE EMP WHERE EMAIL=?";

    @Override
    public Integer insert(Connection connection, Employee employee) throws SQLException {

        Integer records = 0;
        PreparedStatement pst = null;

        pst = connection.prepareStatement(insert);
        pst.setString(1, employee.getEmail());
        pst.setString(2, employee.getName());
        pst.setString(3, employee.getPassword());
        records = pst.executeUpdate();

        return records;
    }

    @Override
    public Integer update(Connection connection, Employee employee) throws SQLException {
        Integer records = 0;
        PreparedStatement pst = null;

            pst = connection.prepareStatement(update);
            pst.setString(1, employee.getName());
            pst.setString(2, employee.getPassword());
            pst.setString(3, employee.getEmail());
            records = pst.executeUpdate();

        return records;
    }

    @Override
    public List<Employee> findAll(Connection connection) throws SQLException {
        PreparedStatement pst = connection.prepareStatement(selectall);
        EmplRowMapper mapper = new EmplRowMapper();
        ResultSet resultSet = pst.executeQuery();
        return mapper.mapRow(resultSet);
    }

    @Override
    public Employee findByEmail(Connection connection, String email) throws SQLException {
        Employee employee = new Employee();
        PreparedStatement pst = connection.prepareStatement(selectByEmail);
        pst.setString(1, email);
        EmplRowMapper mapper = new EmplRowMapper();
        ResultSet resultSet = pst.executeQuery();
        if (resultSet.next()) {
            employee.setName(resultSet.getString(1));
            employee.setEmail(resultSet.getString(2));
            employee.setPassword(resultSet.getString(3));
        }
        return employee;
    }

    @Override
    public Boolean delete(Connection connection, String email) throws SQLException {
        Boolean flag = false;
        Integer records = 0;
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setString(1, email);
        records = preparedStatement.executeUpdate();
        if (records > 0) {
            flag = true;
        }
        return flag;
    }
}
