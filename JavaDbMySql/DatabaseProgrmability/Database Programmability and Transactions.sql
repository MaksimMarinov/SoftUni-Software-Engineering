
DELIMITER //
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(50))
RETURNS INT DETERMINISTIC
BEGIN
DECLARE emp_count INT;
SET emp_count := (SELECT COUNT(*) FROM employees
JOIN addresses USING(address_id)
JOIN towns AS t USING (town_id)
WHERE t.`name` = town_name );
RETURN emp_count;
END //
DELIMITER ;

SELECT ufn_count_employees_by_town('Sofia');
DROP FUNCTION ufn_count_employees_by_town;

DELIMITER $$
CREATE PROCEDURE usp_raise_salaries(
IN department_name VARCHAR(50)) 
BEGIN
UPDATE employees JOIN departments AS d USING (department_id)
SET salary = salary * 1.05
WHERE d.name = department_name;
END$$
DELIMITER ;
CALL usp_raise_salaries( 'Finance');
SELECT first_name, salary from employees
JOIN departments AS d USING (department_id)
WHERE d.name = 'Finance'
ORDER BY first_name, salary;

--CHECK--
DELIMITER \\
CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN 
START TRANSACTION;
 IF((SELECT count(employee_id) FROM employees WHERE employee_id like id) !=1) THEN ROLLBACK;
ELSE  UPDATE employees AS e SET salary = salary*1.05 
		WHERE e.employee_id = id;
        END IF;
END \\
DELIMITER ;
CALL usp_raise_salary_by_id(294);
SELECT salary from employees
WHERE employee_id = 294;
DROP TABLE IF EXISTS deleted_employees;
CREATE TABLE `deleted_employees`(
employee_id int(10) PRIMARY KEY, first_name varchar(50),
last_name varchar(50),
middle_name varchar(50),
job_title varchar(50),
department_id int(10), 
manager_id int(10),
hire_date timestamp(6),
salary decimal(19,4),
address_id int(10));

DELIMITER \\
CREATE TRIGGER tr_deleted_employees
AFTER DELETE
ON employees
FOR EACH ROW
BEGIN
	INSERT INTO deleted_employees     (first_name,last_name,middle_name,job_title,department_id,salary)
	VALUES(OLD.first_name,OLD.last_name,OLD.middle_name,OLD.job_title,OLD.department_id,OLD.salary);
END;
DELIMITER ;