DROP DATABASE IF EXISTS `payroll_schema`;
CREATE DATABASE `payroll_schema`;

USE `payroll_schema`;

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `ams_account_credential`;
CREATE TABLE `ams_account_credential` (
    `id` BIGINT NOT NULL COMMENT 'account_credential table id',
    `account_id` BIGINT NOT NULL COMMENT 'account_staff table id',
    `role` ENUM('common_user', 'manager_admin', 'manager_leader', 'system_admin', 'system_user') NOT NULL COMMENT 'account credential role enum value',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `ams_account_staff`;
CREATE TABLE `ams_account_staff` (
    `id` BIGINT NOT NULL COMMENT 'account_staff table id',
    `username` CHAR(20) NOT NULL COMMENT 'account username',
    `password` CHAR(68) NOT NULL COMMENT 'account hashed password',
    `secret_key` CHAR(44) NOT NULL COMMENT 'key',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `last_login` DATETIME NULL COMMENT 'account last login date time',
    `status` TINYINT(4) NOT NULL COMMENT 'account status (0=inactive, 1=active, 2=locked)',
    `last_attempt` INT NOT NULL COMMENT 'account last attempt count',
    `created_date` DATETIME NOT NULL COMMENT 'account created date time',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `ams_account_staff_profile`;
CREATE TABLE `ams_account_staff_profile` (
    `id` BIGINT NOT NULL COMMENT 'account_staff_profile table id',
    `account_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `about_profile` VARCHAR(200) NULL COMMENT 'account profile string',
    `image_path` VARCHAR(255) NULL COMMENT 'account profile image path',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_attendance_staff`;
CREATE TABLE `hms_attendance_staff` (
    `id` BIGINT NOT NULL COMMENT 'attendance_staff table id',
    `attendance_date` DATE NOT NULL COMMENT 'staff attendance checkin date',
    `update_date` DATETIME NOT NULL COMMENT 'staff attendance update date',
    `attendance_order` INT NOT NULL COMMENT 'attendance insert order for that day',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_attendance_staff_archive`;
CREATE TABLE `hms_attendance_staff_archive` (
    `id` BIGINT NOT NULL COMMENT 'attendance_staff_archive table id',
    `attendance_id` BIGINT NOT NULL COMMENT 'attendance_staff table id',
    `attendance_date` DATETIME NOT NULL COMMENT 'staff attendance checkin date',
    `update_date` DATETIME NOT NULL COMMENT 'staff attendance update date',
    `attendance_order` INT NOT NULL COMMENT 'attendance insert order for that day',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_department_detail`;
CREATE TABLE `hms_department_detail` (
    `id` BIGINT NOT NULL COMMENT 'department_detail table id',
    `department_name` VARCHAR(100) NOT NULL COMMENT 'department name',
    `location_address` VARCHAR(200) NOT NULL COMMENT 'department location address',
    `date_formed` DATE NOT NULL COMMENT 'department formed date',
    `date_closed` DATE NULL COMMENT 'department closed date',
    `region_id` BIGINT NOT NULL COMMENT 'department_region table id',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_department_leader`;
CREATE TABLE `hms_department_leader` (
    `id` BIGINT NOT NULL COMMENT 'department_leader table id',
    `department_id` BIGINT NOT NULL COMMENT 'department_detail table id',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_department_region`;
CREATE TABLE `hms_department_region` (
    `id` BIGINT NOT NULL COMMENT 'department_region table id',
    `region_code` VARCHAR(10) NOT NULL COMMENT 'department region code',
    `region_name` VARCHAR(100) NOT NULL COMMENT 'department region name',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_department_staff`;
CREATE TABLE `hms_department_staff` (
    `id` BIGINT NOT NULL COMMENT 'department_staff table id',
    `department_id` BIGINT NOT NULL COMMENT 'department_detail table id',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `deleted_date` DATETIME NULL COMMENT 'department staff quit date',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_loan_staff`;
CREATE TABLE `hms_loan_staff` (
    `id` BIGINT NOT NULL COMMENT 'loan_staff table id',
    `reference_num` VARCHAR(25) NOT NULL COMMENT 'loan_staff reference number',
    `reason` VARCHAR(255) NULL COMMENT 'loan reason',
    `amount` DECIMAL(8,2) NULL COMMENT 'loan amount',
    `date_repay_from` DATE NULL COMMENT 'loan repay date start',
    `date_repay_to` DATE NULL COMMENT 'loan repay date end',
    `repay_balance` DECIMAL(8,2) NULL COMMENT 'pending repay loan balance',
    `apply_date` DATE NOT NULL COMMENT 'loan application date',
    `approved_date` DATE NULL COMMENT 'loan approved date',
    `status` TINYINT(4) NOT NULL COMMENT 'loan approval status (0=pending, 1=approved, 2=rejected, 3=ongoing, 4=completed)',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_loan_staff_archive`;
CREATE TABLE `hms_loan_staff_archive` (
    `id` BIGINT NOT NULL COMMENT 'loan_staff_archive table id',
    `loan_id` BIGINT NOT NULL COMMENT 'loan_staff table id',
    `reference_num` VARCHAR(25) NOT NULL COMMENT 'loan_staff reference number',
    `reason` VARCHAR(255) NULL COMMENT 'loan reason',
    `amount` DECIMAL(8,2) NULL COMMENT 'loan amount',
    `date_repay_from` DATE NULL COMMENT 'loan repay date start',
    `date_repay_to` DATE NULL COMMENT 'loan repay date end',
    `repay_balance` DECIMAL(8,2) NULL COMMENT 'pending repay loan balance',
    `apply_date` DATE NOT NULL COMMENT 'loan application date',
    `approved_date` DATE NULL COMMENT 'loan approved date',
    `status` TINYINT(4) NOT NULL COMMENT 'loan approval status (0=pending, 1=approved, 2=rejected, 3=ongoing, 4=completed)',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_payroll_staff`;
CREATE TABLE `hms_payroll_staff` (
    `id` BIGINT NOT NULL COMMENT 'payroll_staff table id',
    `salary_id` BIGINT NOT NULL COMMENT 'staff_salary table id',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `overtime_pay` DECIMAL(8,2) NOT NULL COMMENT 'overtime pay',
    `allowance_misc` DECIMAL(8,2) NOT NULL COMMENT 'approved miscellaneous allowance',
    `allowance_transport` DECIMAL(8,2) NOT NULL COMMENT 'approved transport allowance',
    `deduction_loan` DECIMAL(8,2) NOT NULL COMMENT 'loan deduction',
    `deduction_other` DECIMAL(8,2) NOT NULL COMMENT 'other deduction',
    `employee_epf` DECIMAL(8,2) NOT NULL COMMENT 'employee epf deduction',
    `employee_socso` DECIMAL(8,2) NOT NULL COMMENT 'employee socso deduction',
    `employee_eis` DECIMAL(8,2) NOT NULL COMMENT 'employee eis deduction',
    `employer_epf` DECIMAL(8,2) NOT NULL COMMENT 'employer epf deduction',
    `employer_socso` DECIMAL(8,2) NOT NULL COMMENT 'employer socso deduction',
    `employer_eis` DECIMAL(8,2) NOT NULL COMMENT 'employer eis deduction',
    `mtd_pcb` DECIMAL(8,2) NOT NULL COMMENT 'monthly tax deduction',
    `net_pay` DECIMAL(10,2) NOT NULL COMMENT 'net pay after deduction',
    `payroll_period` VARCHAR(50) NOT NULL COMMENT 'payroll issue period',
    `date_issue` DATE NOT NULL COMMENT 'payroll issue date',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_config`;
CREATE TABLE `hms_config` (
    `id` BIGINT NOT NULL COMMENT 'config table id',
    `config_type` VARCHAR(50) NOT NULL COMMENT 'config type (epf_rate, email host, ...)',
    `name` VARCHAR(200) NOT NULL COMMENT 'config name (employee_epf_rate, employee_socso_rate, .....)',
    `value` VARCHAR(255) NOT NULL COMMENT 'config value',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_position_detail`;
CREATE TABLE `hms_position_detail` (
    `id` BIGINT NOT NULL COMMENT 'position_detail table id',
    `name` VARCHAR(200) NOT NULL COMMENT 'job position title',
    `description` TEXT NOT NULL COMMENT 'job position description',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_position_staff`;
CREATE TABLE `hms_position_staff` (
    `id` BIGINT NOT NULL COMMENT 'position_staff table id',
    `position_id` BIGINT NOT NULL COMMENT 'position_detail table id',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `position_order` INT NOT NULL COMMENT 'position order',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_resignation_staff`;
CREATE TABLE `hms_resignation_staff` (
    `id` BIGINT NOT NULL COMMENT 'resignation_staff table id',
    `resignation_reference_num` VARCHAR(25) NOT NULL COMMENT 'resignation application reference number',
    `reason` TEXT NULL COMMENT 'resign reason',
    `resign_date` DATE NOT NULL COMMENT 'resign date',
    `file_id` BIGINT NULL COMMENT 'staff_filestore table id',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_staff_appraisal`;
CREATE TABLE `hms_staff_appraisal` (
    `id` BIGINT NOT NULL COMMENT 'staff_appraisal table id',
    `salary_current` DECIMAL(10,2) NOT NULL COMMENT 'staff current salary',
    `salary_appraised` DECIMAL(10,2) NOT NULL COMMENT 'staff appraised salary',
    `date_appraised_start` DATE NOT NULL COMMENT 'date appraised',
    `comment` TEXT NULL COMMENT 'appraised comment',
    `status` TINYINT(4) NOT NULL COMMENT 'appraised status(0=ongoing, 1=completed, 2=rejected)',
    `position_id` BIGINT NOT NULL COMMENT 'position_staff table id',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_staff_banking`;
CREATE TABLE `hms_staff_banking` (
    `id` BIGINT NOT NULL COMMENT 'staff_banking table id',
    `account_number` BIGINT NULL COMMENT 'staff bank account number',
    `bank_name` VARCHAR(100) NULL COMMENT 'staff account bank name',
    `account_epf` INT NULL COMMENT 'staff epf account number',
    `account_income_tax` VARCHAR(20) NULL COMMENT 'staff income tax TIN number',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_staff_detail`;
CREATE TABLE `hms_staff_detail` (
    `id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `staff_code` VARCHAR(15) NOT NULL COMMENT 'staff code for login purpose',
    `fullname` VARCHAR(200) NOT NULL COMMENT 'staff fullname',
    `gender` ENUM('female', 'male', 'other') NOT NULL COMMENT 'staff gender enum value',
    `date_of_birth` DATE NOT NULL COMMENT 'staff date of birth',
    `age` INT NOT NULL COMMENT 'staff age',
    `ic_number` VARCHAR(15) NOT NULL COMMENT 'staff ic number',
    `marital_status` ENUM('married', 'single', 'divorced', 'other') NOT NULL COMMENT 'staff marital status enum value',
    `education` VARCHAR(50) NOT NULL COMMENT 'education level',
    `home_address` VARCHAR(200) NULL COMMENT 'home address',
    `phone_home` VARCHAR(10) NULL COMMENT 'home phone number',
    `phone_mobile` VARCHAR(12) NULL COMMENT 'mobile phone number',
    `email_company` VARCHAR(100) NOT NULL COMMENT 'company email address',
    `hired_date` DATE NOT NULL COMMENT 'staff hired date',
    `resign_date` DATE NULL COMMENT 'staff resign date',
    `manager_id` BIGINT NULL COMMENT 'staff leader id',
    `deleted_date` DATETIME NULL COMMENT 'staff profile deleted date',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_staff_filestore`;
CREATE TABLE `hms_staff_filestore` (
    `id` BIGINT NOT NULL COMMENT 'staff_filestore table id',
    `file_name` VARCHAR(50) NOT NULL COMMENT 'filestore file name',
    `file_size` BIGINT NOT NULL COMMENT 'filestore file size',
    `file_type` VARCHAR(50) NOT NULL COMMENT 'file type',
    `file_path` VARCHAR(255) NOT NULL COMMENT 'file path',
    `file_table_type` VARCHAR(50) NOT NULL COMMENT 'filestore file used by which table',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `uploaded_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_staff_salary`;
CREATE TABLE `hms_staff_salary` (
    `id` BIGINT NOT NULL COMMENT 'staff_salary table id',
    `monthly_salary` DECIMAL(10,2) NOT NULL COMMENT 'staff monthly salary',
    `annual_salary` DECIMAL(10,2) NOT NULL COMMENT 'staff annual salary',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_staff_training_detail`;
CREATE TABLE `hms_staff_training_detail` (
    `id` BIGINT NOT NULL COMMENT 'staff_training_detail table id',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `training_title` VARCHAR(200) NULL COMMENT 'training title',
    `training_description` TEXT NULL COMMENT 'training description',
    `start_date` DATETIME NULL COMMENT 'training start date',
    `end_date` DATETIME NULL COMMENT 'training end date',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_timeoff_staff`;
CREATE TABLE `hms_timeoff_staff` (
    `id` BIGINT NOT NULL COMMENT 'timeoff_staff table id',
    `timeoff_reference_num` VARCHAR(25) NOT NULL COMMENT 'timeoff reference number',
    `timeoff_type_id` BIGINT NOT NULL COMMENT 'timeoff_type table id',
    `reason` TEXT NULL COMMENT 'timeoff reason',
    `apply_date` DATE NOT NULL COMMENT 'timeoff application date',
    `approved_date` DATE NULL COMMENT 'application approved date',
    `start_date` DATETIME NOT NULL COMMENT 'timeoff date start',
    `end_date` DATETIME NOT NULL COMMENT 'timeoff date end',
    `status` TINYINT(4) NOT NULL COMMENT 'timeoff application status (0=pending, 1=approved, 2=rejected)',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_timeoff_type`;
CREATE TABLE `hms_timeoff_type` (
    `id` BIGINT NOT NULL COMMENT 'timeoff_type table id',
    `type_name` VARCHAR(50) NOT NULL COMMENT 'timeoff type name',
    `type_default_amount` INT NOT NULL COMMENT 'timeoff type default amount (for example, maternity leave = 90 days)',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `hms_timeoff_type_balance`;
CREATE TABLE `hms_timeoff_type_balance` (
    `id` BIGINT NOT NULL COMMENT 'timeoff_type_balance table id',
    `timeoff_type_id` BIGINT NOT NULL COMMENT 'timeoff_type table id',
    `staff_id` BIGINT NOT NULL COMMENT 'staff_detail table id',
    `type_balance` INT NOT NULL COMMENT 'timeoff type balance',
    `modified_date` DATETIME NOT NULL COMMENT 'modified date time',
    `modified_by` BIGINT NOT NULL COMMENT 'modified by account_staff table id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

SET FOREIGN_KEY_CHECKS=1;