CREATE TABLE `mountains` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20)
);
CREATE TABLE `peaks` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20),
    mountain_id INT,
    FOREIGN KEY (mountain_id)
        REFERENCES `mountains` (id)
);

SELECT v.driver_id, v.vehicle_type, 
CONCAT(c.first_name, ' ', c.last_name) AS 'driver_name' FROM
 campers AS c
 JOIN vehicles AS v ON  c.id = v.driver_id ;
 SELECT r.starting_point AS 'route_starting_point', r.end_point AS 'route_ending_point', r.leader_id,
 CONCAT(c.first_name, ' ', c.last_name) AS 'leader_name' FROM
 campers AS c
 JOIN routes AS r ON r.leader_id = c.id;
 CREATE TABLE mountains(
 id INT PRIMARY KEY AUTO_INCREMENT,
 `name` VARCHAR(20));
 CREATE TABLE peaks(
 id INT PRIMARY KEY AUTO_INCREMENT,
 `name` VARCHAR(20),
 mountain_id INT,
 CONSTRAINT fk_peaks_mountains
 FOREIGN KEY peaks(mountain_id)
 REFERENCES mountains(id)
 ON DELETE CASCADE);
 CREATE DATABASE demo;
 USE demo;
 CREATE TABLE clients(
 id INT (11),
 client_name VARCHAR(100));
 ALTER TABLE clients
 ADD CONSTRAINT pk_id
 PRIMARY KEY(id);
 
 CREATE TABLE emplyoees(
 id INT(11) PRIMARY KEY,
 first_name VARCHAR(30),
  last_name VARCHAR(30),
  project_id INT(11)
 );
CREATE TABLE projects(
id INT(11),
client_id INT(11),
project_lead INT (11),
CONSTRAINT fk_projects_clients
FOREIGN KEY projects(client_id)
REFERENCES clients(id),
CONSTRAINT fk_projects_employees
FOREIGN KEY projects(project_lead)
REFERENCES employees(id));
ALTER TABLE projects
ADD CONSTRAINT pk_id
PRIMARY KEY(id);
ALTER TABLE employees
ADD CONSTRAINT fk_employees_projects
FOREIGN KEY employees(project_id)
REFERENCES projects(id);
CREATE TABLE `teachers`(
teacher_id INT PRIMARY KEY,
`name` VARCHAR(20),
manager_id INT);

INSERT INTO teachers ()
VALUES (101, 'John', null), (102, 'Maya', 106), (103, 'Silvia', 106), (104, 'Ted', 105), 
(105, 'Silvia', 101), (106, 'Ted', 101);
ALTER TABLE teachers
ADD CONSTRAINT fk_teachers_teachers
FOREIGN KEY (manager_id)
REFERENCES teachers(teacher_id);


CREATE DATABASE demo2;
USE demo2;
CREATE TABLE `cities` (
city_id INT(11) AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50));
CREATE TABLE `customers`(
customer_id INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50),
birthday DATE,
city_id INT(11),
CONSTRAINT fk_customers_cities
FOREIGN KEY customers(city_id)
REFERENCES cities(city_id));

CREATE TABLE `orders`(
order_id INT(11) PRIMARY KEY AUTO_INCREMENT,
customer_id INT(11),
CONSTRAINT fk_orders_customers
FOREIGN KEY orders(customer_id)
REFERENCES customers(customer_id));
CREATE TABLE item_types(
item_type_id INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50));
CREATE TABLE `items`(
item_id INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50),
item_type_id INT(11),
CONSTRAINT fk_items_item_types
FOREIGN KEY items(item_type_id)
REFERENCES item_types(item_type_id));
CREATE TABLE `order_items`(
order_id INT(11),
item_id INT (11),
CONSTRAINT pk_order_items
PRIMARY KEY (order_id, item_id),
CONSTRAINT fk_order_items_orders
FOREIGN KEY order_items(order_id)
REFERENCES orders(order_id),
CONSTRAINT fk_order_items_items
FOREIGN KEY order_items(item_id)
REFERENCES items(item_id));
CREATE SCHEMA newSCHEMA;
USE newSCHEMA;
CREATE TABLE `subjects`(
subject_id INT(11) PRIMARY KEY AUTO_INCREMENT,
subject_name VARCHAR(50));
CREATE TABLE `majors`(
major_id INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50));
CREATE TABLE `students`(
student_id INT(11) PRIMARY KEY AUTO_INCREMENT,
student_number VARCHAR (12),
student_name VARCHAR(50),
major_id INT(11),
CONSTRAINT fk_students_majors
FOREIGN KEY students(major_id)
REFERENCES majors(major_id));
CREATE TABLE `agenda`(
student_id INT(11),
subject_id INT(11),
CONSTRAINT pk_agenda
PRIMARY KEY (student_id, subject_id),
CONSTRAINT fk_agenda_subjects
FOREIGN KEY agenda(subject_id)
REFERENCES subjects(subject_id),
CONSTRAINT fk_agenda_students
FOREIGN KEY agenda(student_id)
REFERENCES students(student_id));
CREATE TABLE `payments`(
payment_id INT(11) PRIMARY KEY AUTO_INCREMENT,
payment_date DATE,
payment_amount DECIMAL(8,2),
student_id INT(11),
CONSTRAINT fk_payments_students
FOREIGN KEY payments(student_id)
REFERENCES students(student_id));

USE soft_uni;
ALTER TABLE employees
ADD CONSTRAINT employee_manager_id
FOREIGN KEY (manager_id)
REFERENCES employees(employee_id);

ALTER TABLE departments
ADD CONSTRAINT fk_depatments_employees
FOREIGN KEY departments(manager_id)
REFERENCES employees(manager_id);

ALTER TABLE employees
ADD CONSTRAINT fk_employee_departments
FOREIGN KEY employees(department_id)
REFERENCES departments(department_id);

USE geography;

SELECT m.mountain_range, p.peak_name, p.elevation AS 'peak_elevation'
FROM mountains AS m
JOIN peaks AS p
ON m.id = p.mountain_id
WHERE mountain_range = 'Rila'
ORDER BY peak_elevation DESC;

