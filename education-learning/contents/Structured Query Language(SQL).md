# SQL Database

### SQL Comment Symbol

- " -- " for single line comment
- " /**/ " for multiple line comment

### SQL Queries

```sql
-- use database
USE db_name;
-- show database list
SHOW databases;
-- show al tables in a database
SHOW TABLES;
-- shows selected data field from specific table
SELECT (fieldName / * ) FROM tableName;
SELECT tableName.fieldName, tableName2.fieldName2 FROM dbName.tableName;
-- limit read from no5 rows and column number 5
LIMIT 5, 5;
```

### Sorting Queries

```sql
SELECT fieldName1, fieldName2, fieldName3 FROM tableName ORDER BY fieldName1, fieldName2 DESC;
```

### Search Queries

```sql
SELECT fieldName1, fieldName2 FROM tableName WHERE fieldName2 = 'String' / values;
```

### Search Queries operators

```sql
=, <>, !=, <, <=, >, >=, BETWEEN A AND B, IS NULL
```

### Filter operators

```sql
SELECT fieldName1, fieldName2, fieldName3 FROM tableName WHERE fieldName4 = 'String' AND fieldName2 <= 10;
AND, OR, IN, NOT, NOT IN 
WHERE fieldName4 IN ('String1','String2');
-- use for searching certain words start from symbol " % " / " _ " 
WHERE fieldName4 LIKE 'jet%';
```

### SQL Regular Expression

- Similar with other programming language regex usage, use for searching words, characters, digits and more

```sql
WHERE fieldName REGEXP '.XXX | .XXXX' ORDER BY fieldName;
```

### Concatenate between one field to another field

- Format concat will like fieldName1Value (fieldName2Value)

```sql
SELECT Concat( fieldName1, ' (', fieldName2, ')') AS tableTitle FROM tableName ORDER BY fieldName;
/* Trim the whitespaces between the fields
*  RTrim(fieldName) --> trim right whitespace
*  LTrim(fieldName) --> trim left whitespace
*/
Concat( RTrim(fieldName1), '(', LTrim(fieldName2), ')')
```

### Table calculation

- Calculation operators
  +(plus), -(minus), *(devide), /(subtract)

```sql
SELECT id, quantity, item_price, quantity*item_price AS totalPrice FROM tableName WHERE orderNum = 10001;
```

### Query Operation functions

- use to add up, trim, toUpper or many more

```sql
Left(), Right() -- return left string, return right string
Length() -- return length
Locate() -- locate char in certain strings
Lower(), Upper() -- lowercasem uppercase
LTrim(), RTrim() -- trim left whitespace, trim right whitespace
Soundex(fieldName) = Soundex('string') -- function like return sound similar like the string query
SubString() -- return substring
-- DateTime functional query
AddDate(), AddTime()
CurDate(), CurTime()
Date()
DateDiff()
Date_Add()
Date_Format()
Day()
DayOfWeek()
Hour()
Minute()
Month()
Now()
Second()
Time()
Year()
-- Example
WHERE Date(fieldNameDate) = '2020-08-01';
SELECT fieldName1, fieldName2 FROM tableName WHERE Year(fieldNameDate) = 2020 AND Month(fieldNameDate) = 8;
-- Mathematical functional query
Abs(), Cos(), Exp(), Mod(), Pi(), Rand(), Sin(), Sqrt(), Tan()
```

### Functional query calculation

```sql
AVG()
-- return average value from the selected field
SELECT AVG(fieldName) AS newFieldName FROM tableName WHERE fieldName2 = 1003;
SELECT AVG(DISTINCT fieldName) AS newFieldName FROM tableName WHERE fieldName2 =  1003;
COUNT()
-- IF COUNT(*), it will count all column values include null value, if COUNT(fieldName), it wont count in the null value from the field column
SELECT COUNT(fieldName / *) AS newFieldName FROM tableName;
MAX()
-- return maximum value from the field selected
SELECT MAX(fieldName) AS newFieldName FROM tableName;
MIN()
-- return minimum value from the field selected
SELECT MIN(fieldName) AS newFieldName FROM tableName;
SUM()
-- total all the values in the selected field
SELECT SUM(fieldName) AS newFieldName FROM tableName WHERE selectedFieldName = 20005;
-- Combination of functional query calculation
SELECT COUNT(*) AS countField, MIN(fieldName1) AS minFieldName, MAX(fieldName1) AS maxFieldName, AVG(fieldName1) AS avgFieldName FROM tableName;
```

### Data Grouping Query

