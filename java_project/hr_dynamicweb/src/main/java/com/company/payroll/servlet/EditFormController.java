package com.company.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.dao.ManagerDao;
import com.company.payroll.model.EmployeeModel;
import com.company.payroll.model.ManagerModel;

public class EditFormController extends HttpServlet {
	private static final long serialVersionUID = -1360590401052458105L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String id = req.getParameter("id");
		String role = req.getParameter("role");
		HttpSession session = req.getSession();
		
		switch(user) {
			case "admin":
				if(role.equals("manager")) {
					session.setAttribute("m_id", id);
					req.getRequestDispatcher("/WEB-INF/views/admin/edit-manager.jsp").forward(req, resp);
				} else if(role.equals("employee")) {
					session.setAttribute("e_id", id);
					req.getRequestDispatcher("/WEB-INF/views/admin/edit-employee.jsp").forward(req, resp);
				} else {
					// TODO loggin here
					System.out.println("no such page");
				}
				break;
			case "manager":
				session.setAttribute("e_id", id);
				req.getRequestDispatcher("/WEB-INF/views/manager/edit-employee.jsp").forward(req, resp);
				break;
			default:
				break;
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String role = req.getParameter("for");
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		
		switch(user) {
			case "admin":
				if(role.equals("manager")) {
					String m_role = req.getParameter("m_role");
			    	String m_name = req.getParameter("m_fullname");
			    	String post = req.getParameter("m_position");
			    	String dept = req.getParameter("m_department");
			    	String phone_num = req.getParameter("m_phone");
			    	String mail = req.getParameter("m_email");
			    	Integer m_id = Integer.valueOf(session.getAttribute("m_id").toString());
			    	
			    	ManagerModel manager = new ManagerModel(m_id, m_name, m_role, post, dept, phone_num, mail);
			    	
			    	int status = ManagerDao.update(manager);
			    	if(status > 0) {
			    		String success_str = "<script type='text/javascript'>\n"
										   + "alert('Sucessful updated info.');\n"
										   + "location='admin?viewManager';\n"
										   + "</script>";
			    		out.println(success_str);
			    	} else {
			    		String fail_str = "<script type='text/javascript'>\n"
							 		+ "alert('Failed to update info.');\n"
							 		+ "location='javascript:history.back();';\n"
							 		+ "</script>";
			    		out.println(fail_str);
			    	}
				} else if(role.equals("employee")) {
					String name = req.getParameter("e_fullname");
			    	String post = req.getParameter("e_position");
			    	String dept = req.getParameter("e_department");
			    	String phone_num = req.getParameter("e_phone");
			    	String mail = req.getParameter("e_email");
			    	Integer e_id = Integer.valueOf(session.getAttribute("e_id").toString());
			    	  	
			    	EmployeeModel employee = new EmployeeModel(e_id, name, post, dept, phone_num, mail);
	
			    	int status = EmployeeDao.update(employee);
			    	if(status > 0) {
			    		String success_str = "<script type='text/javascript'>\n"
										   + "alert('Sucessful updated info.');\n"
										   + "location='admin?viewEmployee';\n"
										   + "</script>";
			    		out.println(success_str);
			    	} else {
			    		String fail_str = "<script type='text/javascript'>\n"
							 		+ "alert('Failed to update info.');\n"
							 		+ "location='javascript:history.back();';\n"
							 		+ "</script>";
			    		out.println(fail_str);
			    	}
				} else {
					System.out.println("no such role");
				}
				break;
			case "manager":
				String name = req.getParameter("e_fullname");
		    	String post = req.getParameter("e_position");
		    	String dept = req.getParameter("e_department");
		    	String phone_num = req.getParameter("e_phone");
		    	String mail = req.getParameter("e_email");
		    	Integer e_id = Integer.valueOf(session.getAttribute("e_id").toString());
		    	  	
		    	EmployeeModel employee = new EmployeeModel(e_id, name, post, dept, phone_num, mail);
		
		    	int status = EmployeeDao.update(employee);
		    	if(status > 0) {
		    		String success_str = "<script type='text/javascript'>\n"
									   + "alert('Sucessful updated info.');\n"
									   + "location='manager?viewEmployee';\n"
									   + "</script>";
		    		out.println(success_str);
		    	} else {
		    		String fail_str = "<script type='text/javascript'>\n"
						 		+ "alert('Failed to update info.');\n"
						 		+ "location='javascript:history.back();';\n"
						 		+ "</script>";
		    		out.println(fail_str);
		    	}
				break;
			default:
				break;
		}
	}

}
