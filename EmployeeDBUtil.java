package com.employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
    
	public static boolean validate(String username, String password) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from employee where username='"+username+"' and password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	 
	public static List<Employee> getEmployee(String username) {
		
		ArrayList<Employee> employee = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from employee where username='"+username+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int staff_id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String username1 = rs.getString(5);
				String password = rs.getString(6);
				
				Employee emp = new Employee(staff_id,name,email,phone,username1,password);
				employee.add(emp);
			}
			
		} catch (Exception e) {
			
		}
		
		return employee;	
	}
    
    public static boolean insertemployee(String name, String email, String phone, String username, String password) {
    	
    	boolean isSuccess = false;
    	
    	try {
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "insert into employee values (0,'"+name+"','"+email+"','"+phone+"','"+username+"','"+password+"')";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
 	
    	return isSuccess;
    }
    
    public static boolean updateemployee(String staff_id, String name, String email, String phone, String username, String password) {
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "update employee set name='"+name+"',email='"+email+"',phone='"+phone+"',username='"+username+"',password='"+password+"'"
    				+ "where id='"+staff_id+"'";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
 
    public static List<Employee> getEmployeeDetails(String Id) {
    	
    	int convertedID = Integer.parseInt(Id);
    	
    	ArrayList<Employee> emp = new ArrayList<>();
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from employee where id='"+convertedID+"'";
    		rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			int staff_id = rs.getInt(1);
    			String name = rs.getString(2);
    			String email = rs.getString(3);
    			String phone = rs.getString(4);
    			String username = rs.getString(5);
    			String password = rs.getString(6);
    			
    			Employee e = new Employee(staff_id,name,email,phone,username,password);
    			emp.add(e);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	return emp;	
    }
    
    
    public static boolean deleteEmployee(String id) {
    	
    	int convId = Integer.parseInt(id);
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "delete from employee where id='"+convId+"'";
    		int r = stmt.executeUpdate(sql);
    		
    		if (r > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
