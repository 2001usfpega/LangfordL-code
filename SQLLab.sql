//--SQL Lab

--2.0 SQL Queries
--2.1 SELECT
--Select all records from the Employee table
SELECT * FROM employee;
--Select all records from the Employee table where last name is King
SELECT * FROM employee WHERE lastname = 'King';
--Select all records from the Employee table where first name is Andrew and  
--REPORTSTO is NULL
SELECT * FROM employee WHERE firstname  = 'Andrew' AND reportsto IS NULL;

--2.2 ORDER BY
SELECT * FROM album;
--Select all albums in Album table and sort result set in descending order
--by title
SELECT  * FROM album ORDER BY title DESC;

SELECT * FROM customer;
--Select first name from Customer and sort result set in ascending order by
--city
SELECT firstname FROM customer ORDER BY city;

--2.3 INSERT INTO
--Insert two new records into Genre table
SELECT * FROM genre;
INSERT INTO genre VALUES(26, 'Unwrapped');
INSERT INTO genre VALUES(27, 'Crime Show');

--Insert two new records into Employee table
SELECT * FROM employee;
INSERT INTO employee VALUES(9, 'Robinson', 'Myra', 'Assistant General Manager',
    1, '12-DEC-75', '13-JAN-03', '500 1st Ave', 'Red Deer', 'AB', 'Canada', 
    'T4N-04A', '+1 (403) 764-6545', '+1 (403) 262-3320', 'myra@chinookcorp.com');
--DELETE FROM employee WHERE employeeid = 9;
INSERT INTO employee VALUES(10, 'Smith', 'Chance', 'HR Generalist', 1, 
    '05-JUN-78', '13-JAN-03', '1661 Edgreton Ave', 'Red Deer', 'AB', 'Canada', 
    'T4N-0C2', '+1 (587) 902-1234', '+1 (403) 262-9880', 'chance@chinookcorp.com');

--Insert two new records into Customer table    
SELECT * FROM customer;
INSERT INTO customer(customerid, firstname, lastname, company, address, city, state,
    country, postalcode, phone, fax, email, supportrepid) 
    VALUES(60, 'Ray', 'Roberts', null, '808 12th St NW', 'Denver', 'CO', 'USA',
    '80219', '+1 (303) 555 8230', null, 'rayroberts@bellsouth.net', 4);
INSERT INTO customer(customerid, firstname, lastname, company, address, city, state,
    country, postalcode, phone, fax, email, supportrepid) 
    VALUES(61, 'Laura', 'Black', null, 'Calle Neverman', 'San Jose', null, 'Costa Rica',
    '11493', '+506 7234 1221', null, 'laurab@ymail.com', 5);
    
--2.4 UPDATE
--Update Aaron Mitchell in Customer table to Robert Walker
SELECT * FROM customer;
UPDATE customer SET firstname = 'Robert' WHERE customerid = 32;
UPDATE customer SET lastname = 'Walter' WHERE customerid = 32;

--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
SELECT * FROM artist;
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Select all invoices with a billing address like “T%”
SELECT * FROM invoice;
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
--Select all invoices that have a total between 15 and 20
SELECT * FROM invoice;
SELECT * FROM invoice WHERE total BETWEEN 15 and 20;

--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee;
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' and '01-MAR-04';

--2.7 DELETE
--Delete a record in Customer table where the name is Robert Walter 
SELECT * FROM customer;

ALTER TABLE invoice
    DISABLE CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM customer WHERE customerid = 32;


--3.0 SQL Functions
--3.1 System Defined Functions
--Create a function that returns the current time.
SELECT current_timestamp FROM dual;

--Create a function that returns the length of name in MEDIATYPE table
SELECT * FROM mediatype;
SELECT length(name) FROM mediatype;

--3.2 System Defined Aggregate Functions
--Create a function that returns the average total of all invoices 
SELECT * FROM invoice;

CREATE OR REPLACE FUNCTION avg_price_invoice
RETURN NUMBER
IS
    avg_price NUMBER;
BEGIN
    SELECT AVG(total) INTO avg_price FROM invoice;
    RETURN avg_price;
END;
/
DECLARE
    avg_price NUMBER;
BEGIN
    avg_price := avg_price_invoice();
END;
/

