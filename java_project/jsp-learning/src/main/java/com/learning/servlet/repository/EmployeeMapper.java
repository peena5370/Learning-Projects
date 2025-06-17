package com.learning.servlet.repository;

import com.learning.servlet.config.DatabaseConnection;
import com.learning.servlet.model.EmployeeModel;
import com.learning.servlet.model.LeaveModel;
import com.learning.servlet.model.LoanModel;
import com.learning.servlet.model.MonthlySalaryModel;
import com.learning.servlet.model.TrainingModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {

    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;

    public static List<EmployeeModel> getAllEmployees() {
        List<EmployeeModel> employeeList = new ArrayList<>();
        try {
            String sql = "SELECT e_id, e_fullname, e_position, e_department, e_phone, e_email, e_startdate, e_enddate "
                    + "FROM tbl_employee ORDER BY e_id";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                EmployeeModel employee = new EmployeeModel();

                employee.setId(rs.getInt("e_id"));
                employee.setFullname(rs.getString("e_fullname"));
                employee.setPosition(rs.getString("e_position"));
                employee.setDepartment(rs.getString("e_department"));
                employee.setPhone(rs.getString("e_phone"));
                employee.setEmail(rs.getString("e_email"));
                employee.setStartdate(rs.getString("e_startdate"));
                employee.setEnddate(rs.getString("e_enddate"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("error when retrieving employee list: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }
        return employeeList;
    }

    public static int createEmployee(EmployeeModel employee) {
        int status = 0;

        try {
            String sql = "INSERT INTO tbl_employee(e_fullname, e_authpassword, e_authkey, e_position, e_department, e_phone, e_email, e_startdate)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, employee.getFullname());
            stmt.setString(2, employee.getPassword());
            stmt.setString(3, employee.getKey());
            stmt.setString(4, employee.getPosition());
            stmt.setString(5, employee.getDepartment());
            stmt.setString(6, employee.getPhone());
            stmt.setString(7, employee.getEmail());
            stmt.setString(8, employee.getStartdate());

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when inserting employee info: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }

        return status;
    }

    public static int deleteEmployee(int id) {
        int status = 0;

        try {
            String sql = "DELETE FROM tbl_employee WHERE e_id=?";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when deleting employee: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }

        return status;
    }

    public static int updateEmployee(EmployeeModel employee) {
        int status = 0;

        try {
            String sql = "UPDATE tbl_employee SET e_fullname=?, e_position=?, e_department=?, e_phone=?, e_email=?"
                    + " WHERE e_id=?";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, employee.getFullname());
            stmt.setString(2, employee.getPosition());
            stmt.setString(3, employee.getDepartment());
            stmt.setString(4, employee.getPhone());
            stmt.setString(5, employee.getEmail());
            stmt.setInt(6, employee.getId());

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when updating employee info: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }

        return status;
    }

    public static int addBaseSalary(EmployeeModel employee) {
        int status = 0;

        try {
            String sql = "INSERT INTO tbl_employeesalary(base_salary, e_id) "
                    + "VALUES(?, (SELECT e_id FROM tbl_employee "
                    + "WHERE e_fullname=?))";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, employee.getBase_salary());
            stmt.setString(2, employee.getFullname());

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when inserting employee salary: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }
        return status;
    }

    public static EmployeeModel queryInfo(int id) {
        EmployeeModel employee = new EmployeeModel();

        try {
            String sql = "SELECT e_id, e_fullname, e_position, e_department, e_phone, e_email, e_startdate "
                    + "FROM tbl_employee WHERE e_id=?";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                employee.setId(rs.getInt("e_id"));
                employee.setFullname(rs.getString("e_fullname"));
                employee.setPosition(rs.getString("e_position"));
                employee.setDepartment(rs.getString("e_department"));
                employee.setPhone(rs.getString("e_phone"));
                employee.setEmail(rs.getString("e_email"));
                employee.setStartdate(rs.getString("e_startdate"));
            }
        } catch (SQLException e) {
            System.out.println("error when retrieving employee info: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }
        return employee;
    }

    public static EmployeeModel queryPassword(int id) {
        EmployeeModel employee = new EmployeeModel();

        try {
            String sql = "SELECT e_authpassword, e_authkey FROM tbl_employee WHERE e_id=?";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                employee.setPassword(rs.getString(1));
                employee.setKey(rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("error when retrieving employee password: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }
        return employee;
    }

    public static int updatePassword(EmployeeModel employee) {
        int status = 0;

        try {
            String sql = "UPDATE tbl_employee SET e_authpassword=?, e_authkey=? WHERE e_id=?";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, employee.getPassword());
            stmt.setString(2, employee.getKey());
            stmt.setInt(3, employee.getId());

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when updating employee password: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }

        return status;
    }

    public static List<LeaveModel> viewLeave(int id) {
        List<LeaveModel> leaveList = new ArrayList<>();

        try {
            String sql = "SELECT l_reasons, l_datefrom, l_dateto, l_type, l_status, tbl_manager.m_fullname AS managername "
                    + "FROM tbl_leave "
                    + "LEFT JOIN tbl_manager ON tbl_manager.m_id = tbl_leave.m_id WHERE e_id=?";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                LeaveModel leave = new LeaveModel();
                leave.setReasons(rs.getString("l_reasons"));
                leave.setDate_from(rs.getString("l_datefrom"));
                leave.setDate_to(rs.getString("l_dateto"));
                leave.setLeave_type(rs.getString("l_type"));
                leave.setStatus(rs.getString("l_status"));
                leave.setApprovedByManager(rs.getString("managername"));

                leaveList.add(leave);
            }
        } catch (SQLException e) {
            System.out.println("error when retrieving employee leave list: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }
        return leaveList;
    }

    public static List<TrainingModel> viewTraining(int id) {
        List<TrainingModel> trainingList = new ArrayList<>();

        try {
            String sql = "SELECT t_id, t_info, t_startdate, t_enddate, t_status, tbl_manager.m_fullname AS managername "
                    + "FROM tbl_training "
                    + "LEFT JOIN tbl_manager ON tbl_manager.m_id = tbl_training.m_id "
                    + "where e_id=?";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                TrainingModel training = new TrainingModel();
                training.setT_id(rs.getInt("t_id"));
                training.setInfo(rs.getString("t_info"));
                training.setStartdate(rs.getDate("t_startdate"));
                training.setEnddate(rs.getDate("t_enddate"));
                training.setStatus(rs.getString("t_status"));
                training.setIssuedByManager(rs.getString("managername"));

                trainingList.add(training);
            }
        } catch (SQLException e) {
            System.out.println("error when retrieving employee training list: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }

        return trainingList;
    }

    public static int updateTraining(String t_status, int id, int t_id) {
        int status = 0;

        try {
            String sql = "UPDATE tbl_training SET t_status=? WHERE e_id=? AND t_id=?";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, t_status);
            stmt.setInt(2, id);
            stmt.setInt(3, t_id);

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when updating employee training: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }
        return status;
    }

    public static List<MonthlySalaryModel> viewSalary(int id) {
        List<MonthlySalaryModel> salaryList = new ArrayList<>();

        try {
            String sql = "SELECT mp_id, mp_currentsalary, mp_overtimepay, mp_deductedsalary, mp_totalpay, mp_paymentdate, tbl_manager.m_fullname AS managername "
                    + "FROM tbl_monthlypay LEFT JOIN tbl_manager ON tbl_manager.m_id = tbl_monthlypay.m_id "
                    + "WHERE e_id=?";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                MonthlySalaryModel salary = new MonthlySalaryModel();
                salary.setMonthlysalary_id(rs.getInt("mp_id"));
                salary.setCurrent_salary(rs.getDouble("mp_currentsalary"));
                salary.setOvertime_pay(rs.getDouble("mp_overtimepay"));
                salary.setDeduction(rs.getDouble("mp_deductedsalary"));
                salary.setTotal_salary(rs.getDouble("mp_totalpay"));
                salary.setPayment_date(rs.getDate("mp_paymentdate"));
                salary.setApprovedByManager(rs.getString("managername"));

                salaryList.add(salary);
            }
        } catch (SQLException e) {
            System.out.println("error when retrieving employee salary list: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }
        return salaryList;
    }

    public static int issueLeave(LeaveModel leave) {
        int status = 0;

        try {
            String sql = "INSERT INTO tbl_leave(l_reasons, l_datefrom, l_dateto, l_type, l_status, e_id) "
                    + "VALUES(?, ?, ?, ?, ?, ?)";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, leave.getReasons());
            stmt.setString(2, leave.getDate_from());
            stmt.setString(3, leave.getDate_to());
            stmt.setString(4, leave.getLeave_type());
            stmt.setString(5, leave.getStatus());
            stmt.setInt(6, leave.getE_id());

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when issuing employee leave: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }
        return status;
    }

    public static int issueLoan(LoanModel loan) {
        int status = 0;

        try {
            String sql = "INSERT INTO tbl_loan(loan_reasons, loan_amount, loan_issuedate, loan_status, e_id) "
                    + "VALUES(?, ?, ?, ?, ?)";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, loan.getReasons());
            stmt.setDouble(2, loan.getLoan_amount());
            stmt.setDate(3, loan.getIssued_date());
            stmt.setString(4, loan.getLoan_status());
            stmt.setInt(5, loan.getE_id());

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when issuing employee load: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }

        return status;
    }
}