```sql
-- normal GROUP BY query
SELECT fieldName, COUNT(*) AS newFieldName FROM tableName GROUP BY fieldName;
-- HAVING query, usage similar as WHERE
SELECT fieldName, COUNT(*) AS newFiledName FROM tableName GROUP BY fieldName HAVING COUNT(*) >= 2;
-- ORDER BY, similar as GROUP BY but can be use for after calculation or functions
SELECT fieldName, SUM(quantity*itemPrice) AS newFieldName FROM tableName GROUP BY fieldName HAVING SUM(quantity*itemProce) >= 50 ORDER BY totalSum;
```

### Subqueries

```sql
-- Example1
SELECT id FROM orders WHERE orderNum IN (SELECT orderNum FROM orderitems WHERE prodID = 'string');
-- Example2 - Correlated subquery
SELECT custName, custState, (SELECT COUNT(*) FROM orders WHERE orders.custID = customers.custID) AS orders FROM customers ORDER BY custName;
```

### Referential Integrity Table

- SETS is use to combine the results of 2 queries in 1 query

```sql
-- Example1 - Create linkage
SELECT custName, foodName, foodPrice FROM customers, foods WHERE custName.custID = foods.custID ORDER BY custName, foodName;
/* Example2 - Inner join
*  Joining 2 tables together to get the query results
*/
SELECT custName, foodName, foodPrice FROM customers INNER JOIN foods ON customers.custID = foods.custID;
/* Example3 - Connecting multiple tables
* Similar with inner WhHERE query, but inner join did it faster
* WHERE fieldName IN (SELECT.... WHERE fieldName2 IN
  (SELECT.... WHERE fieldName3 = 20005));
*/
SELECT foodName, custName, foodPrice, quantity FROM orders, foods, customers WHERE foods.custID = customers.custID AND orders.foodID = foods.foodID AND orderNumb = 20005;
-- Example4 - Outer Join
-- Left join
SELECT customers.custID, orders.orderNum FROM customers LEFT OUTER JOIN orders ON customers.custID = orders.custID;
-- Right join
SELECT customers.custID, orders.orderNum FROM customers RIGHT OUTER JOIN orders ON orders.custID = customers.custID;
-- Join with functional query
SELECT customers.custName, customers.custID, COUNT(orders.orderNum) AS numOfOrder FROM customers INNER JOIN orders ON customers.custID = orders.custID GROUP BY customers.custID;
SELECT customers.custName, customers.custID, COUNT(orders.orderNum) AS numOfOrder FROM customers LEFT OUTER JOIN orders ON customers.custID = orders.custID GROUP BY customers.custID;
/* UNION 
*  use to combine 2 queries in 1 query, results will comes out in 1 table
*  normally use in more than 2 queries that need to combine to output in 1 query result
*/
-- Example1 - UNION Join wont output duplicate rows
SELECT custID, foodID, foodPrice FROM foods WHERE foodPrice <= 10 UNION SELECT custID, foodID, foodPrice FROM foods WHERE custID IN(1001, 1002);
-- Example2 - UNION ALL will include all output include duplicate data
SELECT custID, foodID, foodPrice FROM foods WHERE foodPrice <=10 UNION ALL SELECT custID, foodID, foodPrice FROM foods WHERE custID IN (1001, 1002);
```

### SQL Note Searching

- Entire notes output from SQL queries
- need to declare the table with ENGINE=MyISAM( Default InnoDB is not usable for searching full text notes)

```sql
-- Creating table
CREATE TABLE textNotes (
  noteID  int NOT NULL  AUTO_INCREMENT,
  prodID  char(10)  NOT NULL,
  noteDate  datetime  NOT NULL,
  noteText  text  NULL,
  PRIMARY KEY(noteID),
  FULLTEXT(noteText)
) ENGINE=MyISAM;
/* Functional Queries 
*  Keywords: Match(fieldName) and Against('text')
*  Operators: +string, -string, >string, <string, (string), ~string, *, "full string"
*/
SELECT noteText FROM textNotes WHERE Match(noteText) Against('string');
-- For searching full text result
SELECT noteText FROM textNotes WHERE Match(noteText) Against('string' WITH QUERY EXPANSION);
-- Boolean mode
SELECT noteText FROM textNotes WHERE Match(noteText) Against('string1 string2' IN BOOLEAN MODE);
```

### SQL INSERT

