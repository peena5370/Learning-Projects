CREATE TABLE  e_book (
	book_id			INT 			NOT NULL	AUTO_INCREMENT,
	callno 			VARCHAR(50)		NOT NULL	UNIQUE,
	book_name 		VARCHAR(255) 	NOT NULL, 
	author 			VARCHAR(100)	NULL,
	publisher 		VARCHAR(100)	NULL,
	book_quantity	INT				NULL,
	book_issued		INT				NULL, 
	PRIMARY KEY(book_id)
) ENGINE=InnoDB;

CREATE TABLE e_librarian (
	lib_id			INT				NOT NULL	AUTO_INCREMENT,
    lib_name		VARCHAR(100)	NOT NULL,
    lib_pass		VARCHAR(20)		NOT NULL,
    lib_email		VARCHAR(80)		NULL,
    lib_phone		VARCHAR(20)		NULL,
    PRIMARY KEY(lib_id)
)ENGINE=InnoDB;

CREATE TABLE e_issuebook (
	issue_id		INT				NOT NULL	AUTO_INCREMENT,
    stud_id			VARCHAR(100)	NOT NULL,
    stud_name		VARCHAR(100)	NOT NULL,
    stud_phone		VARCHAR(20)		NULL,
    issued_date		DATETIME		NULL,
    return_status	ENUM("YES", "NO"),
    book_id			INT,
    PRIMARY KEY(issue_id),
    FOREIGN KEY(book_id) REFERENCES e_book(book_id)
)ENGINE=InnoDB;
