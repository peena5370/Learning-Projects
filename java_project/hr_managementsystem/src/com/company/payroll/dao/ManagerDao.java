package com.company.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.payroll.model.LeaveModel;
import com.company.payroll.model.LoanModel;
import com.company.payroll.model.ManagerModel;
import com.company.payroll.model.MonthlySalaryModel;
import com.company.payroll.model.ResignationModel;
import com.company.payroll.model.SalaryModel;
import com.company.payroll.model.TrainingModel;
import com.company.payroll.services.Databases;


public class ManagerDao {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	
	/**
	 * 
	 * */
	public static int add(ManagerModel manager) {
		int status = 0;
		conn = Databases.connect();
		String sql = "INSERT INTO tbl_manager(m_fullname, m_authpassword, m_authkey, m_role, m_position, m_department, m_phone, m_email)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manager.getFullname());
			pstmt.setString(2, manager.getPassword());
			pstmt.setString(3, manager.getKey());
			pstmt.setString(4, manager.getRole());
			pstmt.setString(5, manager.getPosition());
			pstmt.setString(6, manager.getDepartment());
			pstmt.setString(7, manager.getPhone());
			pstmt.setString(8, manager.getEmail());
			
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				status = rs;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.close(pstmt, conn);
		}
		return status;
	}
	
	/**
	 * 
	 * */
	public static List<ManagerModel> view() {
		List<ManagerModel> manager_list = new ArrayList<ManagerModel>();
		conn = Databases.connect();
		String sql = "SELECT m_id, m_fullname, m_role, m_position, m_department, m_phone, m_email "
					+ "FROM tbl_manager ORDER BY m_id";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ManagerModel manager = new ManagerModel();
				
				manager.setId(rs.getInt("m_id"));
				manager.setFullname(rs.getString("m_fullname"));
				manager.setRole(rs.getString("m_role"));
				manager.setPosition(rs.getString("m_position"));
				manager.setDepartment(rs.getString("m_department"));
				manager.setPhone(rs.getString("m_phone"));
				manager.setEmail(rs.getString("m_email"));

				manager_list.add(manager);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.queryClose(pstmt, rs, conn);
		}
		return manager_list;
	}
	
	/**
	 * 
	 * */
	public static int update(ManagerModel manager) {
		int status = 0;
		conn = Databases.connect();
		String sql = "UPDATE tbl_manager SET m_role=?, m_fullname=?, m_position=?, m_department=?, m_phone=?, m_email=?"
					+ " WHERE m_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manager.getRole());
			pstmt.setString(2, manager.getFullname());
			pstmt.setString(3, manager.getPosition());
			pstmt.setString(4, manager.getDepartment());
			pstmt.setString(5, manager.getPhone());
			pstmt.setString(6, manager.getEmail());
			pstmt.setInt(7, manager.getId());
			
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				status = rs;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.close(pstmt, conn);
		}
		return status;
	}
	
	/**
	 * 
	 * */
	public static int delete(int id) {
		int status = 0;
		conn = Databases.connect();
		String sql = "DELETE FROM tbl_manager WHERE m_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				status = rs;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.close(pstmt, conn);
		}
		return status;
	}
	
	/**
	 * 
	 * */
	public static ManagerModel getFullName(int id) {
		ManagerModel manager = new ManagerModel();
		conn = Databases.connect();
		String sql = "SELECT m_fullname FROM tbl_manager WHERE m_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				manager.setFullname(rs.getString(1));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.queryClose(pstmt, rs, conn);
		}
		return manager;
	}
	
	public static List<SalaryModel> viewEmployeeSalary() {
		List<SalaryModel> salary_list = new ArrayList<SalaryModel>();
		conn = Databases.connect();
		String sql = "SELECT s_id, base_salary, incremented_salary, increment_date, tbl_employee.e_fullname AS employeename, "
				+ "tbl_manager.m_fullname AS managername FROM tbl_employeesalary "
				+ "INNER JOIN tbl_employee ON tbl_employee.e_id = tbl_employeesalary.e_id "
				+ "LEFT JOIN tbl_manager ON tbl_manager.m_id = tbl_employeesalary.m_id "
				+ "ORDER BY s_id";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SalaryModel salary = new SalaryModel();
				salary.setS_id(rs.getInt("s_id"));
				salary.setBase_salary(rs.getDouble("base_salary"));
				salary.setIncremented_salary(rs.getDouble("incremented_salary"));
				salary.setIncrement_date(rs.getString("increment_date"));
				salary.setEmployee_name(rs.getString("employeename"));
				salary.setIssuedByManager(rs.getString("managername"));
				
				salary_list.add(salary);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.queryClose(pstmt, rs, conn);
		}
		return salary_list;
	}
	
	
	
	public static List<MonthlySalaryModel> viewMonthlySalary() {
		List<MonthlySalaryModel> salary_list = new ArrayList<MonthlySalaryModel>();
		conn = Databases.connect();
		String sql = "SELECT mp_id, mp_currentsalary, mp_overtimepay, mp_deductedsalary, mp_totalpay, "
				+ "tbl_employee.e_fullname AS employeename, tbl_manager.m_fullname AS managername, "
				+ "mp_paymentdate FROM tbl_monthlypay "
				+ "INNER JOIN tbl_employee ON tbl_employee.e_id = tbl_monthlypay.e_id "
				+ "INNER JOIN tbl_manager ON tbl_manager.m_id = tbl_monthlypay.m_id "
				+ "ORDER BY mp_id";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MonthlySalaryModel monthly_salary = new MonthlySalaryModel();
				monthly_salary.setMonthlysalary_id(rs.getInt("mp_id"));
				monthly_salary.setCurrent_salary(rs.getDouble("mp_currentsalary"));
				monthly_salary.setOvertime_pay(rs.getDouble("mp_overtimepay"));
				monthly_salary.setDeduction(rs.getDouble("mp_deductedsalary"));
				monthly_salary.setTotal_salary(rs.getDouble("mp_totalpay"));
				monthly_salary.setEmployee_name(rs.getString("employeename"));
				monthly_salary.setApprovedByManager(rs.getString("managername"));
				monthly_salary.setPayment_date(rs.getDate("mp_paymentdate"));
				
				salary_list.add(monthly_salary);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.queryClose(pstmt, rs, conn);
		}
		return salary_list;
	}
	
	public static List<LoanModel> viewLoan() {
		List<LoanModel> loan_list = new ArrayList<LoanModel>();
		conn = Databases.connect();
		String sql = "SELECT loan_id, loan_reasons, loan_amount, loan_issuedate, loan_status, "
				+ "tbl_employee.e_fullname AS employeename, tbl_manager.m_fullname AS approvedby "
				+ "FROM tbl_loan INNER JOIN tbl_employee ON tbl_employee.e_id = tbl_loan.e_id "
				+ "LEFT JOIN tbl_manager ON tbl_manager.m_id = tbl_loan.m_id "
				+ "ORDER BY loan_id;";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				LoanModel loan = new LoanModel();
				loan.setLoan_id(rs.getInt("loan_id"));
				loan.setReasons(rs.getString("loan_reasons"));
				loan.setLoan_amount(rs.getDouble("loan_amount"));
				loan.setIssued_date(rs.getDate("loan_issuedate"));
				loan.setLoan_status(rs.getString("loan_status"));
				loan.setEmployee_name(rs.getString("employeename"));
				loan.setApprovedByManager(rs.getString("approvedby"));
				
				loan_list.add(loan);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.queryClose(pstmt, rs, conn);
		}
		return loan_list;
	}
	
	public static int updateLoanStatus(int id, String loan_status, int m_id) {
		int status = 0;
		conn = Databases.connect();
		String sql = "UPDATE tbl_loan SET loan_status=?, m_id=? WHERE loan_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loan_status);
			pstmt.setInt(2, m_id);
			pstmt.setInt(3, id);
			
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				status = rs;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.close(pstmt, conn);
		}
		
		return status;
	}
	
	public static int issueSalary(MonthlySalaryModel monthlysalarymodel) {
		int status = 0;
		conn = Databases.connect();
		String sql = "INSERT INTO tbl_monthlypay(mp_currentsalary, mp_overtimepay, mp_deductedsalary, mp_totalpay, e_id, m_id, mp_paymentdate) "
				+ "VALUES(?, ?, ?, ?, (SELECT e_id FROM tbl_employee WHERE e_fullname=?), "
				+ "(SELECT m_id FROM tbl_manager WHERE m_fullname=?), ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, monthlysalarymodel.getCurrent_salary());
			pstmt.setDouble(2, monthlysalarymodel.getOvertime_pay());
			pstmt.setDouble(3, monthlysalarymodel.getDeduction());
			pstmt.setDouble(4, monthlysalarymodel.getTotal_salary());
			pstmt.setString(5, monthlysalarymodel.getEmployee_name());
			pstmt.setString(6, monthlysalarymodel.getApprovedByManager());
			pstmt.setDate(7, monthlysalarymodel.getPayment_date());
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				status = rs;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.close(pstmt, conn);
		}
		return status;
	}
	
	public static List<LeaveModel> viewLeave() {
		List<LeaveModel> leave_list = new ArrayList<LeaveModel>();
		conn = Databases.connect();
		String sql = "SELECT l_id, l_reasons, l_datefrom, l_dateto, l_type, l_status, tbl_employee.e_fullname AS employeename, "
					+ "tbl_manager.m_fullname AS managername  FROM tbl_leave "
					+ "INNER JOIN tbl_employee ON tbl_employee.e_id = tbl_leave.e_id "
					+ "LEFT JOIN tbl_manager ON tbl_manager.m_id = tbl_leave.m_id "
					+ "ORDER BY l_id;";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				LeaveModel leave = new LeaveModel();
				leave.setL_id(rs.getInt("l_id"));
				leave.setReasons(rs.getString("l_reasons"));
				leave.setDate_from(rs.getString("l_datefrom"));
				leave.setDate_to(rs.getString("l_dateto"));
				leave.setLeave_type(rs.getString("l_type"));
				leave.setStatus(rs.getString("l_status"));
				leave.setEmployee_name(rs.getString("employeename"));
				leave.setApprovedByManager(rs.getString("managername"));
				
				leave_list.add(leave);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.queryClose(pstmt, rs, conn);
		}
		return leave_list;
	}
	
	/**
	 * TODO UPDATE sql query, need to insert m_id together with the sql query
	 * */
	public static int updateLeaveStatus(int id, String leave_status, int m_id) {
		int status = 0;
		conn = Databases.connect();
		String sql = "UPDATE tbl_leave SET l_status=?, m_id=? WHERE l_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, leave_status);
			pstmt.setInt(2, m_id);
			pstmt.setInt(3, id);
			
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				status = rs;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.close(pstmt, conn);
		}
		return status;
	}
	
	public static List<TrainingModel> viewTraining() {
		List<TrainingModel> training_list = new ArrayList<TrainingModel>();
		conn = Databases.connect();
		String sql = "SELECT t_id, t_info, t_startdate, t_enddate, t_status, tbl_employee.e_fullname AS employeename, "
					+ "tbl_manager.m_fullname AS managername FROM tbl_training "
					+ "INNER JOIN tbl_employee ON tbl_employee.e_id = tbl_training.e_id "
					+ "INNER JOIN tbl_manager ON tbl_manager.m_id = tbl_training.m_id "
					+ "ORDER BY t_id;";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TrainingModel training = new TrainingModel();
				
				training.setT_id(rs.getInt("t_id"));
				training.setInfo(rs.getString("t_info"));
				training.setStartdate(rs.getDate("t_startdate"));
				training.setEnddate(rs.getDate("t_enddate"));
				training.setStatus(rs.getString("t_status"));
				training.setEmployee_name(rs.getString("employeename"));
				training.setIssuedByManager(rs.getString("managername"));
				
				training_list.add(training);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.queryClose(pstmt, rs, conn);
		}
		return training_list;
	}
	
	public static int issueTraining(TrainingModel trainingmodel) {
		int status = 0;
		conn = Databases.connect();
		String sql = "INSERT INTO tbl_training(t_info, t_startdate, t_enddate, t_status, e_id, m_id) "
					+ "VALUES(?, ?, ?, ?, (SELECT e_id FROM tbl_employee WHERE e_fullname=?), "
					+ "(SELECT m_id FROM tbl_manager WHERE m_fullname=?));";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, trainingmodel.getInfo());
			pstmt.setDate(2, trainingmodel.getStartdate());
			pstmt.setDate(3, trainingmodel.getEnddate());
			pstmt.setString(4, trainingmodel.getStatus());
			pstmt.setString(5, trainingmodel.getEmployee_name());
			pstmt.setString(6, trainingmodel.getIssuedByManager());
			
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				status = rs;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.close(pstmt, conn);
		}
		return status;
	}
	
	public static int issueIncrement(SalaryModel salary) {
		int status = 0;
		conn = Databases.connect();
		String sql = "UPDATE tbl_employeesalary "
				+ "INNER JOIN tbl_employee ON tbl_employee.e_id = tbl_employeesalary.e_id "
				+ "SET incremented_salary=?, increment_date=?, "
				+ "tbl_employeesalary.m_id = (SELECT m_id FROM tbl_manager WHERE tbl_manager.m_fullname=?) "
				+ "WHERE tbl_employee.e_fullname=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, salary.getIncremented_salary());
			pstmt.setString(2, salary.getIncrement_date());
			pstmt.setString(3, salary.getIssuedByManager());
			pstmt.setString(4, salary.getEmployee_name());
			
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				status = rs;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.close(pstmt, conn);
		}
		return status;
	}
	
	public static List<ResignationModel> viewResignation() {
		List<ResignationModel> resign_list = new ArrayList<ResignationModel>();
		conn = Databases.connect();
		String sql = "SELECT r_id, r_reasons, r_date, tbl_employee.e_fullname AS employeename, tbl_manager.m_fullname AS managername "
					+ "FROM tbl_resignation "
					+ "INNER JOIN tbl_employee ON tbl_employee.e_id=tbl_resignation.e_id "
					+ "INNER JOIN tbl_manager ON tbl_manager.m_id=tbl_resignation.m_id "
					+ "ORDER BY r_id";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ResignationModel resign = new ResignationModel();
				resign.setR_id(rs.getInt(1));
				resign.setReasons(rs.getString(2));
				resign.setEnddate(rs.getDate(3));
				resign.setEmployee_name(rs.getString(4));
				resign.setIssuedByManager(rs.getString(5));
				
				resign_list.add(resign);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.queryClose(pstmt, rs, conn);
		}
		return resign_list;
	}
	
	public static int issueResignation(ResignationModel resign) {
		int status = 0;
		conn = Databases.connect();
		String sql = "INSERT INTO tbl_resignation(r_reasons, r_date, e_id, m_id) "
					+ "VALUES(?, ?, (SELECT e_id FROM tbl_employee WHERE e_fullname=?), "
					+ "(SELECT m_id FROM tbl_manager WHERE m_fullname=?))";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resign.getReasons());
			pstmt.setDate(2, resign.getEnddate());
			pstmt.setString(3, resign.getEmployee_name());
			pstmt.setString(4, resign.getIssuedByManager());
			
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				status = rs;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.close(pstmt, conn);
		}
		return status;
	}
	
	public static int insertResignDate(String date, String name) {
		int status = 0;
		conn = Databases.connect();
		String sql = "UPDATE tbl_employee SET e_enddate=? WHERE e_fullname=? AND e_id > 0";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, date);
			pstmt.setString(2, name);
			
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				status = rs;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.close(pstmt, conn);
		}
		return status;
	}
}