```sql
-- Insert into single row
INSERT INTO customers(custName, custAddr, custCity, custState, custZIP, custCountry, custContact, custEmail) VALUES('customer name','customer address', 'customer city', 'customer state', 'ZIP number', 'country name', NULL, NULL);
-- Insert into multiple rows(needs to split out 2 queries with " ; " symbol)
-- Example 1
INSERT INTO customers(custName, custAddr, custCity, custState, custZIP, custCountry, custContact, custEmail) VALUES('customer name','customer address', 'customer city', 'customer state', 'ZIP number', 'country name', NULL, NULL);
INSERT INTO customers(custName, custAddr, custCity, custState, custZIP, custCountry, custContact, custEmail) VALUES('customer name','customer address', 'customer city', NULL, NULL, 'country name', 'contact number', 'email address');
-- Example 2
INSERT INTO customers(custName, custAddr, custCity, custState, custZIP, custCountry, custContact, custEmail) VALUES('customer name','customer address', 'customer city', 'customer state', 'ZIP number', 'country name', NULL, NULL), ('customer name','customer address', 'customer city', NULL, NULL, 'country name', 'contact number', 'email address');
-- Insert data from taking other table data to target table
INSERT INTO customers(custName, custAddr, custCity, custState, custZIP, custCountry, custContact, custEmail)
SELECT custName, custAddr, custCity, custState, custZIP, custCountry, custContact, custEmail FROM otherTable;
```

### SQL UPDATE And DELETE

```sql
-- Update to table
UPDATE customers SET custName = 'new customer name', custEmail = 'email@newmail.com' WHERE custID = 1004;
-- delete from table
DELETE FROM customers WHERE custID = 1005;
-- TRUNCATE table (will delete existing table all values but keep the table format)
TRUNCATE TABLE tableName;
```

### SQL TABLES

```sql
-- Creating a new table
CREATE TABLE tableName (
  fieldID int NOT NULL  AUTO_INCREMENT,
  fieldName char(50)  NOT NULL,
  fieldAddress  char(50) NULL,
  City  char(50)  NULL,
  fieldState char(5) NULL,
  fieldCode char(10) NULL,
  countryName char(50) NULL,
  contactNum  char(50)  NULL,
  emailAddr char(255) NULL,
  foreignkeyID  int,
  PRIMARY KEY(fieldID),
  FOREIGN KEY(foreignkeyID) REFERENCES tableName2(foreignkeyID)
) ENGINE=InnoDB;
-- Datatypes for declaring fieldName
fieldID int,
fieldDate datetime,
fieldPrice decimal(8,2),
fieldName char(50),
noteText text, -- needs to declare engine for the table as MyISAM and add FULLTEXT(noteText) when creating the table
PRIMARY KEY(fieldID, otherFieldName)
DEFAULT 1 -- Setting up default value for certain field
-- Alter table
ALTER TABLE tableName ADD newFieldName char(20);
ALTER TABLE tableName DROP COLUMN existFieldName;
-- Alter table in adding foreign keys
ALTER TABLE tableName1 ADD CONSTRAINT fk_tableName1_tableName2 FOREIGN KEY(orderNum) 
-- Alter table with multiple values
ALTER TABLE tableName1 ADD CONSTRAINT fk_tableName1_tableName3 FOREIGN KEY(prodID) REFERENCES tableName3(prodID), ADD CONSTRAINT fk_tableName1_tableName4 FOREIGN KEY(custID) REFERENCES tableName4(custID), ADD CONSTRAINT fk_tableName1_tableName5 FOREIGN KEY(restID) REFERENCES tableName5(restID);
-- Delete table
DROP TABLE tableName;
-- Rename table
RENAME TABLE tableName TO newTableName;
RENAME TABLE tableName1 TO newTableName1, tableName2 TO newTableName2, tableName3 TO newTableName3;
```

### SQL CREATE VIEW

- Create view is a new table that combines other tables into one view of 1 table
- To get CREATE VIEW table, u need to declare a SELECT () FROM ... query and make it become new view for the table
- For CREATE VIEW table, it also can use for INSERT, UPDATE, and DELETE query, if the view table have the following functions or query(GROUP BY, HAVING, JOINS, Min(), Count(), Sum() and etc.), it won't give to making updates to the view table

```sql
-- Example 1
CREATE VIEW newViewTable AS SELECT custName, contactNum, foodID FROM customers, orders, orderList WHERE customers.custID = orders.custID AND orderList.orderNum = orders.orderNum

SELECT custName, contactNum FROM newViewTable WHERE foodID = 'food004';
-- Example 2
CREATE VIEW orderItemValues AS SELECT orderNum, foodID, quantity, itemPrice, quantity*itemPrice AS totalPrice FROM orderList;

SELECT * FROM orderItemValues WHERE orderNum = 2005;
```

