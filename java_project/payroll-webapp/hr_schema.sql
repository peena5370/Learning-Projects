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
-- Records of tbl_account
-- id: admin
-- Password: Admin@1234
-- id: khormg12
-- Password: Manager@1234
-- id: tanml333
-- Password: Employee@5678
-- ----------------------------
INSERT INTO `tbl_account` VALUES(1, 'admin', 'A3qvbJAiIxDGH6qrHxkG6NXCJ2sdrSdrsfTmLW3L6ws=', 'gEr3dLLuLpV5RIrJmMLAqJNTjCdInW', now(), null);
INSERT INTO `tbl_account` VALUES(2, 'khormg12', 'YUQZ2ADeZz8gjHKIvX/tK8kdAmHt2CZa1YLZlCXkH4U=', 'De3ag71pO4I4Mjh1AYLTOzzvWtpLZG', now(), null);
INSERT INTO `tbl_account` VALUES(3, 'tanml333', '0Njk9+U8ddjjerdveJYsavQYbyxbVWirKgNAGfSf5HQ=', 'HQhFGAv7qOP4vkrZVo2KLghzWJOsNd', now(), null);
INSERT INTO `tbl_account` VALUES(4, 'jeniffer3187', '6fQf2S1Qwm0L919TWFQK4ssp0j9yCSt6edvQAZugFCM=', 'GppW7GhjTIZiK9LtFTCJB7nERAaep3', now(), null);
INSERT INTO `tbl_account` VALUES(5, 'adelehuirou23', 'TRkcz7ETpa8lu4X4mgXM+JXHDmaVgs6gNZg6IQb3/Q8=', 'SI4faV7K8ca9SqfbxIW9opVb3nKq4y', now(), null);
INSERT INTO `tbl_account` VALUES(6, 'kumar6657', 'POlBFPHne1yhB0pvLHE3HWNTPaoDIPqf6qdcQciIlQM=', 'a3bInVJN1IyBfEXwLgdRAhm5ylGtvZ', now(), null);
INSERT INTO `tbl_account` VALUES(7, 'azmi7653', 'AnrVFu83GHZDjp1HTWs5quM+dhkj7TWfLLa/iO7DrSg=', '6ECRm5sV9m9hQxbF0Q8xcP4jPzCj4C', now(), null);
INSERT INTO `tbl_account` VALUES(8, 'susan4463', 'aN8vt7xFQhoutZbPz8BbLagFENcNlGTXXPhlOulyD7s=', 'IXMLHToFPfktUGTNvH7ghW2MQ54Zed', now(), null);
INSERT INTO `tbl_account` VALUES(9, 'zulkifli12', 'lz6y1wejbZh7pDwMRrAFpqAOsUjhy30sJg7XpspYoio=', 'GY7zVTXJFUC2BPtyTwWDwAEi70Z4Ij', now(), null);
INSERT INTO `tbl_account` VALUES(10, 'suresh223', 'ooFjwPYE0JbGkdXycUWOC08nHHET25X4h1Skcy54ssY=', 'JoqrcGhAC46RdnTXLSagLFbtq49VQP', now(), null);
INSERT INTO `tbl_account` VALUES(11, 'siti5431', 'yFldxvJ8wbjg2/bVwLt2dqK7iYGRuh1lqggjXtm13ow=', 'vHzq4d2kVeRCDK6OGT7kItyUihj0PE', now(), null);
INSERT INTO `tbl_account` VALUES(12, 'kklim463', 'sjgOEMVhc2Vh5u75TUwKi0anYd7qeVmR2Ol4M4hVx18=', 'wga0c05HxrnUkJPBS57n5kfGuSApmv', now(), null);

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
-- Records of tbl_department
-- ----------------------------
INSERT INTO `tbl_department` VALUES(2011, 'Human Resource', 'Plant 1, Sungai Petani', 'Kedah', 'Malaysia');
INSERT INTO `tbl_department` VALUES(2012, 'Information Technology', 'Plant 1, Sungai Petani', 'Kedah', 'Malaysia');
INSERT INTO `tbl_department` VALUES(2013, 'Facility', 'Plant 2, Sungai Petani', 'Kedah', 'Malaysia');
INSERT INTO `tbl_department` VALUES(2014, 'Finance', 'Plant 1, Sungai Petani', 'Kedah', 'Malaysia');
INSERT INTO `tbl_department` VALUES(2015, 'Production', 'Plant 2, Sungai Petani', 'Kedah', 'Malaysia');
INSERT INTO `tbl_department` VALUES(2016, 'Warehouse', 'Plant 1, Sungai Petani', 'Kedah', 'Malaysia');
INSERT INTO `tbl_department` VALUES(2017, 'Tooling', 'Plant 1, Sungai Petani', 'Kedah', 'Malaysia');
INSERT INTO `tbl_department` VALUES(2018, 'Business Unit', 'Plant 1, Klang', 'Selangor', 'Malaysia');

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
-- Records of tbl_title
-- ----------------------------
INSERT INTO `tbl_title` VALUES(1001, 'Operation Manager');
INSERT INTO `tbl_title` VALUES(1002, 'Asistant Operation Manager');
INSERT INTO `tbl_title` VALUES(1003, 'Production Manager');
INSERT INTO `tbl_title` VALUES(1004, 'Asistant Production Manager');
INSERT INTO `tbl_title` VALUES(1005, 'Human Resource Manager');
INSERT INTO `tbl_title` VALUES(1006, 'Asistant Human Resource Manager');
INSERT INTO `tbl_title` VALUES(1007, 'Information Technology Manager');
INSERT INTO `tbl_title` VALUES(1008, 'Asistant Information Technology Manager');
INSERT INTO `tbl_title` VALUES(1009, 'Finance Manager');
INSERT INTO `tbl_title` VALUES(1010, 'Asistant Finance Manager');
INSERT INTO `tbl_title` VALUES(1011, 'Facility Manager');
INSERT INTO `tbl_title` VALUES(1012, 'Asistant Facility Manager');
INSERT INTO `tbl_title` VALUES(1013, 'Tooling Manager');
INSERT INTO `tbl_title` VALUES(1014, 'Asistant Tooling Manager');
INSERT INTO `tbl_title` VALUES(1015, 'Warehouse Manager');
INSERT INTO `tbl_title` VALUES(1016, 'Asistant Warehouse Manager');
INSERT INTO `tbl_title` VALUES(1017, 'Production Technician I');
INSERT INTO `tbl_title` VALUES(1018, 'Production Technician II');
INSERT INTO `tbl_title` VALUES(1019, 'Production Technician III');
INSERT INTO `tbl_title` VALUES(1020, 'Production Technician IV');
INSERT INTO `tbl_title` VALUES(1021, 'Production Engineer I');
INSERT INTO `tbl_title` VALUES(1022, 'Production Engineer II');
INSERT INTO `tbl_title` VALUES(1023, 'Production Engineer III');
INSERT INTO `tbl_title` VALUES(1024, 'Production Engineer IV');
INSERT INTO `tbl_title` VALUES(1025, 'Human Resource Executive');
INSERT INTO `tbl_title` VALUES(1026, 'Senior Human Resource Executive');
INSERT INTO `tbl_title` VALUES(1027, 'Material Handler');
INSERT INTO `tbl_title` VALUES(1028, 'Account Executive');

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
-- Records of tbl_manager
-- ----------------------------
INSERT INTO `tbl_manager` VALUES(3348, 'Lee Sheng Xian', 'Administrator', 'MALE', '29', 'SINGLE', 'STPM', 'B-23, Orchard Apartment, Taman Nuri', 'Kedah', 'Malaysia', '017-5049182', 'sxlee@company.com', '2020-03-02', null, 1, 2012, 1007);
INSERT INTO `tbl_manager` VALUES(3349, 'Khor Ming Guan', 'Manager', 'MALE', '35', 'MARRIED', 'Master Degree', 'Lot 4-11, Jalan Tun Perak, Taman Orkid', 'Kedah', 'Malaysia', '012-1039481', 'khormg@company.com', '2020-03-02', null, 2, 2011, 1005);
INSERT INTO `tbl_manager` VALUES(3350, 'Jeniffer Loh Hui Shan', 'Manager', 'FEMALE', '30', 'MARRIED', 'Degree', 'B-34, Lorong Cendana 4/1, Taman Cendana', 'Kedah', 'Malaysia', '012-5793187', 'jenifferloh@company.com', '2020-04-06', null, 4, 2016, 1015);
INSERT INTO `tbl_manager` VALUES(3351, 'Adele Chuah Hui Rou', 'Manager', 'FEMALE', '30', 'SINGLE', 'Degree', '23, Jalan Sultanah, Taman Bunga Raya', 'Kedah', 'Malaysia', '016-5743821', 'adelechuah@company.com', '2020-04-06', null, 5, 2014, 1009);
INSERT INTO `tbl_manager` VALUES(3352, 'Sivakumar A/L Surumugan', 'Manager', 'MALE', '32', 'MARRIED', 'Master Degree', 'B1667, Taman Semeling, Bandar Baru', 'Kedah', 'Malaysia', '014-4059182', 'sivakumar@company.com', '2020-04-15', null, 6, 2013, 1011);
INSERT INTO `tbl_manager` VALUES(3353, 'Muhamad Azmi bin Qaafar', 'Manager', 'MALE', '28', 'SINGLE', 'Degree', '23, Lorong Berjaya 8/2, Taman Berjaya', 'Kedah', 'Malaysia', '019-2019381', 'muhamadazmi@company.com', '2020-04-24', null, 7, 2015, 1014);

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
-- Records of tbl_employee
-- ----------------------------
INSERT INTO `tbl_employee` VALUES(125411, 'Tan Min Lee', 'MALE', '23', 'SINGLE', 'Diploma', '2445, Lorong Murni, Taman Murni', 'Perlis', 'Malaysia', '014-2140291', 'mltan@company.com', '2020-04-28', null, 3 , 2015, 3353, 1018);
INSERT INTO `tbl_employee` VALUES(125412, 'Susan Lim Zhi Shan', 'FEMALE', '22', 'SINGLE', 'Diploma', 'E-1623, Taman Sri Abadi, Lorong Sengkuang', 'Kedah', 'Malaysia', '011-20391932', 'susanlim@company.com', '2020-04-07', null, 8, 2014, 3351, 1028);
INSERT INTO `tbl_employee` VALUES(125413, 'Mohd Zulkifli bin Mohd Saad', 'MALE', '24', 'SINGLE', 'Diploma', 'Lot1-43, Jalan Aman, Taman Sri Aman', 'Kedah', 'Malaysia', '019-2039181', 'zulkifli@company.com', '2020-04-08', null, 9, 2016, 3350, 1027);
INSERT INTO `tbl_employee` VALUES(125414, 'Suresh A/L Keshidran', 'MALE', '25', 'SINGLE', 'Degree', '12, Jalan Sri Murni, Taman Murni', 'Pulau Pinang', 'Malaysia', '019-2039181', 'suresh@company.com', '2020-04-27', null, 10, 2015, 3353, 1021);
INSERT INTO `tbl_employee` VALUES(125415, 'Siti Nur Adirah binti Mohd Afiq', 'FEMALE', '23', 'SINGLE', 'Diploma', '1223, Taman Maluri, Jalan Istimewa', 'Perak', 'Malaysia', '012-6654321', 'adirah@company.com', '2020-04-29', null, 11, 2011, 3349, 1025);
INSERT INTO `tbl_employee` VALUES(125416, 'Lim Kean Keat', 'MALE', '28', 'MARRIED', 'Diploma', 'Blok D-46, Sky Apartment, Taman Marina', 'Pulau Pinang', 'Malaysia', '017-5748172', 'kklim@company.com', '2020-04-22', '2020-12-28', 12, 2013, 3352, 1025);

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
-- Records of tbl_employeesalary
-- ----------------------------
INSERT INTO `tbl_employeesalary` VALUES(22051, 2200.00, 28600.00, 125411);
INSERT INTO `tbl_employeesalary` VALUES(22052, 2050.00, 26650.00, 125412);
INSERT INTO `tbl_employeesalary` VALUES(22053, 1800.00, 23400.00, 125413);
INSERT INTO `tbl_employeesalary` VALUES(22054, 2800.00, 36400.00, 125414);
INSERT INTO `tbl_employeesalary` VALUES(22055, 2650.00, 34450.00, 125415);
INSERT INTO `tbl_employeesalary` VALUES(22056, 2800.00, 36400.00, 125416);

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
-- Records of tbl_employeepromotion
-- ----------------------------
INSERT INTO `tbl_employeepromotion` VALUES(1160, 2000.00, 2200.00, '2020-12-31', 1018, 125411, 3353);
INSERT INTO `tbl_employeepromotion` VALUES(1161, 1800.00, 2050.00, '2020-12-31', 1028, 125412, 3351);
INSERT INTO `tbl_employeepromotion` VALUES(1162, 1500.00, 1800.00, '2020-12-31', 1027, 125413, 3350);
INSERT INTO `tbl_employeepromotion` VALUES(1163, 2500.00, 2800.00, '2020-12-31', 1021, 125414, 3353);
INSERT INTO `tbl_employeepromotion` VALUES(1164, 2200.00, 2650.00, '2020-12-31', 1025, 125415, 3349);

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
-- Records of tbl_training
-- ----------------------------
INSERT INTO `tbl_training` VALUES(1, 'Lean Six Sigma Certification Course', '2020-07-06 10:00:00', '2020-07-10 16:00:00', 'Completed', 125414, 3353);
INSERT INTO `tbl_training` VALUES(2, 'Safety and Health Awareness at Production', '2020-07-16 12:00:00', '2020-07-16 18:00:00', 'Completed', 125413, 3349);
INSERT INTO `tbl_training` VALUES(3, 'Principles of Maintaining Process and Maintenance', '2020-10-14 10:00:00', '2020-10-16 16:00:00', 'Completed', 125411, 3353);

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
-- Records of tbl_employeeleave
-- ----------------------------
INSERT INTO `tbl_employeeleave` VALUES(1, 'Having fever.', '2020-06-10 08:00:00', '2020-06-11 08:00:00', 'MEDICAL LEAVE', 'APPROVED', 125412, 3351);
INSERT INTO `tbl_employeeleave` VALUES(2, 'Personal reasons.', '2020-07-07 08:00:00', '2020-07-09 08:00:00', 'UNPAID LEAVE', 'APPROVED', 125414, 3353);
INSERT INTO `tbl_employeeleave` VALUES(3, 'Settle some issues with bank.', '2020-08-12 12:30:00', '2020-08-12 18:00:00', 'UNPAID LEAVE', 'APPROVED', 125411, 3353);
INSERT INTO `tbl_employeeleave` VALUES(4, 'Personal reasons.', '2020-09-14 08:00:00', '2020-09-18 18:00:00', 'UNPAID LEAVE', 'REJECTED', 125411, 3353);
INSERT INTO `tbl_employeeleave` VALUES(5, 'Attend grandfather funeral ceremony.', '2020-10-09 08:00:00', '2020-10-10 08:00:00', 'UNPAID LEAVE', 'APPROVED', 125416, 3352);

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
-- Records of tbl_employeeloan
-- ----------------------------
INSERT INTO `tbl_employeeloan` VALUES(5001, 'Loan money for paying my mother hospital fee.', 2000.00, '2020-06-19', 'APPROVED', 125413, 3350);

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
-- Records of tbl_resignation
-- ----------------------------
INSERT INTO `tbl_resignation` VALUES(4001, 'Getting better opportunities.', '2020-12-28', 125416, 3352);

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

