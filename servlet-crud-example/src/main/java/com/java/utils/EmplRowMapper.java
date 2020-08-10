package com.java.utils;


import com.java.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmplRowMapper  {
    Employee employee=new Employee();
    List<Employee> employees;
    public List<Employee> mapRow(ResultSet resultSet) throws SQLException{

            employee.setEmail(resultSet.getString(1));
            employee.setName(resultSet.getString(2));
            employee.setPassword(resultSet.getString(3));

        employees.add(employee);
        return employees;
    }

}
