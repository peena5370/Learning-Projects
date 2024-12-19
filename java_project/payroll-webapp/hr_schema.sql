CREATE DATABASE `hr_schema`;

-- ----------------------------
-- Table structure for tbl_account
-- ----------------------------
DROP TABLE IF EXISTS `tbl_account`;
CREATE TABLE `tbl_account` (
  `a_id` INT NOT NULL AUTO_INCREMENT,
  `a_username` CHAR(20) NOT NULL UNIQUE,
  `a_password` CHAR(44) NOT NULL,
  `a_key` CHAR(30) NOT NULL,
  `a_created` DATETIME NOT NULL,
  `a_changed` DATETIME NULL,
  PRIMARY KEY(a_id)
) ENGINE=InnoDB AUTO_INCREMENT=12;

-- ----------------------------
-- Table structure for tbl_department
-- ----------------------------
DROP TABLE IF EXISTS `tbl_department`;
CREATE TABLE `tbl_department` (
  `d_id` INT NOT NULL AUTO_INCREMENT,
  `d_departmentname` VARCHAR(50) NULL,
  `d_location` VARCHAR(100) NULL,
  `d_state` VARCHAR(30) NULL,
  `d_country` VARCHAR(30) NULL,
  PRIMARY KEY(d_id)
) ENGINE=InnoDB AUTO_INCREMENT=9;

-- ----------------------------
-- Table structure for tbl_title
-- ----------------------------
DROP TABLE IF EXISTS `tbl_title`;
CREATE TABLE `tbl_title` (
  `t_id` INT NOT NULL AUTO_INCREMENT,
  `t_titlename` VARCHAR(80) NOT NULL UNIQUE,
  PRIMARY KEY(t_id)
) ENGINE=InnoDB AUTO_INCREMENT=29;

-- ----------------------------
-- Table structure for tbl_manager
-- ----------------------------
DROP TABLE IF EXISTS `tbl_manager`;
CREATE TABLE `tbl_manager` (
  `m_id` INT NOT NULL AUTO_INCREMENT,
  `m_fullname` VARCHAR(80) NOT NULL,
  `m_role` ENUM('Administrator', 'Manager') NOT NULL,
  `m_gender` ENUM('MALE', 'FEMALE', 'OTHER') NULL,
  `m_age` INT NULL,
  `m_martialstatus` ENUM('SINGLE', 'MARRIED') NULL,
  `m_educationlevel` VARCHAR(30) NULL,
  `m_address` VARCHAR(100) NULL,
  `m_state` VARCHAR(30) NULL,
  `m_country` VARCHAR(30) NULL,
  `m_phone` VARCHAR(15) NULL,
  `m_email` VARCHAR(50) NULL,
  `m_datehired` DATE NULL,
  `m_datequit` DATE NULL,
  `a_id` INT NULL UNIQUE,
  `d_id` INT NULL,
  `t_id` INT NULL,
  PRIMARY KEY(m_id),
  FOREIGN KEY(a_id) REFERENCES tbl_account(a_id),
  FOREIGN KEY(d_id) REFERENCES tbl_department(d_id),
  FOREIGN KEY(t_id) REFERENCES tbl_title(t_id)
) ENGINE=InnoDB AUTO_INCREMENT=7;

-- ----------------------------
-- Table structure for tbl_employee
-- ----------------------------
DROP TABLE IF EXISTS `tbl_employee`;
CREATE TABLE `tbl_employee` (
  `e_id` INT NOT NULL AUTO_INCREMENT,
  `e_fullname` VARCHAR(80) NOT NULL,
  `e_gender` ENUM('MALE', 'FEMALE', 'OTHER') NULL,
  `e_age` INT NULL,
  `e_martialstatus` ENUM('SINGLE', 'MARRIED') NULL,
  `e_educationlevel` VARCHAR(30) NULL,
  `e_address` VARCHAR(100) NULL,
  `e_state` VARCHAR(30) NULL,
  `e_country` VARCHAR(30) NULL,
  `e_phone` VARCHAR(15) NULL,
  `e_email` VARCHAR(50) NULL,
  `e_datehired` DATE NULL,
  `e_datequit` DATE NULL,
  `a_id` INT NULL UNIQUE,
  `d_id` INT NULL,
  `m_id` INT NULL,
  `t_id` INT NULL,
  PRIMARY KEY(e_id),
  FOREIGN KEY(a_id) REFERENCES tbl_account(a_id),
  FOREIGN KEY(d_id) REFERENCES tbl_department(d_id),
  FOREIGN KEY(m_id) REFERENCES tbl_manager(m_id),
  FOREIGN KEY(t_id) REFERENCES tbl_title(t_id)
) ENGINE=InnoDB AUTO_INCREMENT=6;