-- ----------------------------
-- Records of tbl_payroll
-- ----------------------------
INSERT INTO `tbl_payroll` VALUES(30001, 2300.00, 300.00, 0, '2019-03-31', 2000.00, 125411, 3353);
INSERT INTO `tbl_payroll` VALUES(30002, 2425.55, 625.55, 0, '2019-03-31', 1800.00, 125412, 3351);
INSERT INTO `tbl_payroll` VALUES(30003, 2263.00, 763.00, 0, '2019-03-31', 1500.00, 125413, 3350);
INSERT INTO `tbl_payroll` VALUES(30004, 2830.00, 330.00, 0, '2019-03-31', 2500.00, 125414, 3353);
INSERT INTO `tbl_payroll` VALUES(30005, 2515.00, 315.00, 0, '2019-03-31', 2200.00, 125415, 3349);
INSERT INTO `tbl_payroll` VALUES(30006, 3130.00, 330.00, 0, '2019-03-31', 2800.00, 125416, 3352);
INSERT INTO `tbl_payroll` VALUES(30007, 2345.00, 345.00, 0, '2019-04-30', 2000.00, 125411, 3353); 
INSERT INTO `tbl_payroll` VALUES(30008, 2543.25, 743.25, 0, '2019-04-30', 1800.00, 125412, 3351);
INSERT INTO `tbl_payroll` VALUES(30009, 2055.65, 555.65, 0, '2019-04-30', 1500.00, 125413, 3350);
INSERT INTO `tbl_payroll` VALUES(30010, 2830.00, 330.00, 0, '2019-04-30', 2500.00, 125414, 3353);
INSERT INTO `tbl_payroll` VALUES(30011, 2500.00, 300.00, 0, '2019-04-30', 2200.00, 125415, 3349);
INSERT INTO `tbl_payroll` VALUES(30012, 3130.00, 330.00, 0, '2019-04-30', 2800.00, 125416, 3352);



