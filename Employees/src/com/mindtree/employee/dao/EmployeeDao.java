package com.mindtree.employee.dao;

import java.sql.SQLException;
import java.util.List;

import com.mindtree.employee.entity.Employee;

public interface EmployeeDao {

	boolean deleteEmployeeFromDB(int id)throws SQLException;

	List<Employee> getAllCampusMindsFromDB()throws SQLException;

	boolean updatePhoneInDB(int id, String phone)throws SQLException;

	boolean insertIntoDB(Employee emp)throws SQLException;

}
