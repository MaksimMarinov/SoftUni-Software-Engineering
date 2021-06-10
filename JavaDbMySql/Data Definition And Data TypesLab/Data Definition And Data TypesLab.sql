#1
CREATE TABLE `employees` (
  `id` INT(11) AUTO_INCREMENT PRIMARY KEY ,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL)
;
CREATE TABLE `categories` (
  `id` INT(11) AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `products` (
  `id` INT(11) PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `category_id` INT(11) NOT NULL);
  
  #2
  INSERT INTO employees(id, first_name, last_name)
VALUES (1, 'test', 'test'),
(2, 'test', 'test'), (3, 'test', 'test');
#3
ALTER TABLE employees
ADD COLUMN `middle_name` VARCHAR(45) NULL;
#4
ALTER TABLE `products`
ADD CONSTRAINT  FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`);
#5
ALTER TABLE `employees` modify column `middle_name` varchar(100);