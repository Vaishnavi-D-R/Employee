package com.mindtree.employee.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.mindtree.employee.dao.EmployeeDao;
import com.mindtree.employee.dao.impl.EmployeeDaoImpl;
import com.mindtree.employee.entity.Employee;
import com.mindtree.employee.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	EmployeeDao dao=new EmployeeDaoImpl();
	@Override
	public boolean deleteEmployeeFromDB(int id) throws Exception {
		try {
			return dao.deleteEmployeeFromDB(id);
		}
		catch(SQLException e){
			System.out.println("Something went wrong");
		}
		return false;
	}

	@Override
	public List<Employee> getAllCampusMindsFromDB() throws Exception {
		try {
			return dao.getAllCampusMindsFromDB();
		}
		catch(SQLException e){
			System.out.println("Something went wrong");
		}
		return null;
	}

	@Override
	public boolean updatePhoneInDB(int id, String phone) throws Exception {
		try {
			return dao.updatePhoneInDB(id,phone);
		}
		catch(SQLException e){
			System.out.println("Something went wrong");
		}
		return false;
	}

	@Override
	public boolean insertIntoDB(Employee emp) throws Exception {
		try {
			return dao.insertIntoDB(emp);
		}
		catch(SQLException e){
			System.out.println("Something went wrong");
		}
		return false;
	}

	@Override
	public String getRole(int roleNum) throws Exception {
		try {
			if(roleNum>3)
			{
				throw new Exception("Invalid role");
			}
			else 
			{
				if(roleNum==1)return "Lead";
				if(roleNum==2)return "Campus mind";
			}
		}
		catch(Exception e){
			System.out.println("Invalid role Name");
		}
		return null;
	}

	@Override
	public String getTrackName(int trackNum) throws Exception {
		try {
			if(trackNum>5)
			{
				throw new Exception("Invalid track");
			}
			else 
			{
				if(trackNum==1)return "Java";
				if(trackNum==2)return "Sdet";
				if(trackNum==3)return "Dotnet";
				if(trackNum==4)return "DevOps";
				if(trackNum==5)return "Python";
			}
		}
		catch(Exception e){
			System.out.println("Invalid track Name");
		}
		return null;
	}

}
