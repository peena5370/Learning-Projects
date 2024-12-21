CREATE DATABASE humanresource;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `a_id` INT NOT NULL AUTO_INCREMENT,
  `a_username` CHAR(32) NOT NULL UNIQUE,
  `a_authpassword` CHAR(64) NOT NULL,
  `a_authkey` CHAR(32) NOT NULL,
  `a_role` CHAR(15) NOT NULL,
  PRIMARY KEY(a_id)
) ENGINE=InnoDB AUTO_INCREMENT=2;

-- ----------------------------
-- Records of admin
-- pass: A3qvbJAiIxDGH6qrHxkG6NXCJ2sdrSdrsfTmLW3L6ws=
-- salt: gEr3dLLuLpV5RIrJmMLAqJNTjCdInW
-- plain pass: Admin@1234
-- ----------------------------
INSERT INTO `admin` VALUES(10001, 'administrator', 'A3qvbJAiIxDGH6qrHxkG6NXCJ2sdrSdrsfTmLW3L6ws=', 'gEr3dLLuLpV5RIrJmMLAqJNTjCdInW', 'admin');

-- ----------------------------
-- Table structure for tbl_manager
-- ----------------------------
DROP TABLE IF EXISTS `tbl_manager`;
CREATE TABLE `tbl_manager` (
  `m_id` INT NOT NULL AUTO_INCREMENT,
  `m_authpassword` CHAR(64) NOT NULL,
  `m_authkey` CHAR(32) NOT NULL,
  `m_fullname` VARCHAR(100) NOT NULL,
  `m_role` CHAR(15) NOT NULL,
  `m_position` VARCHAR(100) NULL,
  `m_department` VARCHAR(20) NULL,
  `m_phone` VARCHAR(12) NULL,
  `m_email` VARCHAR(80) NULL,
  PRIMARY KEY(m_id)
) ENGINE=InnoDB AUTO_INCREMENT=6;

-- ----------------------------
-- Records of tbl_manager
-- pass: AnrVFu83GHZDjp1HTWs5quM+dhkj7TWfLLa/iO7DrSg=
-- salt: 6ECRm5sV9m9hQxbF0Q8xcP4jPzCj4C
-- plain pass: Manager@1234
-- username: 2022540
-- ----------------------------
INSERT INTO `tbl_manager` VALUES(2022540, 'YUQZ2ADeZz8gjHKIvX/tK8kdAmHt2CZa1YLZlCXkH4U=', 'De3ag71pO4I4Mjh1AYLTOzzvWtpLZG', 'Khor Ming Guan', 'manager', 'HR Manager', 'HR', '017-5412585', 'john68@company.com');
INSERT INTO `tbl_manager` VALUES(2022341, '6fQf2S1Qwm0L919TWFQK4ssp0j9yCSt6edvQAZugFCM=', 'GppW7GhjTIZiK9LtFTCJB7nERAaep3', 'Jeniffer Loh Hui Shan', 'manager', 'IT Manager', 'IT', '019-5386985', 'jeniffer_loh@company.com');
INSERT INTO `tbl_manager` VALUES(2032541, 'TRkcz7ETpa8lu4X4mgXM+JXHDmaVgs6gNZg6IQb3/Q8=', 'SI4faV7K8ca9SqfbxIW9opVb3nKq4y', 'Adele Chuah Hui Rou', 'manager', 'Finance Manager', 'Finance', '014-7965412', 'adele_chuah@company.com');
INSERT INTO `tbl_manager` VALUES(2026538, 'POlBFPHne1yhB0pvLHE3HWNTPaoDIPqf6qdcQciIlQM=', 'a3bInVJN1IyBfEXwLgdRAhm5ylGtvZ', 'Sivakumar A/L Surumugan', 'manager', 'Warehouse Manager', 'Warehouse', '019-5112139', 'sivakumar82@company.com');
INSERT INTO `tbl_manager` VALUES(2015426, 'AnrVFu83GHZDjp1HTWs5quM+dhkj7TWfLLa/iO7DrSg=', '6ECRm5sV9m9hQxbF0Q8xcP4jPzCj4C', 'Muhamad Azmi bin Qaafar', 'manager', 'Production Manager', 'Production', '016-8541725', 'muhamad_azmi@company.com');

-- ----------------------------
-- Table structure for tbl_employee
-- ----------------------------
DROP TABLE IF EXISTS `tbl_employee`;
CREATE TABLE `tbl_employee` (
  `e_id` INT NOT NULL AUTO_INCREMENT,
  `e_authpassword` CHAR(64) NOT NULL,
  `e_authkey` CHAR(32) NOT NULL,
  `e_fullname` VARCHAR(100) NOT NULL,
  `e_position` VARCHAR(100) NULL,
  `e_department` VARCHAR(20) NULL,
  `e_phone` VARCHAR(12) NULL,
  `e_email` VARCHAR(80) NULL,
  `e_startdate` DATETIME NULL,
  `e_enddate` DATETIME NULL,
  PRIMARY KEY(e_id)
) ENGINE=InnoDB AUTO_INCREMENT=5;

