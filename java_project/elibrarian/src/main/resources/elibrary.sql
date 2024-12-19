CREATE DATABASE `elibrarian`;

SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE  `e_books` (
  `book_id` INT NOT NULL AUTO_INCREMENT COMMENT 'book id',
  `callno` VARCHAR(50) NOT NULL UNIQUE COMMENT 'book call number',
  `book_name` VARCHAR(255) NOT NULL COMMENT 'book name',
  `author` VARCHAR(100) NULL COMMENT 'book author',
  `publisher` VARCHAR(100) NULL COMMENT 'book publisher',
  `book_quantity` INT NULL COMMENT 'book quantity',
  `book_issued` INT NULL COMMENT 'issued book quantity',
  PRIMARY KEY(book_id)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `e_issuebooks`;
CREATE TABLE `e_issuebooks` (
  `issue_id` INT NOT NULL AUTO_INCREMENT COMMENT 'issue book id',
  `issued_date` DATETIME NULL COMMENT 'book issue date',
  `return_status` ENUM("YES", "NO") COMMENT 'book return status',
  `book_id` INT NULL COMMENT 'book id',
  `stud_id` INT NULL COMMENT 'student id',
  PRIMARY KEY(issue_id),
  FOREIGN KEY(book_id) REFERENCES `e_books`(book_id),
  FOREIGN KEY(stud_id) REFERENCES `e_students`(stud_id)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `e_librarian`;
CREATE TABLE `e_librarian` (
  `lib_id` INT NOT NULL AUTO_INCREMENT COMMENT 'librarian id',
  `lib_name` VARCHAR(100) NOT NULL COMMENT 'librarian name',
  `lib_phone` VARCHAR(15) NULL COMMENT 'librarian phone number',
  `lib_email` VARCHAR(80) NULL COMMENT 'librarian email address',
  `u_id` INT NULL,
  PRIMARY KEY(lib_id),
  FOREIGN KEY(u_id) REFERENCES `e_users`(u_id)
) ENGINE=InnoDB;


DROP TABLE IF EXISTS `e_students`;
CREATE TABLE `e_students` (
  `stud_id` INT NOT NULL AUTO_INCREMENT COMMENT 'student id',
  `stud_name` VARCHAR(100) NOT NULL COMMENT 'student name',
  `stud_phone` VARCHAR(15) NULL COMMENT 'student phone number',
  `stud_email` VARCHAR(80) NULL COMMENT 'student email address',
  PRIMARY KEY(stud_id)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `e_users`;
CREATE TABLE `e_users` (
  `u_id` INT NOT NULL AUTO_INCREMENT COMMENT 'user id',
  `username` VARCHAR(20) NOT NULL UNIQUE COMMENT 'username',
  `password` VARCHAR(64) NOT NULL COMMENT 'hashed password',
  `secretkey` VARCHAR(44) NOT NULL COMMENT 'secretkey',
  `createtime` DATETIME NOT NULL COMMENT 'user created time',
  PRIMARY KEY(u_id)
) Engine=InnoDB;

SET FOREIGN_KEY_CHECKS=1;