package com.company.payroll.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.payroll.dao.ManagerDao;
import com.company.payroll.model.ManagerModel;

public class TestController extends HttpServlet {
	private static final long serialVersionUID = -8248055380091787011L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<ManagerModel> manager_list = ManagerDao.view();
		session.setAttribute("viewManager", manager_list);
	}

}
