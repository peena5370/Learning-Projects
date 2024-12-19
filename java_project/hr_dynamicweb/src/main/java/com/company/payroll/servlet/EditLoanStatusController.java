package com.company.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.payroll.dao.ManagerDao;

public class EditLoanStatusController extends HttpServlet {
	private static final long serialVersionUID = -396152645845526979L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Integer m_id = Integer.valueOf(session.getAttribute("id").toString());
		Integer loan_id = Integer.valueOf(req.getParameter("loan_id").toString());
		String loan_status = req.getParameter("status");
		
		PrintWriter out = resp.getWriter();
		
		switch(loan_status) {
			case "Approved":
				String approved = "Approved";
				int status = ManagerDao.updateLoanStatus(loan_id, approved, m_id);
	            if(status > 0) {
	            	String success_str = "<script type='text/javascript'>\n"
									   + "alert('Successful approved loan.');\n"
									   + "location='manager?viewLoan';\n"
									   + "</script>";
	            	out.println(success_str);
	            } else {
	            	String fail_str = "<script type='text/javascript'>\n"
							 		+ "alert('Failed to approved loan');\n"
							 		+ "location='manager?viewLoan';\n"
							 		+ "</script>";
	            	out.println(fail_str);
	            }
				break;
			case "Rejected":
				String rejected = "Rejected";
				int rej_status = ManagerDao.updateLoanStatus(loan_id, rejected, m_id);
				if(rej_status > 0) {
					String success_str = "<script type='text/javascript'>\n"
									   + "alert('Loan rejected.');\n"
									   + "location='manager?viewLoan';\n"
									   + "</script>";
					out.println(success_str);
	            } else {
	            	String fail_str = "<script type='text/javascript'>\n"
							 		+ "alert('Rejected fail, please try again.');\n"
							 		+ "location='manager?viewLoan';\n"
							 		+ "</script>";
	            	out.println(fail_str);
	            }
				break;
			default:
				break;
		}
	}

}
