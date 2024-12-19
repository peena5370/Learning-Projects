package com.company.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.model.LoanModel;

public class ApplyLoanController extends HttpServlet {
	private static final long serialVersionUID = 9065323293894733810L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reasons = req.getParameter("reasons");
    	Double loan_amount = Double.valueOf(req.getParameter("amount").toString());
    	Date issue_date = Date.valueOf(req.getParameter("date").toString());
    	String loan_status = "PENDING";
    	HttpSession session = req.getSession();
    	Integer e_id = Integer.valueOf(session.getAttribute("id").toString());
    	
    	PrintWriter out = resp.getWriter();
    	
    	LoanModel loan = new LoanModel(reasons, loan_amount, issue_date, loan_status, e_id);
    	int l_status = EmployeeDao.issueLoan(loan);
    	if(l_status > 0) {
        	String success_str = "<script type='text/javascript'>\n"
					   + "alert('Application submitted. Please visit manager for further assistance.');\n"
					   + "location='employee?applyLoan';\n"
					   + "</script>";
        	out.println(success_str);
    	} else {
    		String fail_str = "<script type='text/javascript'>\n"
					 		+ "alert('Application failed. Please try again.');\n"
					 		+ "location='employee?applyLoan';\n"
					 		+ "</script>";
    		out.println(fail_str);
    	}
	}

}
