--1--
DELIMITER \\
CREATE PROCEDURE usp_get_employees_salary_above_35000 ()
BEGIN 
SELECT e.first_name, last_name FROM employees AS e
WHERE e.salary > 35000
ORDER BY e.first_name, e.last_name;
END\\
DELIMITER ;
CALL usp_get_employees_salary_above_35000 ;

--2
DELIMITER \\
CREATE PROCEDURE usp_get_employees_salary_above (param DECIMAL (19, 4))
BEGIN
SELECT e.first_name, e.last_name FROM employees AS e 
WHERE e.salary >= param
ORDER BY e.first_name, e.last_name;
END\\
DELIMITER ;
CALL usp_get_employees_salary_above(45000);


DROP PROCEDURE IF EXISTS usp_get_towns_starting_with;
--3
DELIMITER \\
CREATE PROCEDURE usp_get_towns_starting_with(start_with VARCHAR(50))
BEGIN
SELECT t.name AS town_name FROM towns AS t
WHERE LEFT(t.name, CHAR_LENGTH(start_with)) = start_with
ORDER BY town_name;
END\\
DELIMITER ;
CALL usp_get_towns_starting_with('B');

DROP PROCEDURE IF EXISTS usp_get_employees_from_town;
--3 variant2--
DELIMITER \\
CREATE PROCEDURE usp_get_towns_starting_with(start_with VARCHAR(50))
BEGIN
SELECT t.name AS town_name FROM towns AS t
WHERE t.name  LIKE CONCAT(start_with, '%')
ORDER BY town_name;
END\\
DELIMITER ;

--4--
DELIMITER \\
CREATE PROCEDURE usp_get_employees_from_town (town_name VARCHAR(15))
BEGIN
SELECT e.first_name, e.last_name FROM employees AS e
JOIN addresses AS a USING(address_id)
JOIN towns AS t USING (town_id)
WHERE t.name = town_name
ORDER BY e.first_name, last_name;
END\\
DELIMITER ;
CALL usp_get_employees_from_town ('Sofia');
DROP FUNCTION IF EXISTS ufn_get_salary_level ;

--5--
DELIMITER \\
CREATE FUNCTION ufn_get_salary_level (salary DECIMAL (9,2))
RETURNS VARCHAR (10) DETERMINISTIC
BEGIN
RETURN CASE
WHEN salary < 30000 THEN 'Low'
WHEN salary BETWEEN 30000 AND 50000 THEN 'Average'
ELSE 'High'
END;
END\\
DELIMITER ;
SELECT 
    125500.00 AS Salary,
    UFN_GET_SALARY_LEVEL(125500.00) AS salary_level;

DROP PROCEDURE IF EXISTS usp_get_employees_by_salary_level;
--6
DELIMITER \\
CREATE PROCEDURE usp_get_employees_by_salary_level (salary_level VARCHAR (10))
BEGIN
SELECT e.first_name, e.last_name FROM employees AS e
WHERE ufn_get_salary_level(e.salary) = salary_level
ORDER BY e.first_name DESC, e.last_name DESC;
END\\
DELIMITER ;
CALL usp_get_employees_by_salary_level ('High');

--7--
DELIMITER $$

CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50),word varchar(50))
RETURNS BIT
DETERMINISTIC
BEGIN
RETURN IF(LOWER(word) REGEXP CONCAT('^[', LOWER(set_of_letters), ']+$'), TRUE, FALSE);
END $$

SELECT ufn_is_word_comprised('oistmiahf','Sofia');

DROP PROCEDURE IF EXISTS usp_get_holders_full_name ;

--8--
DELIMITER \\
CREATE PROCEDURE usp_get_holders_full_name ()
BEGIN
SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM account_holders
ORDER BY full_name;
END\\

DELIMITER ;
CALL usp_get_holders_full_name ;

DROP PROCEDURE IF EXISTS usp_get_holders_with_balance_higher_than;

--9--
DELIMITER \\
CREATE PROCEDURE usp_get_holders_with_balance_higher_than (param DECIMAL (9, 4))
BEGIN
SELECT a_h.first_name, a_h.last_name AS full_name FROM account_holders AS a_h
JOIN accounts AS a ON a.account_holder_id = a_h.id
GROUP BY (a_h.id)
HAVING SUM(a.balance) > param
ORDER BY a_h.id;
END\\

DELIMITER ;
CALL usp_get_holders_with_balance_higher_than(7000);


DROP FUNCTION IF EXISTS ufn_calculate_future_value ;

--10--
DELIMITER \\
CREATE FUNCTION ufn_calculate_future_value (initsial_sum DECIMAL (19,4),  yearly_interested_rate DECIMAL(19,4), years INT)
RETURNS DECIMAL (19,4) DETERMINISTIC
BEGIN
RETURN initsial_sum * POW((1+ yearly_interested_rate), years);
END\\
DELIMITER ;
SELECT ufn_calculate_future_value(123.1200, 0.1, 5);


DROP PROCEDURE IF EXISTS usp_calculate_future_value_for_account;

