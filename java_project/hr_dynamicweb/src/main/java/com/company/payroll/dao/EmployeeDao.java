package com.company.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.payroll.model.EmployeeModel;
import com.company.payroll.model.LeaveModel;
import com.company.payroll.model.LoanModel;
import com.company.payroll.model.MonthlySalaryModel;
import com.company.payroll.model.TrainingModel;
import com.company.payroll.services.Databases;

public class EmployeeDao {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	public static List<EmployeeModel> view() {
		List<EmployeeModel> employee_list = new ArrayList<EmployeeModel>();
		conn = Databases.connect();
		String sql = "SELECT e_id, e_fullname, e_position, e_department, e_phone, e_email, e_startdate, e_enddate "
					+ "FROM tbl_employee ORDER BY e_id";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmployeeModel employee = new EmployeeModel();
				
				employee.setId(rs.getInt("e_id"));
				employee.setFullname(rs.getString("e_fullname"));
				employee.setPosition(rs.getString("e_position"));
				employee.setDepartment(rs.getString("e_department"));
				employee.setPhone(rs.getString("e_phone"));
				employee.setEmail(rs.getString("e_email"));
				employee.setStartdate(rs.getString("e_startdate"));
				employee.setEnddate(rs.getString("e_enddate"));

				employee_list.add(employee);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.queryClose(pstmt, rs, conn);
		}
		return employee_list;
	}

	public static int add(EmployeeModel employee) {
		int status = 0;
		conn = Databases.connect();
		String sql = "INSERT INTO tbl_employee(e_fullname, e_authpassword, e_authkey, e_position, e_department, e_phone, e_email, e_startdate)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getFullname());
			pstmt.setString(2, employee.getPassword());
			pstmt.setString(3, employee.getKey());
			pstmt.setString(4, employee.getPosition());
			pstmt.setString(5, employee.getDepartment());
			pstmt.setString(6, employee.getPhone());
			pstmt.setString(7, employee.getEmail());
			pstmt.setString(8, employee.getStartdate());
			
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
		String sql = "DELETE FROM tbl_employee WHERE e_id=?";
		
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
	public static int update(EmployeeModel employee) {
		int status = 0;
		conn = Databases.connect();
		String sql = "UPDATE tbl_employee SET e_fullname=?, e_position=?, e_department=?, e_phone=?, e_email=?"
					+ " WHERE e_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getFullname());
			pstmt.setString(2, employee.getPosition());
			pstmt.setString(3, employee.getDepartment());
			pstmt.setString(4, employee.getPhone());
			pstmt.setString(5, employee.getEmail());
			pstmt.setInt(6, employee.getId());
			
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
	
	public static int addBaseSalary(EmployeeModel employee) {
		int status = 0;
		conn = Databases.connect();
		String sql = "INSERT INTO tbl_employeesalary(base_salary, e_id) "
					+ "VALUES(?, (SELECT e_id FROM tbl_employee "
					+ "WHERE e_fullname=?))";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, employee.getBase_salary());
			pstmt.setString(2, employee.getFullname());
			
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
	
	public static EmployeeModel queryInfo(int id) {
		EmployeeModel employee = new EmployeeModel();
		conn = Databases.connect();
		String sql = "SELECT e_id, e_fullname, e_position, e_department, e_phone, e_email, e_startdate "
					+ "FROM tbl_employee WHERE e_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				employee.setId(rs.getInt("e_id"));
				employee.setFullname(rs.getString("e_fullname"));
				employee.setPosition(rs.getString("e_position"));
				employee.setDepartment(rs.getString("e_department"));
				employee.setPhone(rs.getString("e_phone"));
				employee.setEmail(rs.getString("e_email"));
				employee.setStartdate(rs.getString("e_startdate"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.queryClose(pstmt, rs, conn);
		}
		return employee;
	}
	
	public static EmployeeModel queryPassword(int id) {
		EmployeeModel employee = new EmployeeModel();
		conn = Databases.connect();
		String sql = "SELECT e_authpassword, e_authkey FROM tbl_employee WHERE e_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				employee.setPassword(rs.getString(1));
				employee.setKey(rs.getString(2));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.queryClose(pstmt, rs, conn);
		}
		return employee;
	}
	
	public static int updatePassword(EmployeeModel employee) {
		int status = 0;
		conn = Databases.connect();
		String sql = "UPDATE tbl_employee SET e_authpassword=?, e_authkey=? WHERE e_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getPassword());
			pstmt.setString(2, employee.getKey());
			pstmt.setInt(3, employee.getId());
			
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
	
	public static List<LeaveModel> viewLeave(int id) {
		List<LeaveModel> leave_list = new ArrayList<LeaveModel>();
		conn = Databases.connect();
		String sql = "SELECT l_reasons, l_datefrom, l_dateto, l_type, l_status, tbl_manager.m_fullname AS managername "
					+ "FROM tbl_leave "
					+ "LEFT JOIN tbl_manager ON tbl_manager.m_id = tbl_leave.m_id WHERE e_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				LeaveModel leave = new LeaveModel();
				leave.setReasons(rs.getString("l_reasons"));
				leave.setDate_from(rs.getString("l_datefrom"));
				leave.setDate_to(rs.getString("l_dateto"));
				leave.setLeave_type(rs.getString("l_type"));
				leave.setStatus(rs.getString("l_status"));
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
	
	public static List<TrainingModel> viewTraining(int id) {
		List<TrainingModel> training_list = new ArrayList<TrainingModel>();
		conn = Databases.connect();
		String sql = "SELECT t_id, t_info, t_startdate, t_enddate, t_status, tbl_manager.m_fullname AS managername "
					+ "FROM tbl_training "
					+ "LEFT JOIN tbl_manager ON tbl_manager.m_id = tbl_training.m_id "
					+ "where e_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TrainingModel training = new TrainingModel();
				training.setT_id(rs.getInt("t_id"));
				training.setInfo(rs.getString("t_info"));
				training.setStartdate(rs.getDate("t_startdate"));
				training.setEnddate(rs.getDate("t_enddate"));
				training.setStatus(rs.getString("t_status"));
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
	
	public static int updateTraining(String t_status, int id, int t_id) {
		int status = 0;
		conn = Databases.connect();
		String sql = "UPDATE tbl_training SET t_status=? WHERE e_id=? AND t_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t_status);
			pstmt.setInt(2, id);
			pstmt.setInt(3, t_id);
			
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
	
	public static List<MonthlySalaryModel> viewSalary(int id) {
		List<MonthlySalaryModel> salary_list = new ArrayList<MonthlySalaryModel>();
		conn = Databases.connect();
		String sql = "SELECT mp_id, mp_currentsalary, mp_overtimepay, mp_deductedsalary, mp_totalpay, mp_paymentdate, tbl_manager.m_fullname AS managername "
					+ "FROM tbl_monthlypay LEFT JOIN tbl_manager ON tbl_manager.m_id = tbl_monthlypay.m_id "
					+ "WHERE e_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MonthlySalaryModel salary = new MonthlySalaryModel();
				salary.setMonthlysalary_id(rs.getInt("mp_id"));
				salary.setCurrent_salary(rs.getDouble("mp_currentsalary"));
				salary.setOvertime_pay(rs.getDouble("mp_overtimepay"));
				salary.setDeduction(rs.getDouble("mp_deductedsalary"));
				salary.setTotal_salary(rs.getDouble("mp_totalpay"));
				salary.setPayment_date(rs.getDate("mp_paymentdate"));
				salary.setApprovedByManager(rs.getString("managername"));
				
				salary_list.add(salary);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Databases.queryClose(pstmt, rs, conn);
		}
		return salary_list;
	}
	
	/**
	 * TODO 
	 * */
	public static int issueLeave(LeaveModel leave) {
		int status = 0;
		conn = Databases.connect();
		String sql = "INSERT INTO tbl_leave(l_reasons, l_datefrom, l_dateto, l_type, l_status, e_id) "
					+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, leave.getReasons());
			pstmt.setString(2, leave.getDate_from());
			pstmt.setString(3, leave.getDate_to());
			pstmt.setString(4, leave.getLeave_type());
			pstmt.setString(5, leave.getStatus());
			pstmt.setInt(6, leave.getE_id());
			
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
	
	public static int issueLoan(LoanModel loan) {
		int status = 0;
		conn = Databases.connect();
		String sql = "INSERT INTO tbl_loan(loan_reasons, loan_amount, loan_issuedate, loan_status, e_id)\r\n"
					+ "VALUES(?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loan.getReasons());
			pstmt.setDouble(2, loan.getLoan_amount());
			pstmt.setDate(3, loan.getIssued_date());
			pstmt.setString(4, loan.getLoan_status());
			pstmt.setInt(5, loan.getE_id());
			
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
