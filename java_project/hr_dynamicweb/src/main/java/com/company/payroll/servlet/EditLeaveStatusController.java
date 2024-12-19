package com.company.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.payroll.dao.ManagerDao;

public class EditLeaveStatusController extends HttpServlet {
	private static final long serialVersionUID = -1708738262372870869L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Integer m_id = Integer.valueOf(session.getAttribute("id").toString());
		Integer l_id = Integer.valueOf(req.getParameter("l_id").toString());
		String l_status = req.getParameter("status");
		
		PrintWriter out = resp.getWriter();
		
		switch(l_status) {
			case "Approved":
				String approved = "Approved";
                int status = ManagerDao.updateLeaveStatus(l_id, approved, m_id);
                if(status > 0) {
                	String success_str = "<script type='text/javascript'>\n"
									   + "alert('Successful approved leave.');\n"
									   + "location='manager?viewLeave';\n"
									   + "</script>";
                	out.println(success_str);
                } else {
                	String fail_str = "<script type='text/javascript'>\n"
							 		+ "alert('Failed to approved leave.');\n"
							 		+ "location='manager?viewLeave';\n"
							 		+ "</script>";
                	out.println(fail_str);
                }
				break;
			case "Rejected":
				String rejected = "Rejected";
				int rej_status = ManagerDao.updateLeaveStatus(l_id, rejected, m_id);
				if(rej_status > 0) {
					String success_str = "<script type='text/javascript'>\n"
									   + "alert('Leave rejected.');\n"
									   + "location='manager?viewLeave';\n"
									   + "</script>";
					out.println(success_str);
                } else {
                	String fail_str = "<script type='text/javascript'>\n"
							 		+ "alert('Rejected fail, please try again.');\n"
							 		+ "location='manager?viewLeave';\n"
							 		+ "</script>";
                	out.println(fail_str);
                }
				break;
			default:
				break;
		}
	}

}