--Create a function that returns the most expensive track
SELECT * FROM track;

CREATE OR REPLACE FUNCTION most_expensive_track
RETURN NUMBER
IS
    max_track NUMBER;
BEGIN
    SELECT MAX(unitprice) INTO max_track FROM track;
    RETURN max_track;
END;
/
DECLARE
    max_track NUMBER;
BEGIN
    max_track := most_expensive_track();
END;
/

--3.3 User Defined Scalar Functions
--Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT * FROM invoiceline;

CREATE OR REPLACE FUNCTION avg_price_invoiceline
RETURN NUMBER
IS
    avg_price NUMBER;
BEGIN
    SELECT AVG(unitprice) INTO avg_price FROM invoiceline;
    RETURN avg_price;
END;
/
DECLARE
    avg_price NUMBER;
BEGIN
    avg_price := avg_price_invoice();
END;
/

--3.4 User Defined Table Valued Functions
--Create a function that returns all employees who are born after 1968
SELECT * FROM employee;

CREATE OR REPLACE FUNCTION after_1968 RETURN SYS_REFCURSOR
IS
  employee_old SYS_REFCURSOR;
BEGIN
  OPEN employee_old FOR SELECT * FROM employee
                        WHERE birthdate >= TO_DATE('01-01-1968','DD-MM-YYYY');
  RETURN employee_old;
END;
/
SELECT after_1968 FROM dual;

--4.0 Stored Procedures
--4.1 Create a stored procedure that selects the first and last names of all the employees
SELECT * FROM employee;

CREATE OR REPLACE PROCEDURE select_employee
AS
BEGIN
SELECT 

END;
/

--4.2 Create a stored procedure that updates the personal information of an employee
SELECT * FROM employee;

CREATE OR REPLACE PROCEDURE update_info(
    e_id IN employee.employeeid%TYPE , l_name IN employee.lastname%TYPE
    , f_name IN employee.firstname%TYPE , tle IN employee.title%TYPE
    , report_to IN employee.reportsto%TYPE , dob IN employee.birthdate%TYPE
    , date_hired IN employee.hiredate%TYPE , adss IN employee.address%TYPE
    , city_up IN employee.city%TYPE , state_up IN employee.state%TYPE
    , coun IN employee.country%TYPE , p_code IN employee.postalcode%TYPE
    , phone_up IN employee.phone%TYPE , fax_up IN employee.fax%TYPE
    , email_up IN employee.email%TYPE)
IS
BEGIN
    UPDATE employee SET lastname =  l_name, firstname = f_name, title = tle,
    reportsto = report_to, birthdate = dob, hiredate = date_hired, address = adss,
    city = city_up, state = state_up, country = coun, postalcode = p_code,
    phone = phone_up, fax = fax_up, email = email_up WHERE employeeid = e_id;
    --COMMIT;
END;
/
--Create a stored procedure that returns the managers of an employee
SELECT * FROM employee;

CREATE OR REPLACE PROCEDURE mngr_of_emp(emp_id IN NUMBER, mng_id OUT employee.reportsto%TYPE)
IS
BEGIN
    SELECT reportsto INTO mng_id FROM employee WHERE employeeid = emp_id;
END;
/
DECLARE
    tempVar1 NUMBER(4);
BEGIN
    mngr_of_emp(6, tempVar1);
    DBMS_OUTPUT.PUT_LINE('Employee with id 6 reports to : ' || tempVar1);
END;
/

--4.3 Stored Procedure Output Parameters
--Create a stored procedure that returns the name and company of a customer
SELECT * FROM customer;

CREATE OR REPLACE PROCEDURE name_and_company(cust_id IN customer.customerid%TYPE,
    cust_fname OUT customer.firstname%TYPE, cust_lname OUT customer.lastname%TYPE,
    cust_comp OUT customer.company%TYPE)
IS
BEGIN
    SELECT firstname INTO cust_fname FROM customer WHERE customerid = cust_id;
    SELECT lastname INTO cust_lname FROM customer WHERE customerid = cust_id;
    SELECT company INTO cust_comp FROM customer WHERE customerid = cust_id;
END;
/
DECLARE
    tempVar1 VARCHAR2(4000);
    tempVar2 VARCHAR2(4000);
    tempVar3 VARCHAR2(4000);
