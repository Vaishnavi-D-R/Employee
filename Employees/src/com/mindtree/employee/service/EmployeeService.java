package com.mindtree.employee.service;

import java.util.List;

import com.mindtree.employee.entity.Employee;

public interface EmployeeService {

	boolean deleteEmployeeFromDB(int id)throws Exception;

	List<Employee> getAllCampusMindsFromDB()throws Exception;

	boolean updatePhoneInDB(int id, String phone)throws Exception;

	boolean insertIntoDB(Employee emp)throws Exception;

	String getRole(int roleNum)throws Exception;

	String getTrackName(int trackNum)throws Exception;

}
