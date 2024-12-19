package v2.com.company.payroll.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import v2.com.company.payroll.dao.DepartmentDao;
import v2.com.company.payroll.dao.EmployeeDao;
import v2.com.company.payroll.dao.EmployeeLeaveDao;
import v2.com.company.payroll.dao.EmployeeLoanDao;
import v2.com.company.payroll.dao.EmployeePromotionDao;
import v2.com.company.payroll.dao.EmployeeSalaryDao;
import v2.com.company.payroll.dao.ManagerDao;
import v2.com.company.payroll.dao.PayRollDao;
import v2.com.company.payroll.dao.ResignationDao;
import v2.com.company.payroll.dao.TitleDao;
import v2.com.company.payroll.dao.TrainingDao;
import v2.com.company.payroll.dao.impl.DepartmentDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeLeaveDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeLoanDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeePromotionDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeSalaryDaoImpl;
import v2.com.company.payroll.dao.impl.ManagerDaoImpl;
import v2.com.company.payroll.dao.impl.PayRollDaoImpl;
import v2.com.company.payroll.dao.impl.ResignationDaoImpl;
import v2.com.company.payroll.dao.impl.TitleDaoImpl;
import v2.com.company.payroll.dao.impl.TrainingDaoImpl;
import v2.com.company.payroll.model.DepartmentModel;
import v2.com.company.payroll.model.EmployeeLeaveModel;
import v2.com.company.payroll.model.EmployeeLoanModel;
import v2.com.company.payroll.model.EmployeeModel;
import v2.com.company.payroll.model.EmployeePromotionModel;
import v2.com.company.payroll.model.EmployeeSalaryModel;
import v2.com.company.payroll.model.ManagerModel;
import v2.com.company.payroll.model.PayRollModel;
import v2.com.company.payroll.model.ResignationModel;
import v2.com.company.payroll.model.TitleModel;
import v2.com.company.payroll.model.TrainingModel;

public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1414446126845990183L;
	
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	private ManagerDao managerDao = new ManagerDaoImpl();	
	private EmployeePromotionDao promotionDao = new EmployeePromotionDaoImpl();		
	private EmployeeSalaryDao salaryDao = new EmployeeSalaryDaoImpl();
	private PayRollDao payrollDao = new PayRollDaoImpl();
	private EmployeeLeaveDao leaveDao = new EmployeeLeaveDaoImpl();
	private EmployeeLoanDao loanDao = new EmployeeLoanDaoImpl();
	private ResignationDao resignationDao = new ResignationDaoImpl();
	private TrainingDao trainingDao = new TrainingDaoImpl();
	private TitleDao titleDao = new TitleDaoImpl();
	private DepartmentDao departmentDao = new DepartmentDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		HttpSession session = req.getSession();	

		List<TitleModel> title_list = titleDao.getAllTitleList();
		session.setAttribute("titleList", title_list);	

		List<DepartmentModel> dept_list = departmentDao.getAllDepartment();
		session.setAttribute("deptList", dept_list);
		
		switch(pathInfo) {
			case "/view-employee":
				List<EmployeeModel> employee_list = employeeDao.listAllEmployee();
				session.setAttribute("employeeList", employee_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/main.jsp").forward(req, resp);
				break;
			case "/view-promotion":
				List<EmployeePromotionModel> promotion_list = promotionDao.getAllPromotion();
				session.setAttribute("promotionList", promotion_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/view-promotion.jsp").forward(req, resp);
				break;
			case "/view-salary":
				List<EmployeeSalaryModel> salary_list = salaryDao.getAllEmployeeSalary();
				session.setAttribute("salaryList", salary_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/view-salary.jsp").forward(req, resp);
				break;
			case "/view-payroll":
				List<PayRollModel> payroll_list = payrollDao.getListByManager();
				session.setAttribute("payrollList", payroll_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/view-payroll.jsp").forward(req, resp);
				break;
			case "/view-leave":
				List<EmployeeLeaveModel> leave_list = leaveDao.getLeaveList();
				session.setAttribute("leaveList", leave_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/view-leave.jsp").forward(req, resp);
				break;
			case "/view-loan":
				List<EmployeeLoanModel> loan_list = loanDao.getLoanList();
				session.setAttribute("loanList", loan_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/view-loan.jsp").forward(req, resp);
				break;
			case "/view-resign":
				List<ResignationModel> resign_list = resignationDao.getResignationList();
				session.setAttribute("resignList", resign_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/view-resign.jsp").forward(req, resp);
				break;
			case "/view-training":
				List<TrainingModel> training_list = trainingDao.getListByManager();
				session.setAttribute("trainingList", training_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/view-training.jsp").forward(req, resp);
				break;
			case "/profile":
				Integer id = Integer.valueOf(req.getParameter("id"));
				ManagerModel manager = managerDao.getManagerByManagerId(id);
				session.setAttribute("user", manager);
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/profile.jsp").forward(req, resp);
				break;
			default:
				break;
		}
	}

}
