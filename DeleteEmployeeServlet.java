package com.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteCustomerServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String staff_id = request.getParameter("stff_id");
		boolean isTrue;
		
		isTrue = EmployeeDBUtil.deleteEmployee(staff_id);
		
		if (isTrue == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeinsert.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
			List<Employee> empDetails = EmployeeDBUtil.getEmployeeDetails(staff_id);
			request.setAttribute("empDetails", empDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("useraccount.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