### PL/SQL - Procedural Language/SQL

```sql
-- Create and call procedure
CREATE PROCEDURE productpricing()
BEGIN 
    SELECT Avg(prodPrice) AS averagePrice
    FROM products;
END;
-- Call function for productpricing with parameter
CALL productpricing(@averagePrice);
CALL productpricing();
/* DELIMITER for symbol SQL(when need to have more thatn 2 " ; " symbol comes out) */
DELIMETER // 
CREATE PROCEDURE productpricing()
BEGIN 
    SELECT Avg(prodPrice) AS averagePrice
    FROM products;
END //
DELIMETER ;
-- Drop procedure
DROP PROCEDURE productpricing;
-- Create procedure with parameter
CREATE PROCEDURE productpricing( OUT prodL DECIMAL(8,2), OUT prodH DECIMAL(8,2), OUT prodA DECIMAL(8,2))
BEGIN
    SELECT Min(prodPrice) INTO prodL FROM products;
    SELECT Max(prodPrice) INTO prodH FROM products;
    SELECT Avg(prodPrice) INTO prodA FROM products;
END;
-- Call function(variable must be start at symbol @)
CALL productpricing(@priceLow, @priceHigh, @priceAverage);
SELECT @ priceAverage;
-- Procedure with IN(input) and OUT(output)
CREATE PROCEDURE totalOrder(IN orderNum INT, OUT totalOrder DECIMAL(8,2))
BEGIN
    Sum(itemPrice*quantity) FROM orderItems WHERE numOfOrder = orderNum INTO totalOrder;
END;

CALL totalOrder(2004, @total);
SELECT @total;
```

### Script with PL/SQL

```sql
-- Name: totalOrder
-- Parameter: orderNum = order number
--            taxable = 0 if not taxable, 1 if taxable
--            totalOrder = total order variable

CREATE PROCEDURE totalOrder(IN orderNum INT, IN taxable BOOLEAN, OUT totalOrder DECIMAL(8,2)) COMMENT 'Obtain total order and adding optional tax'
BEGIN
    -- declare total variable
    DECLARE total DECIMAL(8,2);
    -- declare tax percentage
    DECLARE taxrate INT DEFAULT 6;

    -- get the total order
    SELECT Sum(foodPrice*quantity) FROM foodList WHERE foodNum = orderNum INTO total;

    -- declare taxable(using conditional control)
    IF taxable THEN 
        -- If yes, add taxrate to the total variable
        SELECT total + (total / 100 * taxrate) INTO total;
    END IF;

    -- Finally, save to output variable(totalOrder)
    SELECT total INTO totalOrder;
END;

-- Output query
CALL totalOrder(2005, 0, @total);
SELECT @total;

-- Show procedure status
SHOW PROCEDURE STATUS LIKE 'totalOrder';
```

### SQL Cursor

```sql
-- Example 1
CREATE PROCEDURE processOrder()
BEGIN
    -- declare local variable
    DECLARE dont BOOLEAN DEFAULT 0;
    DECLARE order INT;

    -- declare cursor
    DECLARE orderNumber CURSOR
    FOR
    SELECT orderNum FROM orders;
    -- declare continue handler
    DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = 1;

    -- open the cursor
    OPEN orderNumber;

    -- loop through all rows
    REPEAT    
        -- get order number
        FETCH orderNumber INTO order;
    -- End loop
    UNTIL done END REPEAT;

    -- close the cursor
    CLOSE orderNumber;
END;

-- Example 2
CREATE PROCEDURE processOrder()
BEGIN
    -- declare local variable
    DECLARE done BOOLEAN DEFAULT 0;
    DECLARE order INT;
    DECLARE total DECIMAL(8,2);

    -- declare the cursor
    DECLARE orderNumber CURSOR
    FOR
    SELECT orderNum FROM orders;
    -- declare continue handler
    DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done=1;
    -- create a table to store result
    CREATE TABLE IF NOT EXISTS totalOrder (
      orderNum INT, 
      totalNum DECIMAL(8,2)
    );

    -- open the cursor
    OPEN orderNumber;

    -- loop through all rows
    REPEAT
        -- get order number
        FETCH orderNumber INTO order;
        -- get the total for this order
        CALL totalOrder(order, 1, total);
        -- insert order and total into totalOrder
        INSERT INTO totalOrder(orderNum, totalNum) VALUES(order, total);
    -- End loop
    UNTIL done END REPEAT;

    -- close the cursor
    CLOSE orderNumber;
END;

-- output the table
SELECT * FROM totalOrder;
```

