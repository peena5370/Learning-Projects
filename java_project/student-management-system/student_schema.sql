CREATE DATABASE `student_schema`;

-- Create table query for student table
CREATE TABLE `student`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `studname` VARCHAR(100) NOT NULL,
    `dateofbirth` DATE NULL,
    `class` VARCHAR(10) NULL,
    `race` VARCHAR(50) NULL,
    `nationality` VARCHAR(50) NULL,
    PRIMARY KEY(`id`)
)ENGINE=INNODB;