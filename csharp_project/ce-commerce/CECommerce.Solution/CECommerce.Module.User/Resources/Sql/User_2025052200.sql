CREATE TABLE user_user (
user_id VARCHAR(32) NOT NULL,
full_name VARCHAR(200) NOT NULL,
age INT NOT NULL,
gender VARCHAR(20) NOT NULL,
phone_number VARCHAR(20) NULL,
email VARCHAR(100) NULL,
modified_at DATETIME NOT NULL,
deleted_at DATETIME NULL,
modified_by VARCHAR(32) NULL,
PRIMARY KEY(user_id)
);

CREATE TABLE user_account (
account_id VARCHAR(32) NOT NULL,
username VARCHAR(50) NOT NULL,
password CHAR(100) NOT NULL,
user_id VARCHAR(32) NOT NULL,
status BIT NOT NULL,
is_lock BIT NOT NULL,
created_at DATETIME NOT NULL,
modified_at DATETIME NOT NULL,
deleted_at DATETIME NULL,
modified_by VARCHAR(32) NULL,
PRIMARY KEY(account_id)
);

CREATE TABLE user_role (
role_id VARCHAR(32) NOT NULL,
name VARCHAR(100) NOT NULL,
modified_at DATETIME NOT NULL,
modified_by VARCHAR(32) NULL,
PRIMARY KEY(role_id)
);

CREATE TABLE user_user_role (
user_role_id VARCHAR(32) NOT NULL,
user_id VARCHAR(32) NOT NULL,
role_id VARCHAR(32) NOT NULL,
PRIMARY KEY(user_role_id)
);

CREATE TABLE user_ship_address (
ship_address_id VARCHAR(32) NOT NULL,
user_id VARCHAR(32) NOT NULL,
address VARCHAR(200) NOT NULL,
address_type VARCHAR(50) NOT NULL,
postal_code INT NOT NULL,
state VARCHAR(100) NOT NULL,
country VARCHAR(100) NOT NULL,
modified_at DATETIME NOT NULL,
modified_by VARCHAR(32) NULL,
PRIMARY KEY(ship_address_id)
);