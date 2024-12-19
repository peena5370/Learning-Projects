package com.learning.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.dao.ManagerDao;
import com.learning.model.ManagerModel;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		if(req.getSession() != null) {
//			req.getSession().invalidate();
//			resp.sendRedirect("index.jsp");
//			listUser(req, resp, session);
//		} else {
//			resp.getWriter().println("end session");
//		}
		String queryStr = req.getParameter("action");
		if(queryStr.equals("click")) {
			System.out.println("click 1");
			req.getRequestDispatcher("/WEB-INF/views/inner-jsp.jsp").forward(req, resp);
		} else if(queryStr.equals("click2")) {
			System.out.println("click 2");
			req.getRequestDispatcher("/WEB-INF/views/inner2-jsp.jsp").forward(req, resp);
		} else {
			System.out.println("click 3");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("text");
		
		if(username.equals("administrator")) {
			// TODO
			// validate password, if true, GOTO page admin, else throw error
			HttpSession session = req.getSession(false);
			session.setAttribute("username", username);
			listUser(req, resp, session);
		} else if(username.matches("([0-9]{7})")) {
			int id = Integer.parseInt(username);
			HttpSession session = req.getSession(false);
			session.setAttribute("username", id);
			listUser(req, resp, session);
		} else {
			resp.getWriter().println("none page");
		}
	}

	private void listUser(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, IOException {
		List<ManagerModel> manager_list = ManagerDao.view();
		for(ManagerModel manager : manager_list) {
			System.out.println("id: " + manager.getId() + "\tname: " + manager.getFullname() + "\trole: " +  manager.getRole() + "\tpost: " + 
    				manager.getPosition() + "\tdept: " + manager.getDepartment() + "\tphone: " + manager.getPhone() + "\temail: " + manager.getEmail());
		}
		session.setAttribute("viewManager", manager_list);
		req.getRequestDispatcher("/WEB-INF/views/viewManager.jsp").forward(req, resp);
		
	}
}