-- ----------------------------
-- Records of tbl_employee
-- pass: 0Njk9+U8ddjjerdveJYsavQYbyxbVWirKgNAGfSf5HQ=
-- salt: HQhFGAv7qOP4vkrZVo2KLghzWJOsNd
-- plain pass: Employee@5678
-- username: 1025411
-- ----------------------------
INSERT INTO `tbl_employee` VALUES(1025411, '0Njk9+U8ddjjerdveJYsavQYbyxbVWirKgNAGfSf5HQ=', 'HQhFGAv7qOP4vkrZVo2KLghzWJOsNd', 'Tan Min Lee', 'Production Technician', 'Production', '016-5241368', 'ml_tan@company.com', '2018-02-01 08:00:00', null);
INSERT INTO `tbl_employee` VALUES(1025412, 'aN8vt7xFQhoutZbPz8BbLagFENcNlGTXXPhlOulyD7s=', 'IXMLHToFPfktUGTNvH7ghW2MQ54Zed', 'Susan Lim Zhi Shan', 'Account Executive II', 'Finance', '019-5241785', 'susan_lim@company.com', '2018-02-18 08:00:00', null);
INSERT INTO `tbl_employee` VALUES(1025413, 'lz6y1wejbZh7pDwMRrAFpqAOsUjhy30sJg7XpspYoio=', 'GY7zVTXJFUC2BPtyTwWDwAEi70Z4Ij', 'Mohd Zulkifli bin Mohd Saad', 'Material Handler', 'Warehouse', '011-5241235', 'zulkifli92@company.com', '2018-02-20 08:00:00', null);
INSERT INTO `tbl_employee` VALUES(1025414, 'ooFjwPYE0JbGkdXycUWOC08nHHET25X4h1Skcy54ssY=', 'JoqrcGhAC46RdnTXLSagLFbtq49VQP', 'Suresh A/L Keshidran', 'Production Engineer I', 'Production', '014-8547451', 'suresh90@company.com', '2019-02-20 08:00:00', null);
INSERT INTO `tbl_employee`  VALUES(1025415, 'yFldxvJ8wbjg2/bVwLt2dqK7iYGRuh1lqggjXtm13ow=', 'vHzq4d2kVeRCDK6OGT7kItyUihj0PE', 'Lee Xian', 'Production Technician III', 'Production', '019-8541725', 'xian_lee@company.com', '2019-02-20 08:00:00', '2020-12-28 18:00:00');

-- ----------------------------
-- Table structure for tbl_employeesalary
-- ----------------------------
DROP TABLE IF EXISTS `tbl_employeesalary`;
CREATE TABLE `tbl_employeesalary` (
  `s_id` INT NOT NULL AUTO_INCREMENT,
  `base_salary` DECIMAL(8, 2) NULL,
  `incremented_salary` DECIMAL(8, 2) NULL,
  `increment_date` DATETIME NULL,
  `e_id` INT NULL,
  `m_id` INT NULL,
  PRIMARY KEY(s_id),
  FOREIGN KEY(e_id) REFERENCES tbl_employee(e_id) ON DELETE CASCADE,
  FOREIGN KEY(m_id) REFERENCES tbl_manager(m_id)
) ENGINE=InnoDB AUTO_INCREMENT=4;

-- ----------------------------
-- Records of tbl_employeesalary
-- ----------------------------
INSERT INTO `tbl_employeesalary` VALUES(1, 2500.00, 3000.00, '2019-01-01 08:00:00', 1025412, 2032541);
INSERT INTO `tbl_employeesalary` VALUES(2, 2600.00, 3000.00, '2019-01-01 08:00:00', 1025414, 2015426);
INSERT INTO `tbl_employeesalary` VALUES(3, 1800.00, 2000.00, '2019-01-01 08:00:00', 1025411, 2015426);

-- ----------------------------
-- Table structure for tbl_training
-- ----------------------------
DROP TABLE IF EXISTS `tbl_training`;
CREATE TABLE `tbl_training` (
  `t_id` INT NOT NULL AUTO_INCREMENT,
  `t_info` VARCHAR(255) NULL,
  `t_startdate` DATE NULL,
  `t_enddate` DATE NULL,
  `t_status` ENUM('PENDING', 'COMPLETED') NULL,
  `e_id` INT NULL,
  `m_id` INT NULL,
  PRIMARY KEY(t_id),
  FOREIGN KEY(e_id) REFERENCES tbl_employee(e_id),
  FOREIGN KEY(m_id) REFERENCES tbl_manager(m_id)
) ENGINE=InnoDB AUTO_INCREMENT=4;