### SQL Event Trigger

- Trigger event when using SQL query
- 4 things need for the trigger event
  1. trigger event name
  2. related table
  3. Query event
  4. when will execute and with message
- Format trigger event:
( CREATE TRIGGER tableName BEFORE/AFTER DELETE/INSERT/UPDATE ON dbTable FOR EACH ROW SELECT 'Output String')

```sql
-- Create trigger 
CREATE TRIGGER newProduct AFTER INSERT ON products FOR EACH ROW SELECT 'Product added';
-- Drop trigger
DROP TRIGGER newProduct;

-- DELETE Event
CREATE TRIGGER deleteOrder BEFORE DELETE ON orders FOR EACH ROW 
BEGIN
    INSERT INTO archiveOrder(orderNum, orderDate, custID) VALUES(OLD.orderNum, OLD.orderDate, OLD.custID);
END;

-- UPDATE Event
-- Can occur weather with OLD.data or NEW.data
CREATE TRIGGER updateVendor BEFORE UPDATE ON vendors FOR EACH ROW SET NEW.vendState = Upper(NEW.vendState);
```

### SQL Transaction Processing

- Occurs in following events:
    1. connect (START TRANSACTION)
    2. disconnect (COMMIT/ROLLBACK)
    3. commit (COMMIT)
    4. rollback (ROLLBACK)

```sql
-- Rollback transaction
SELECT * FROM totalOrder;
START TRANSACTION;
DELETE FROM totalOrder;
SELECT * FROM totalOrder;
ROLLBACK; -- use to rollback all transaction processing from START TRANSACTION
SELECT * FROM totalOrder;
-- Commit transaction (implicit commit)
START TRANSACTION;
DELETE FROM orderItem WHERE orderNum = 2010;
DELETE FROM orders WHERE orderNum = 2010;
COMMIT;
/* Savepoint
*  - use to making a save point for a transaction when need to rollback, it will rollback to the savepoint we made
*  - the more savepoint we made, the easier we can doing rollback because of mistake or error
*/
SAVEPOINT delete1;

ROLLBACK TO delete1;
-- Setup default COMMIT event
SET autocommit = 0;
```

### SQL Collation(Globalize/Localize)

- refers to a set of character and character encoding rules
- use to treat character data at the server,database or column level
- COLLATE is use to declare database, column and server language support from the input
- COLLATE (language-type)_cs will differentiate lower and upper case
- COLLATE (language-type)_ci will not check for lower and upper case
- Collate string to selected language with Cast() and Convert() function

```sql
-- Show database character set
SHOW CHARACTER SET;
-- Create table with COLLATE keyword
CREATE TABLE newTable (
  column1 INT,
  column2 VARCHAR(50),
  column3 VARCHAR(10) CHARACTER SET latin1 COLLATE latin1_general_ci
) DEFAULT CHARACTER SET hebrew COLLATE hebrew_general_ci;
-- Collate column
ALTER TABLE customers
ALTER COLUMN lastName CHAR(50) COLLATE hebrew_general_ci/database_default NOT NULL;
-- output collate table
SELECT * FROM customers ORDER BY lastName, firstName COLLATE latin1_general_cs;
```

### SQL Security Authentication

```sql
-- Select user
USE db_name;
SELECT user FROM user;
-- Create user
CREATE USER testUser IDENTIFIED BY 't3stP@s$w0rd';
-- Rename user
RENAME USER testUser TO newTestUser;
-- Delete user
DROP USER newTestUser;
-- Show and grant user access control on database
SHOW GRANTS FOR newTestUser;

GRANT SELECT ON new_db_name.* TO newTestUser;
-- Revoke/ rollback the access control
REVOKE SELECT ON new_db_name.* FROM newTestUser;

-- Grant access only for selected table on database
GRANT SELECT ON db_name.tableName TO newTestUser;

-- Change password(must use Password() function)
SET PASSWORD FOR newTestUser = Password('n3w P@s$w0rD');
```

### Database Maintenance

- Use for maintenance and read log for further improvements and repair
- Reading log using (--log-error) or at directory ../data
- Log file may have name called:
    1. hostname.log
    2. hostname.bin
    3. hostname.err
    4. hostname-slow.log

```sql
-- analyse database table
ANALYZE TABLE tableName;

CHECK TABLE tableName, tableName2;
```