--11--
DELIMITER \\
CREATE PROCEDURE usp_calculate_future_value_for_account (account_id INT, interest_rate DECIMAL (19,4))
BEGIN
SELECT a.id AS account_id, ah.first_name AS first_name, ah.last_name AS last_name, 
a.balance AS current_balance,
ufn_calculate_future_value(a.balance, interest_rate, 5) AS balance_in_5_years
FROM accounts AS a
JOIN account_holders AS ah ON a.account_holder_id = ah.id
WHERE a.id = account_id;
END\\
DELIMITER ;
CALL usp_calculate_future_value_for_account (1, 0.1 );

DROP PROCEDURE IF EXISTS usp_deposit_money;


--12--
DELIMITER \\
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4)) 
BEGIN
START TRANSACTION;
CASE 
WHEN money_amount <=0 THEN ROLLBACK;
ELSE UPDATE accounts
SET balance = balance + money_amount
WHERE id = account_id;
END CASE;
END \\
DELIMITER ;
CALL usp_deposit_money(1, 10);
SELECT a.id, a.account_holder_id, a.balance FROM accounts AS a
WHERE a.id = 1;

DROP PROCEDURE IF EXISTS usp_withdraw_money;

--12V2--
DELIMITER \\
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4)) 
BEGIN
START TRANSACTION;
IF (SELECT COUNT(*) FROM accounts WHERE id = account_id) = 0 
OR money_amount < 0 THEN ROLLBACK;
ELSE UPDATE accounts
SET balance = balance + money_amount
WHERE id = account_id;
END IF;
END \\
DELIMITER ;

--13--
DELIMITER \\
CREATE PROCEDURE usp_withdraw_money (account_id INT, amount DECIMAL (19,4))
BEGIN
START TRANSACTION;
CASE 
WHEN amount < 0 OR 
(SELECT balance FROM accounts WHERE id =account_id) < amount OR 
(SELECT COUNT(*) FROM accounts WHERE id = account_id) = 0 THEN ROLLBACK;
ELSE UPDATE accounts
SET balance = balance - amount WHERE id = account_id;
END CASE;
END\\
DELIMITER ;
CALL usp_withdraw_money(1, 10);
SELECT a.id, a.account_holder_id, a.balance FROM accounts AS a
WHERE a.id = 1;

DROP PROCEDURE IF EXISTS usp_transfer_money;

--14--
DELIMITER \\
CREATE PROCEDURE usp_transfer_money (from_account_id INT, to_account_id INT, amount DECIMAL (19,4))
BEGIN
START TRANSACTION;
CASE 
WHEN amount < 0 
OR (SELECT balance FROM accounts WHERE id = from_account_id) < amount 
OR (SELECT COUNT(*) FROM accounts WHERE id = to_account_id) = 0 
 OR (SELECT COUNT(*) FROM accounts WHERE id = from_account_id) = 0
 OR from_account_id = to_account_id THEN ROLLBACK;
ELSE UPDATE accounts
SET balance = balance + amount WHERE id = to_account_id;

UPDATE accounts
SET balance = balance - amount WHERE id = from_account_id;
END CASE;
END\\
DELIMITER ;

CALL usp_transfer_money(2,1,10);

SELECT a.id, a.account_holder_id, a.balance
FROM accounts AS a
WHERE a.id IN (1, 2);

/*--15--*/

CREATE TABLE `logs` (
log_id INT PRIMARY KEY AUTO_INCREMENT,
account_id INT, 
old_sum DECIMAL (19,2), 
new_sum DECIMAL (19,2));

DROP TRIGGER IF EXISTS tr_logs_change_ammount ;
DELIMITER \\

CREATE TRIGGER tr_logs_change_ammount
AFTER UPDATE
ON accounts
FOR EACH ROW
BEGIN
IF new.balance != old.balance THEN
INSERT INTO `logs` (account_id, old_sum, new_sum)
VALUES (OLD.id, old.balance, new.balance);
END IF;
END\\ 
DELIMITER ;
CALL usp_withdraw_money(1, 10);

CALL usp_deposit_money(1,10);
SELECT * FROM `logs`;


/*--16--*/

CREATE TABLE notification_emails(id INT PRIMARY KEY AUTO_INCREMENT, 
recipient INT UNSIGNED NOT NULL, 
`subject` VARCHAR(100) NOT NULL, 
body VARCHAR(100) NOT NULL);

DROP TABLE notification_emails;

DROP TRIGGER IF EXISTS tr_notification_emails;
DELIMITER \\
CREATE TRIGGER tr_notification_emails
AFTER INSERT
ON `logs`
FOR EACH ROW
BEGIN
INSERT INTO notification_emails(recipient, `subject`, body)
VALUES (NEW.account_id, CONCAT('Balance change for account: ', NEW.account_id), 
CONCAT('On ', DATE_FORMAT(NOW(), '%b %d %Y at %r'), ' your balance was changed from ', NEW.old_sum, ' to ', NEW.new_sum, '.'));
END\\

DELIMITER ; 

