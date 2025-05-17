CREATE database payroll_db;

USE database payroll_db;

CREATE table employee (
    id VARCHAR(100) NOT NULL,
    name VARCHAR(200) NOT NULL,
    age INT NOT NULL,
    PRIMARY KEY(id)
);