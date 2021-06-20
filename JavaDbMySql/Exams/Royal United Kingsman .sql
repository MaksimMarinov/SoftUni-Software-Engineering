

CREATE TABLE branches(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL UNIQUE);

CREATE TABLE employees(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
salary DECIMAL(10,2) NOT NULL,
started_on DATE NOT NULL,
branch_id INT (11) NOT NULL,
CONSTRAINT fk_employees_branches
FOREIGN KEY (branch_id)
REFERENCES branches(id));

CREATE TABLE clients(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
full_name VARCHAR (50) NOT NULL,
age INT(11) NOT NULL );

CREATE TABLE employees_clients(
employee_id INT(11),
client_id INT(11),
CONSTRAINT pk_employee_client
PRIMARY KEY(employee_id, client_id),
CONSTRAINT fk_employees_clients_employees
FOREIGN KEY (employee_id)
REFERENCES employees(id),
CONSTRAINT fk_employees_clients_clients
FOREIGN KEY (client_id)
REFERENCES clients(id) );

CREATE TABLE bank_accounts(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
account_number VARCHAR(10) NOT NULL,
balance DECIMAL (10,2) NOT NULL,
client_id INT(11) NOT NULL UNIQUE,
CONSTRAINT bank_accounts_clients
FOREIGN KEY (client_id)
REFERENCES clients(id));

CREATE TABLE cards(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
card_number VARCHAR(19) NOT NULL,
card_status VARCHAR(7) NOT NULL,
bank_account_id INT (11) NOT NULL,
CONSTRAINT cards_bank_accounts
FOREIGN KEY (bank_account_id)
REFERENCES bank_accounts(id));

INSERT INTO cards (card_number, card_status, bank_account_id )
SELECT REVERSE(c.full_name), 'Active', c.id
FROM clients AS c
WHERE c.id BETWEEN 191 AND 200;

UPDATE employees_clients as ec
JOIN
(SELECT ec1.employee_id, COUNT(ec1.client_id) AS 'count'
		FROM employees_clients as ec1 
		GROUP BY ec1.employee_id
		ORDER BY `count`, ec1.employee_id) AS s
SET ec.employee_id = s.employee_id
WHERE ec.employee_id = ec.client_id;

DELETE FROM employees
WHERE id NOT IN(SELECT employees_id FROM employees_clients);

SELECT id, CONCAT(first_name,' ', last_name) AS full_name, CONCAT('$',salary) AS salary, started_on
FROM employees
WHERE salary >= 100000 AND DATE(started_on) >= '2018-01-01'
ORDER BY salary DESC;

SELECT ca.id, CONCAT(ca.card_number,' : ', cl.full_name) AS card_token
FROM cards AS ca
JOIN bank_accounts AS b ON b.id = ca.bank_account_id
JOIN clients as cl ON cl.id = b.client_id
ORDER BY ca.id DESC;

SELECT CONCAT(e.first_name, ' ', e.last_name) AS 'name', e.started_on, (SELECT COUNT(ec.client_id)) AS count_of_clients
FROM employees AS e
JOIN employees_clients AS ec ON ec.employee_id = e.id
WHERE ec.employee_id = e.id 
GROUP BY(ec.employee_id)
ORDER by count_of_clients DESC, e.id
LIMIT 5;

SELECT br.name, COUNT(ca.id) AS count_of_cards
FROM branches AS br
LEFT JOIN employees AS e ON e.branch_id = br.id
LEFT JOIN employees_clients AS ec ON ec.employee_id = e.id
LEFT JOIN clients AS cl ON ec.client_id = cl.id
LEFT JOIN bank_accounts AS ba ON ba.client_id = cl.id
LEFT JOIN cards AS ca ON ca.bank_account_id = ba.id
GROUP BY br.id
ORDER BY count_of_cards DESC, br.name;


DELIMITER \\
CREATE FUNCTION udf_client_cards_count(input_name VARCHAR(30)) 
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(ca.id) FROM clients AS cl
JOIN bank_accounts AS b ON b.client_id = cl.id
JOIN cards AS ca ON ca.bank_account_id = b.id
WHERE cl.full_name = input_name
GROUP BY cl.id) 
 ;
END\\ 
DELIMITER ;

SELECT c.full_name, udf_client_cards_count('Baxy David') as `cards` FROM clients c
WHERE c.full_name = 'Baxy David';

DELIMITER \\
CREATE PROCEDURE udp_clientinfo (input_full_name VARCHAR(50))
BEGIN
SELECT cl.full_name, cl.age, ba.account_number, CONCAT('$',ba.balance) AS balance
FROM clients AS cl
JOIN bank_accounts as ba ON ba.client_id = cl.id
WHERE cl.full_name = input_full_name;
END\\
DELIMITER ;
CALL udp_clientinfo('Hunter Wesgate');