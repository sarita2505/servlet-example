package com.java.service.impl;

import com.java.dao.IEmpDao;
import com.java.dao.impl.EmpDaoImpl;
import com.java.manager.CrudApiExceptionManager;
import com.java.manager.MySqlConnection;
import com.java.model.AppError;
import com.java.model.Employee;
import com.java.service.IEmpService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmpServiceImpl implements IEmpService {
  private  IEmpDao empDao;

    public EmpServiceImpl() {
        empDao=new EmpDaoImpl();
    }

    @Override
    public Integer create(Employee employee) {
        Integer records=0;
        Connection connection= MySqlConnection.getConnection();

        try {
            records=empDao.insert(connection,employee);
            MySqlConnection.commit(connection);
            return records;

        }
        catch (CrudApiExceptionManager manager) {
            MySqlConnection.rollback(connection);
            AppError appError=new AppError(500,"insert opration failed");
            throw new CrudApiExceptionManager(appError);
        }
        catch (SQLException e) {
            e.printStackTrace();
            MySqlConnection.rollback(connection);
            throw new RuntimeException(e);
        }finally {
            MySqlConnection.close(connection);
        }

    }

    @Override
    public Integer update(Employee employee) {
        Connection connection=MySqlConnection.getConnection();
        int result=0;
        try {
           result= empDao.update(connection,employee);
            MySqlConnection.commit(connection);
            return result;
        }
        catch (CrudApiExceptionManager manager) {
            MySqlConnection.rollback(connection);
            AppError appError=new AppError(500,"update opration failed");
            throw new CrudApiExceptionManager(appError);
        }
        catch (SQLException e) {
            MySqlConnection.rollback(connection);
            throw new RuntimeException(e);
        }finally {
            MySqlConnection.close(connection);
        }
    }

    @Override
    public Boolean delete(Employee employee,String email) {
        Connection connection=MySqlConnection.getConnection();
        boolean flag=false;

        try {
            flag=empDao.delete(connection,email);
            MySqlConnection.commit(connection);
            return flag;
        }
        catch (CrudApiExceptionManager manager) {
            MySqlConnection.rollback(connection);
            AppError appError=new AppError(500,"delete opration failed");
            throw new CrudApiExceptionManager(appError);
        }
        catch (SQLException e) {
            MySqlConnection.rollback(connection);
            throw new RuntimeException(e);
        } finally {
            MySqlConnection.close(connection);
        }
    }

    @Override
    public List<Employee> select() {
        Connection connection=MySqlConnection.getConnection();
        List<Employee>employees;
        try {
           employees=empDao.findAll(connection);
           return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee selectByEmail(String email) {
        Connection connection=MySqlConnection.getConnection();
        Employee emp=null;

        try {
           emp=empDao.findByEmail(connection,email);
           // MySqlConnection.commit(connection);
            return emp;
        } catch (SQLException e) {
           // MySqlConnection.rollback(connection);
            throw new RuntimeException(e);
        } finally {
            MySqlConnection.close(connection);
        }
    }
}