BEGIN
    name_and_company(10, tempVar1, tempVar2, tempVar3);
    DBMS_OUTPUT.PUT_LINE('Customer name: ' || tempVar1 || ' ' || tempVar2 || ' Company: ' || tempVar3);
END;
/

--5.0 Transactions
--Create a transaction that given a invoiceId will delete that invoice (There may be constraints that 
--rely on this, find out how to resolve them)
SELECT * FROM invoice;

ALTER TABLE invoiceline DISABLE CONSTRAINT FK_InvoiceLineInvoiceId;
CREATE OR REPLACE PROCEDURE delete_invoice (invoice_id IN invoice.invoiceid%TYPE)
IS
BEGIN
    DELETE invoice WHERE invoiceid = invoice_id;   

END;
/

--Create a transaction nested within a stored procedure that inserts a new record in the Customer table
SELECT * FROM customer;

CREATE OR REPLACE PROCEDURE insert_new_customer(c_userid IN customer.customerid%TYPE
	   , c_firstname IN customer.firstname%TYPE, c_lastname IN customer.lastname%TYPE
       , c_company IN customer.company%TYPE, c_address IN customer.address%TYPE
       , c_city IN customer.city%TYPE, c_state IN customer.state%TYPE
       , c_country IN customer.country%TYPE, p_code IN customer.postalcode%TYPE
       , c_phone IN customer.phone%TYPE, c_fax IN customer.fax%TYPE
       , c_email IN customer.email%TYPE, c_supportid IN customer.supportrepid%TYPE)
IS
BEGIN
    INSERT INTO customer(customerid, firstname, lastname, company, address, city, state,
        country, postalcode, phone, fax, email, supportrepid)
    VALUES(c_userid, c_firstname, c_lastname, c_company, c_address, c_city, c_state, c_country,
        p_code, c_phone, c_fax, c_email, c_supportid);
    --COMMIT;
END;
/

--6.0 TRIGGERS
--6.1 AFTER/FOR
--Create an after insert trigger on the employee table fired after a new record is inserted into the table
SELECT * FROM employee;

CREATE OR REPLACE TRIGGER employee_insert_a
AFTER INSERT ON employee
BEGIN
    DBMS_OUTPUT.PUT_LINE('A new record was just inserted!');
END;
/
--tested this with question 2.3 so wouldn't have to create new insert - it works

--Create an after update trigger on the album table that fires after a row is inserted in the table
SELECT * FROM album;

CREATE OR REPLACE TRIGGER album_update_a
AFTER UPDATE ON album
BEGIN
    DBMS_OUTPUT.PUT_LINE('This table was updated with a new entry!');
END;
/
--to test:
--UPDATE album SET title = 'Best of Mozart' WHERE albumid = 346;

--Create an after delete trigger on the customer table that fires after a row is deleted from the table
SELECT * FROM customer;

CREATE OR REPLACE TRIGGER customer_delete_a
AFTER DELETE ON customer
BEGIN
    DBMS_OUTPUT.PUT_LINE('A row was deleted from the table.');
END;
/


--7.0 Joins
--7.1 INNER
--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceid
SELECT * FROM customer;
SELECT * FROM invoice;
SELECT a.firstname, a.lastname, b.invoiceid FROM customer a INNER JOIN invoice b ON a.customerid = b.customerid;

--7.2 OUTER
--Create an outer join that joins the customer and invoice table, specifying the customerid, firstname, lastname, invoiceid, and total
SELECT a.customerid, a.firstname, a.lastname, b.invoiceid, b.total FROM customer a FULL OUTER JOIN 
    invoice b ON a.customerid = b.customerid; 
    
--7.3 RIGHT
--Create a right join that joins album and artist specifying artist name and title
SELECT * FROM artist;
SELECT * FROM album; 
SELECT a.name, b.title FROM artist a RIGHT OUTER JOIN album b ON a.artistid = b.artistid;

--7.4 CROSS
--Create a cross join that joins album and artist and sorts by artist name in ascending order 
SELECT * FROM album a CROSS JOIN artist b ORDER BY b.name;

--7.5 SELF
--Perform a self-join on the employee table, joining on the reportsto column
SELECT * FROM employee;
SELECT * FROM employee a INNER JOIN employee b ON a.reportsto = b.reportsto;
    
