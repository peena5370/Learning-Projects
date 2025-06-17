package com.learning.servlet.repository;

import com.learning.servlet.config.DatabaseConnection;
import com.learning.servlet.model.LeaveModel;
import com.learning.servlet.model.LoanModel;
import com.learning.servlet.model.ManagerModel;
import com.learning.servlet.model.MonthlySalaryModel;
import com.learning.servlet.model.ResignationModel;
import com.learning.servlet.model.SalaryModel;
import com.learning.servlet.model.TrainingModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerMapper {

    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;

    private ManagerMapper() {
    }

    public static int createManager(ManagerModel manager) {
        int status = 0;

        try {
            String sql = "INSERT INTO tbl_manager(m_fullname, m_authpassword, m_authkey, m_role, m_position, m_department, m_phone, m_email)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, manager.getFullname());
            stmt.setString(2, manager.getPassword());
            stmt.setString(3, manager.getKey());
            stmt.setString(4, manager.getRole());
            stmt.setString(5, manager.getPosition());
            stmt.setString(6, manager.getDepartment());
            stmt.setString(7, manager.getPhone());
            stmt.setString(8, manager.getEmail());

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when creating manager: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }
        return status;
    }

    public static List<ManagerModel> getAllManagers() {
        List<ManagerModel> managerList = new ArrayList<>();

        try {
            String sql = "SELECT m_id, m_fullname, m_role, m_position, m_department, m_phone, m_email "
                    + "FROM tbl_manager ORDER BY m_id";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ManagerModel manager = new ManagerModel();

                manager.setId(rs.getInt("m_id"));
                manager.setFullname(rs.getString("m_fullname"));
                manager.setRole(rs.getString("m_role"));
                manager.setPosition(rs.getString("m_position"));
                manager.setDepartment(rs.getString("m_department"));
                manager.setPhone(rs.getString("m_phone"));
                manager.setEmail(rs.getString("m_email"));

                managerList.add(manager);
            }
        } catch (SQLException e) {
            System.out.println("error when getting manager list: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }
        return managerList;
    }

    public static int updateManager(ManagerModel manager) {
        int status = 0;

        try {
            String sql = "UPDATE tbl_manager SET m_role=?, m_fullname=?, m_position=?, m_department=?, m_phone=?, m_email=?"
                    + " WHERE m_id=?";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, manager.getRole());
            stmt.setString(2, manager.getFullname());
            stmt.setString(3, manager.getPosition());
            stmt.setString(4, manager.getDepartment());
            stmt.setString(5, manager.getPhone());
            stmt.setString(6, manager.getEmail());
            stmt.setInt(7, manager.getId());

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when updating manager: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }

        return status;
    }

    public static int deleteManager(int id) {
        int status = 0;

        try {
            String sql = "DELETE FROM tbl_manager WHERE m_id=?";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when deleting manager: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }
        return status;
    }

    public static ManagerModel getManagerFullName(int id) {
        ManagerModel manager = new ManagerModel();

        try {
            String sql = "SELECT m_fullname FROM tbl_manager WHERE m_id=?";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                manager.setFullname(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("error when retrieving manager fullname: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }
        return manager;
    }

    public static List<SalaryModel> viewEmployeeSalary() {
        List<SalaryModel> salaryList = new ArrayList<>();

        try {
            String sql = "SELECT s_id, base_salary, incremented_salary, increment_date, tbl_employee.e_fullname AS employeename, "
                    + "tbl_manager.m_fullname AS managername FROM tbl_employeesalary "
                    + "INNER JOIN tbl_employee ON tbl_employee.e_id = tbl_employeesalary.e_id "
                    + "LEFT JOIN tbl_manager ON tbl_manager.m_id = tbl_employeesalary.m_id "
                    + "ORDER BY s_id";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                SalaryModel salary = new SalaryModel();
                salary.setS_id(rs.getInt("s_id"));
                salary.setBase_salary(rs.getDouble("base_salary"));
                salary.setIncremented_salary(rs.getDouble("incremented_salary"));
                salary.setIncrement_date(rs.getString("increment_date"));
                salary.setEmployee_name(rs.getString("employeename"));
                salary.setIssuedByManager(rs.getString("managername"));

                salaryList.add(salary);
            }

        } catch (SQLException e) {
            System.out.println("error when retrieving employee salary: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }

        return salaryList;
    }

    public static List<MonthlySalaryModel> viewMonthlySalary() {
        List<MonthlySalaryModel> monthlySalaryList = new ArrayList<>();

        try {
            String sql = "SELECT mp_id, mp_currentsalary, mp_overtimepay, mp_deductedsalary, mp_totalpay, "
                    + "tbl_employee.e_fullname AS employeename, tbl_manager.m_fullname AS managername, "
                    + "mp_paymentdate FROM tbl_monthlypay "
                    + "INNER JOIN tbl_employee ON tbl_employee.e_id = tbl_monthlypay.e_id "
                    + "INNER JOIN tbl_manager ON tbl_manager.m_id = tbl_monthlypay.m_id "
                    + "ORDER BY mp_id";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                MonthlySalaryModel monthlySalary = new MonthlySalaryModel();
                monthlySalary.setMonthlysalary_id(rs.getInt("mp_id"));
                monthlySalary.setCurrent_salary(rs.getDouble("mp_currentsalary"));
                monthlySalary.setOvertime_pay(rs.getDouble("mp_overtimepay"));
                monthlySalary.setDeduction(rs.getDouble("mp_deductedsalary"));
                monthlySalary.setTotal_salary(rs.getDouble("mp_totalpay"));
                monthlySalary.setEmployee_name(rs.getString("employeename"));
                monthlySalary.setApprovedByManager(rs.getString("managername"));
                monthlySalary.setPayment_date(rs.getDate("mp_paymentdate"));

                monthlySalaryList.add(monthlySalary);
            }
        } catch (SQLException e) {
            System.out.println("error when retrieving monthly salary: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }

        return monthlySalaryList;
    }

    public static List<LoanModel> viewLoan() {
        List<LoanModel> loanList = new ArrayList<>();

        try {
            String sql = "SELECT loan_id, loan_reasons, loan_amount, loan_issuedate, loan_status, "
                    + "tbl_employee.e_fullname AS employeename, tbl_manager.m_fullname AS approvedby "
                    + "FROM tbl_loan INNER JOIN tbl_employee ON tbl_employee.e_id = tbl_loan.e_id "
                    + "LEFT JOIN tbl_manager ON tbl_manager.m_id = tbl_loan.m_id "
                    + "ORDER BY loan_id;";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                LoanModel loan = new LoanModel();
                loan.setLoan_id(rs.getInt("loan_id"));
                loan.setReasons(rs.getString("loan_reasons"));
                loan.setLoan_amount(rs.getDouble("loan_amount"));
                loan.setIssued_date(rs.getDate("loan_issuedate"));
                loan.setLoan_status(rs.getString("loan_status"));
                loan.setEmployee_name(rs.getString("employeename"));
                loan.setApprovedByManager(rs.getString("approvedby"));

                loanList.add(loan);
            }
        } catch (SQLException e) {
            System.out.println("error when retrieving loan list: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }
        return loanList;
    }

    public static int updateLoanStatus(int id, String loanStatus, int mId) {
        int status = 0;

        try {
            String sql = "UPDATE tbl_loan SET loan_status=?, m_id=? WHERE loan_id=?";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, loanStatus);
            stmt.setInt(2, mId);
            stmt.setInt(3, id);

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when updating loan status: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }

        return status;
    }

    public static int issueSalary(MonthlySalaryModel monthlysalarymodel) {
        int status = 0;

        try {
            String sql = "INSERT INTO tbl_monthlypay(mp_currentsalary, mp_overtimepay, mp_deductedsalary, mp_totalpay, e_id, m_id, mp_paymentdate) "
                    + "VALUES(?, ?, ?, ?, (SELECT e_id FROM tbl_employee WHERE e_fullname=?), "
                    + "(SELECT m_id FROM tbl_manager WHERE m_fullname=?), ?)";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, monthlysalarymodel.getCurrent_salary());
            stmt.setDouble(2, monthlysalarymodel.getOvertime_pay());
            stmt.setDouble(3, monthlysalarymodel.getDeduction());
            stmt.setDouble(4, monthlysalarymodel.getTotal_salary());
            stmt.setString(5, monthlysalarymodel.getEmployee_name());
            stmt.setString(6, monthlysalarymodel.getApprovedByManager());
            stmt.setDate(7, monthlysalarymodel.getPayment_date());

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when issuing salary: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }

        return status;
    }

    public static List<LeaveModel> viewLeave() {
        List<LeaveModel> leaveList = new ArrayList<>();

        try {
            String sql = "SELECT l_id, l_reasons, l_datefrom, l_dateto, l_type, l_status, tbl_employee.e_fullname AS employeename, "
                    + "tbl_manager.m_fullname AS managername  FROM tbl_leave "
                    + "INNER JOIN tbl_employee ON tbl_employee.e_id = tbl_leave.e_id "
                    + "LEFT JOIN tbl_manager ON tbl_manager.m_id = tbl_leave.m_id "
                    + "ORDER BY l_id;";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                LeaveModel leave = new LeaveModel();
                leave.setL_id(rs.getInt("l_id"));
                leave.setReasons(rs.getString("l_reasons"));
                leave.setDate_from(rs.getString("l_datefrom"));
                leave.setDate_to(rs.getString("l_dateto"));
                leave.setLeave_type(rs.getString("l_type"));
                leave.setStatus(rs.getString("l_status"));
                leave.setEmployee_name(rs.getString("employeename"));
                leave.setApprovedByManager(rs.getString("managername"));

                leaveList.add(leave);
            }
        } catch (SQLException e) {
            System.out.println("error when view leave list:" + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }

        return leaveList;
    }

    public static int updateLeaveStatus(int id, String leaveStatus, int mId) {
        int status = 0;

        try {
            String sql = "UPDATE tbl_leave SET l_status=?, m_id=? WHERE l_id=?";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, leaveStatus);
            stmt.setInt(2, mId);
            stmt.setInt(3, id);

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when updating leave status: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }

        return status;
    }

    public static List<TrainingModel> viewTraining() {
        List<TrainingModel> trainingList = new ArrayList<>();

        try {
            String sql = "SELECT t_id, t_info, t_startdate, t_enddate, t_status, tbl_employee.e_fullname AS employeename, "
                    + "tbl_manager.m_fullname AS managername FROM tbl_training "
                    + "INNER JOIN tbl_employee ON tbl_employee.e_id = tbl_training.e_id "
                    + "INNER JOIN tbl_manager ON tbl_manager.m_id = tbl_training.m_id "
                    + "ORDER BY t_id;";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                TrainingModel training = new TrainingModel();

                training.setT_id(rs.getInt("t_id"));
                training.setInfo(rs.getString("t_info"));
                training.setStartdate(rs.getDate("t_startdate"));
                training.setEnddate(rs.getDate("t_enddate"));
                training.setStatus(rs.getString("t_status"));
                training.setEmployee_name(rs.getString("employeename"));
                training.setIssuedByManager(rs.getString("managername"));

                trainingList.add(training);
            }
        } catch (SQLException e) {
            System.out.println("error when retrieving training list: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }

        return trainingList;
    }

    public static int issueTraining(TrainingModel trainingmodel) {
        int status = 0;

        try {
            String sql = "INSERT INTO tbl_training(t_info, t_startdate, t_enddate, t_status, e_id, m_id) "
                    + "VALUES(?, ?, ?, ?, (SELECT e_id FROM tbl_employee WHERE e_fullname=?), "
                    + "(SELECT m_id FROM tbl_manager WHERE m_fullname=?));";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, trainingmodel.getInfo());
            stmt.setDate(2, trainingmodel.getStartdate());
            stmt.setDate(3, trainingmodel.getEnddate());
            stmt.setString(4, trainingmodel.getStatus());
            stmt.setString(5, trainingmodel.getEmployee_name());
            stmt.setString(6, trainingmodel.getIssuedByManager());

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when issuing training: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }
        return status;
    }

    public static int issueIncrement(SalaryModel salary) {
        int status = 0;

        try {
            String sql = "UPDATE tbl_employeesalary "
                    + "INNER JOIN tbl_employee ON tbl_employee.e_id = tbl_employeesalary.e_id "
                    + "SET incremented_salary=?, increment_date=?, "
                    + "tbl_employeesalary.m_id = (SELECT m_id FROM tbl_manager WHERE tbl_manager.m_fullname=?) "
                    + "WHERE tbl_employee.e_fullname=?";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, salary.getIncremented_salary());
            stmt.setString(2, salary.getIncrement_date());
            stmt.setString(3, salary.getIssuedByManager());
            stmt.setString(4, salary.getEmployee_name());

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when issuing increment: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }

        return status;
    }

    public static List<ResignationModel> viewResignation() {
        List<ResignationModel> resignList = new ArrayList<>();

        try {
            String sql = "SELECT r_id, r_reasons, r_date, tbl_employee.e_fullname AS employeename, tbl_manager.m_fullname AS managername "
                    + "FROM tbl_resignation "
                    + "INNER JOIN tbl_employee ON tbl_employee.e_id=tbl_resignation.e_id "
                    + "INNER JOIN tbl_manager ON tbl_manager.m_id=tbl_resignation.m_id "
                    + "ORDER BY r_id";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                ResignationModel resign = new ResignationModel();
                resign.setR_id(rs.getInt(1));
                resign.setReasons(rs.getString(2));
                resign.setEnddate(rs.getDate(3));
                resign.setEmployee_name(rs.getString(4));
                resign.setIssuedByManager(rs.getString(5));

                resignList.add(resign);
            }
        } catch (SQLException e) {
            System.out.println("error when retrieving resign list: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }

        return resignList;
    }

    public static int issueResignation(ResignationModel resign) {
        int status = 0;

        try {
            String sql = "INSERT INTO tbl_resignation(r_reasons, r_date, e_id, m_id) "
                    + "VALUES(?, ?, (SELECT e_id FROM tbl_employee WHERE e_fullname=?), "
                    + "(SELECT m_id FROM tbl_manager WHERE m_fullname=?))";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, resign.getReasons());
            stmt.setDate(2, resign.getEnddate());
            stmt.setString(3, resign.getEmployee_name());
            stmt.setString(4, resign.getIssuedByManager());

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when issuing resignation: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }
        return status;
    }

    public static int insertResignDate(String date, String name) {
        int status = 0;

        try {
            String sql = "UPDATE tbl_employee SET e_enddate=? WHERE e_fullname=? AND e_id > 0";

            conn = DatabaseConnection.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, date);
            stmt.setString(2, name);

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error when inserting resign information: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(stmt, conn);
        }
        return status;
    }
}
