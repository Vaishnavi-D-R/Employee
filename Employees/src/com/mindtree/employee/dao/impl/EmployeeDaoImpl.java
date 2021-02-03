package com.mindtree.employee.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.employee.Util.DBUtility;
import com.mindtree.employee.dao.EmployeeDao;
import com.mindtree.employee.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	DBUtility dbUtil=new DBUtility();
	@Override
	public boolean deleteEmployeeFromDB(int id) throws SQLException {
		boolean isDeleted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String deleteQuery = "delete from Employee where empId=?";
			ps = con.prepareStatement(deleteQuery);

			ps.setInt(1,id);
			
			ps.execute();
			isDeleted = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isDeleted;
	
	}

	@Override
	public List<Employee> getAllCampusMindsFromDB() throws SQLException {
		List<Employee> Employees = new ArrayList<>();
		String role="Campus mind";
		Connection con = null;
		Statement stmt=null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			stmt =con.createStatement();
			String query="Select trackName, count(*) from employee group by trackName";
			rs = stmt.executeQuery(query);
			System.out.println("------Campus minds in each track------");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+ rs.getInt(2));
			}
			String selectQuery = "select * from Employee";
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(selectQuery);
			System.out.println("------Campus minds details-----");
			while (rs.next()) {
				if(rs.getString(5).equals(role)) {
				Employee Employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				Employees.add(Employee);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(con);
		}	
		return Employees;
	}

	@Override
	public boolean updatePhoneInDB(int id, String phone) throws SQLException {
		boolean isUpdated = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String updateQuery = "update Employee set phone=? where empId=?";
			ps = con.prepareStatement(updateQuery);

			ps.setString(1,phone);
			ps.setInt(2,id);

			ps.execute();
			isUpdated = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isUpdated;

	}

	@Override
	public boolean insertIntoDB(Employee emp) throws SQLException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();
	
			String insertQuery = "insert into Employee values(?,?,?,?,?);";
			ps = con.prepareStatement(insertQuery);

			ps.setInt(1, emp.getEmpId());
			ps.setString(2, emp.getEmpName());
			ps.setString(3, emp.getTrackName());
			ps.setString(4, emp.getPhone());
			ps.setString(5, emp.getRole());

			ps.execute();
			isInserted = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isInserted;

	}

}