-- ----------------------------
-- Records of tbl_training
-- ----------------------------
INSERT INTO `tbl_training` VALUES(1, 'Lean Six Sigma Certification Course', '2019-04-08', '2019-04-12', 'Completed', 1025414, 2015426);
INSERT INTO `tbl_training` VALUES(2, 'Safety and Health Awareness at Production', '2019-07-10', '2019-07-10', 'Completed', 1025413, 2022540);
INSERT INTO `tbl_training` VALUES(3, 'Principles of Maintaining Process and Maintenance', '2019-10-15', '2019-10-18', 'Completed', 1025411, 2015426);

-- ----------------------------
-- Table structure for tbl_resignation
-- ----------------------------
DROP TABLE IF EXISTS `tbl_resignation`;
CREATE TABLE `tbl_resignation` (
  `r_id` INT NOT NULL AUTO_INCREMENT,
  `r_reasons` VARCHAR(255) NULL,
  `r_date` DATE NULL,
  `e_id` INT NULL,
  `m_id` INT NULL,
  PRIMARY KEY(r_id),
  FOREIGN KEY(e_id) REFERENCES tbl_employee(e_id),
  FOREIGN KEY(m_id) REFERENCES tbl_manager(m_id)
) ENGINE=InnoDB AUTO_INCREMENT=2;

-- ----------------------------
-- Records of tbl_training
-- ----------------------------
INSERT INTO `tbl_resignation` VALUES(1, 'Getting better opportunities.', '2020-12-28', 1025415, 2015426);

-- ----------------------------
-- Table structure for tbl_leave
-- ----------------------------
DROP TABLE IF EXISTS `tbl_leave`;
CREATE TABLE `tbl_leave` (
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
-- Records of tbl_leave
-- ----------------------------
INSERT INTO `tbl_leave` VALUES(1, 'Having fever.', '2019-06-12 08:00:00', '2019-06-13 08:00:00', 'MEDICAL LEAVE', 'APPROVED', 1025412, 2032541);
INSERT INTO `tbl_leave` VALUES(2, 'Personal reasons.', '2019-07-11 08:00:00', '2019-07-12 08:00:00', 'UNPAID LEAVE', 'APPROVED', 1025414, 2015426);
INSERT INTO `tbl_leave` VALUES(3, 'Settle some issues with bank.', '2019-10-09 12:30:00', '2019-10-09 18:00:00', 'UNPAID LEAVE', 'APPROVED', 1025411, 2015426);

-- ----------------------------
-- Table structure for tbl_loan
-- ----------------------------
DROP TABLE IF EXISTS `tbl_loan`;
CREATE TABLE `tbl_loan` (
  `loan_id` INT NOT NULL AUTO_INCREMENT,
  `loan_reasons` VARCHAR(255) NULL,
  `loan_amount` DECIMAL(6,2) NULL,
  `loan_issuedate` DATE NULL,
  `loan_status` ENUM('APPROVED', 'PENDING', 'REJECTED') NULL,
  `e_id` INT NULL,
  `m_id` INT NULL,
  PRIMARY KEY(loan_id),
  FOREIGN KEY(e_id) REFERENCES tbl_employee(e_id),
  FOREIGN KEY(m_id) REFERENCES tbl_manager(m_id)
) ENGINE=InnoDB AUTO_INCREMENT=2;

-- ----------------------------
-- Records of tbl_loan
-- ----------------------------
INSERT INTO `tbl_loan` VALUES(1, 'Loan money for paying my mother hospital fee.', '2000.00', '2020-06-20', 'APPROVED', 1025413, 2026538);

-- ----------------------------
-- Table structure for tbl_monthlypay
-- ----------------------------
DROP TABLE IF EXISTS `tbl_monthlypay`;
CREATE TABLE `tbl_monthlypay` (
  `mp_id` INT NOT NULL AUTO_INCREMENT,
  `mp_currentsalary` DECIMAL(8,2) NULL,
  `mp_overtimepay` DECIMAL(8,2) NULL,
  `mp_deductedsalary` DECIMAL(8,2) NULL,
  `mp_totalpay` DECIMAL(8,2) NULL,
  `mp_paymentdate` DATE NULL,
  `e_id` INT NULL,
  `m_id` INT NULL,
  PRIMARY KEY(mp_id),
  FOREIGN KEY(e_id) REFERENCES tbl_employee(e_id),
  FOREIGN KEY(m_id) REFERENCES tbl_manager(m_id)
) ENGINE=InnoDB AUTO_INCREMENT=4;

-- ----------------------------
-- Records of tbl_monthlypay
-- ----------------------------
INSERT INTO `tbl_monthlypay` VALUES(1, 2600.00, 300.00, 0, 2900.00, '2019-03-30', 1025414, 2015426);
INSERT INTO `tbl_monthlypay` VALUES(2, 2500.00, 300.00, 0, 2800.00, '2019-03-30', 1025412, 2032541);
INSERT INTO `tbl_monthlypay` VALUES(3, 1800.00, 545.50, 0, 2345.50, '2019-03-30', 1025411, 2015426);