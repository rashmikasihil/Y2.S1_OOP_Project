package com.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEmployeeServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String staff_id = request.getParameter("staffid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		boolean isTrue;
		
		isTrue = EmployeeDBUtil.updateemployee(staff_id, name, email, phone, username, password);
		
		if(isTrue == true) {
			
			List<Employee> empDetails = EmployeeDBUtil.getEmployeeDetails(staff_id);
			request.setAttribute("empDetails", empDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
		}
		else {
			List<Employee> empDetails = EmployeeDBUtil.getEmployeeDetails(staff_id);
			request.setAttribute("empDetails", empDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
		}
	}

}