-- java myBatis BUG
SEVERE: Servlet.service() for servlet [ManagerPostForm] in context with path [/hr_dynamicweb] threw exception
org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.NullPointerException: Cannot invoke "org.apache.ibatis.cache.impl.PerpetualCache.removeObject(Object)" because "this.localCache" is null
### The error may exist in resources/mappers/EmployeeSalary.xml
### The error may involve resources.mappers.EmployeeSalary.getSalaryByEmployee
### The error occurred while executing a query
### Cause: java.lang.NullPointerException: Cannot invoke "org.apache.ibatis.cache.impl.PerpetualCache.removeObject(Object)" because "this.localCache" is null
	at org.apache.ibatis.exceptions.ExceptionFactory.wrapException(ExceptionFactory.java:30)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:153)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:145)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:140)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectOne(DefaultSqlSession.java:76)
	at v2.com.company.payroll.dao.impl.EmployeeSalaryDaoImpl.getSalaryByEmployeeName(EmployeeSalaryDaoImpl.java:26)
	at v2.com.company.payroll.controller.ManagerPostForm.doPost(ManagerPostForm.java:276)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:681)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)
	at com.company.payroll.interceptor.AuthenticationFilter.doFilter(AuthenticationFilter.java:28)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:197)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:540)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:135)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)
	at org.apache.catalina.valves.AbstractAccessLogValve.invoke(AbstractAccessLogValve.java:687)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:357)
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:382)
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:895)
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1732)
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)
	at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191)
	at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.base/java.lang.Thread.run(Thread.java:833)
Caused by: java.lang.NullPointerException: Cannot invoke "org.apache.ibatis.cache.impl.PerpetualCache.removeObject(Object)" because "this.localCache" is null
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:327)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:89)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:151)
	... 32 more