-- ----------------------------
-- Table structure for tbl_employeesalary
-- ----------------------------
DROP TABLE IF EXISTS `tbl_employeesalary`;
CREATE TABLE `tbl_employeesalary` (
  `s_id` INT NOT NULL AUTO_INCREMENT,
  `monthly_salary` DECIMAL(10, 2) NOT NULL,
  `annual_salary` DECIMAL(10,2) NULL,
  `e_id` INT NULL UNIQUE,
  PRIMARY KEY(s_id),
  FOREIGN KEY(e_id) REFERENCES tbl_employee(e_id) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4;

-- ----------------------------
-- Table structure for tbl_employeepromotion
-- ----------------------------
DROP TABLE IF EXISTS `tbl_employeepromotion`;
CREATE TABLE `tbl_employeepromotion` (
  `p_id` INT NOT NULL AUTO_INCREMENT,
  `previoussalary` DECIMAL(10,2) NULL,
  `promotesalary` DECIMAL(10,2) NULL,
  `promotedate` DATE NULL,
  `t_id` INT NULL,
  `e_id` INT NULL,
  `m_id` INT NULL,
  PRIMARY KEY(p_id),
  FOREIGN KEY(t_id) REFERENCES tbl_title(t_id),
  FOREIGN KEY(e_id) REFERENCES tbl_employee(e_id),
  FOREIGN KEY(m_id) REFERENCES tbl_manager(m_id)
) ENGINE=InnoDB AUTO_INCREMENT=4;

-- ----------------------------
-- Table structure for tbl_training
-- ----------------------------
DROP TABLE IF EXISTS `tbl_training`;
CREATE TABLE `tbl_training` (
  `training_id` INT NOT NULL AUTO_INCREMENT,
  `info` VARCHAR(255) NULL,
  `startdate` DATETIME NULL,
  `enddate` DATETIME NULL,
  `status` ENUM('PENDING', 'COMPLETED') NULL,
  `e_id` INT NULL,
  `m_id` INT NULL,
  PRIMARY KEY(t_id),
  FOREIGN KEY(e_id) REFERENCES tbl_employee(e_id),
  FOREIGN KEY(m_id) REFERENCES tbl_manager(m_id)
) ENGINE=InnoDB AUTO_INCREMENT=4;

-- ----------------------------
-- Table structure for tbl_employeeleave
-- ----------------------------
DROP TABLE IF EXISTS `tbl_employeeleave`;
CREATE TABLE `tbl_employeeleave` (
  `l_id` INT NOT NULL AUTO_INCREMENT,
  `l_reasons` VARCHAR(255) NULL,
  `l_datefrom` DATETIME NULL,
  `l_dateto` DATETIME NULL,
  `l_type` VARCHAR(20) NULL,
  `l_status` ENUM('APPROVED', 'PENDING', 'REJECTED') NULL,
  `e_id` INT NULL,
  `m_id` INT NULL,
  PRIMARY KEY(l_id),
  FOREIGN KEY(e_id) REFERENCES tbl_employee(e_id),
  FOREIGN KEY(m_id) REFERENCES tbl_manager(m_id)
) ENGINE=InnoDB AUTO_INCREMENT=4;

-- ----------------------------
-- Table structure for tbl_employeeloan
-- ----------------------------
DROP TABLE IF EXISTS `tbl_employeeloan`;
CREATE TABLE `tbl_employeeloan` (
  `loan_id` INT NOT NULL AUTO_INCREMENT,
  `reasons` VARCHAR(255) NULL,
  `amount` DECIMAL(6,2) NULL,
  `issuedate` DATE NULL,
  `status` ENUM('APPROVED', 'PENDING', 'REJECTED') NULL,
  `e_id` INT NULL,
  `m_id` INT NULL,
  PRIMARY KEY(loan_id),
  FOREIGN KEY(e_id) REFERENCES tbl_employee(e_id),
  FOREIGN KEY(m_id) REFERENCES tbl_manager(m_id)
) ENGINE=InnoDB AUTO_INCREMENT=2;

-- ----------------------------
-- Table structure for tbl_resignation
-- ----------------------------
DROP TABLE IF EXISTS `tbl_resignation`;
CREATE TABLE `tbl_resignation` (
  `r_id` INT NOT NULL AUTO_INCREMENT,
  `reasons` VARCHAR(255) NULL,
  `r_date` DATE NULL,
  `e_id` INT NULL,
  `m_id` INT NULL,
  PRIMARY KEY(r_id),
  FOREIGN KEY(e_id) REFERENCES tbl_employee(e_id),
  FOREIGN KEY(m_id) REFERENCES tbl_manager(m_id)
) ENGINE=InnoDB AUTO_INCREMENT=2;

-- ----------------------------
-- Table structure for tbl_payroll
-- ----------------------------
DROP TABLE IF EXISTS `tbl_payroll`;
CREATE TABLE `tbl_payroll` (
  `pr_id` INT NOT NULL AUTO_INCREMENT,
  `totalamount` DECIMAL(10,2) NULL,
  `overtimepay` DECIMAL(8,2) NULL,
  `deduction` DECIMAL(8,2) NULL,
  `issuedate` DATE NULL,
  `basesalary` DECIMAL(10,2) NULL,
  `e_id` INT NULL,
  `m_id` INT NULL,
  PRIMARY KEY(pr_id),
  FOREIGN KEY(e_id) REFERENCES tbl_employee(e_id),
  FOREIGN KEY(m_id) REFERENCES tbl_manager(m_id)
) ENGINE=InnoDB AUTO_INCREMENT=13;